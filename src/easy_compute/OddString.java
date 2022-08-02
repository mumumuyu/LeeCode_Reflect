package easy_compute;

/**
 * @Description: 奇数个字符
 * @author: LGD
 * @date:2022/8/1 11:43
 */
public class OddString {
    public static String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n%2 == 0){
            for(int i = 1;i<=n-1;i++){
                sb.append("a");
            }
            sb.append("b");
        }else{
            for(int i = 1;i<=n;i++){
                sb.append("a");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateTheString(3));
    }
}
