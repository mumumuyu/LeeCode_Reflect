package example;

/**
 * @Description:    矩阵中匹配单词
 * 执行用时：164 ms, 在所有 Java 提交中击败了5.35%的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了78.58%的用户
 * @author: LGD
 * @date:2022/8/10 10:33
 */
public class ExitWords {
    public static void main(String[] args) {
        char[][] exit = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist2(exit, "ABCCED"));
    }

    public static boolean exist2(char[][] board, String word) {
        int width = board.length,len = board[0].length;
        boolean[][] checked = new boolean[width][len];
        boolean result = false;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < len; j++) {
                result = check(board,word,i,j,checked,0);
                if(result)
                    return true;
            }
        }
        return false;
    }

    public static boolean check(char[][] board, String word,int i ,int j,boolean[][] checked,int index){
        if(board[i][j] != word.charAt(index)){
            return false;
        }else if (index == word.length()-1) {
            return true;
        }
        checked[i][j] = true;
        boolean result = false;
        int[][] dictionary = {{0,1},{1,0},{-1,0},{0,-1}};
        for (int k = 0; k < dictionary.length; k++) {
            int ni = i+dictionary[k][0],nj = j+dictionary[k][1];
            if(ni>=0 && ni < board.length && nj>=0 && nj < board[0].length) {
                if (!checked[ni][nj]) {
                    boolean checks = check(board, word, ni, nj, checked, index + 1);
                    if (checks) {
                        result = true;
                        break;
                    }
                }
            }
        }
        checked[i][j] = false;
        return result;
    }
}
