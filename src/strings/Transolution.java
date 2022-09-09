package strings;

/**
 * @Description:
 * @author: LGD
 * @date:2022/9/9 10:13
 */
public class Transolution {
    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a.charAt(0));
    }

    public static String trans(String s, int n) {
        String[] strings = s.split(" ");
        int length = strings.length;
        for (int i = 0; i < length/2; i++){
            String temp = strings[i];
            strings[i] = strings[length-i-1];
            strings[length-i-1] = temp;
        }
        for (int i = 0; i < length; i++){
            strings[i] = exChange(strings[i]);
        }

        return String.join(" ",strings);
    }

    public static String exChange(String s){
        char[] chars = s.toCharArray();
        for(int i = 0 ; i<chars.length;i++){
            if (chars[i]>=97 && chars[i] <= 122){
                chars[i] = (char) (chars[i] - 32);
            } else if (chars[i]>=65 && chars[i] <= 90){
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return String.valueOf(chars);
    }

    //上面解法你可能就会问n呢？n干啥用，欸，对了，因为并不是严格按照字符间一个空格来的💔，所以老老实实遍历吧

    /**
     * 运行时间：180ms
     * 超过92.35% 用Java提交的代码
     * 占用内存：32300KB
     * 超过91.88%用Java提交的代码
     */
    public String trans2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = n-1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if(c == ' '){
                sb.append(" ");
                index=sb.length();
            }else {
                if (c >= 97 && c <= 122) {
                    c = (char) (c - 32);
                } else if (c >= 65 && c <= 90) {
                    c = (char) (c + 32);
                }
                sb.insert(index,c);
            }
        }
        return sb.toString();
    }
}
