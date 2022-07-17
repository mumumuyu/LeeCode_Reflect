package easy_compute;

/**
 * @Description:    二进制加法
 * @author: LGD
 * @date:2022/7/17 20:57
 */
public class ErJinZhiJiaFa {
    public static void main(String[] args) {
        System.out.println(addBinary("10", "11"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sBuilder = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum =carry;
            if(i>=0)
                sum += a.charAt(i--) - '0';
            if(j>=0)
                sum += b.charAt(j--) - '0';
            carry = sum / 2;
            sBuilder.append(sum % 2);
        }

        if(carry>0)
            sBuilder.append(carry);

        return sBuilder.reverse().toString();
    }
}
