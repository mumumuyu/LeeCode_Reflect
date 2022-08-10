package GuiHua;

/**
 * @Description:   动态规划，好！  棋盘，右下路径和最大值
 * 执行用时：2 ms, 在所有 Java 提交中击败了97.70%的用户
 * 内存消耗：44.1 MB, 在所有 Java 提交中击败了30.91%的用户
 * @author: LGD
 * @date:2022/8/10 15:39
 */
public class MaxValue {
    public static void main(String[] args) {

    }

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int width = grid.length, len = grid[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < len; j++) {
                if (i == 0 && j == 0)   continue;
                if (i == 0)   grid[0][j] += grid[0][j-1];
                if (j == 0)   grid[i][0] += grid[i-1][0];
                if (i != 0 && j != 0) grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[width-1][len-1];

    }
}
