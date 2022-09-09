package array;

import java.util.Scanner;

/**
 * @Description:
 * @author: LGD
 * @date:2022/9/8 17:42
 */
public class LongAndHu {
    /**
     * 5
     * [0,1,2,3,4,5]
     * m(分界) s1 p1 s2 给定一个p2让两边差最小
     * 例子
     * 6 表示共6个
     * 2 3 2 3 2 3
     * 4 6 4 4 以4为分界线 在第六个增加4，然后你有4个
     * 要点是注意 acm模式下，这种题题意标号尽量都先-1把题意下标变为数组下标
     *
     * 6
     * 2 3 2 3 2 3
     * 4 6 5 2
     *
     * return 2 yes!
     *
     * 6
     * 1 1 1 1 1 16
     * 5 6 2 2
     * return 1 yes!
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();

            if(s.equals("0"))
                return;

            String s3 = scanner.nextLine();
            String s4 = scanner.nextLine();

            int n = Integer.parseInt(s);

            String[] s1 = s3.split(" ");

            String[] s2 = s4.split(" ");

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }

            int jiexian = Integer.parseInt(s2[0]) - 1;
            int b1 = Integer.parseInt(s2[1]) - 1;
            int p1 = Integer.parseInt(s2[2]);
            int p2 = Integer.parseInt(s2[3]);

            nums[b1] += p1;

            int lSum = 0;
            int rSum = 0;

            for (int i = 0; i < jiexian; i++) {
                lSum += nums[i] * (jiexian - i);
            }

            int j = jiexian + 1;
            while (j < n) {
                rSum += nums[j] * (j - jiexian);
                j++;
            }

            int chaJu = Math.abs(lSum - rSum);
            int min = Integer.MAX_VALUE;
            int count = -1;
            for (int i = 0; i < n; i++) {
                if (i < jiexian) {
                    int newJu = Math.abs(lSum - rSum + p2 * (jiexian - i));
                    if (newJu < min) {
                        min = newJu;
                        count = i;
                    }
                } else if (i == jiexian) {
                    if (chaJu < min) {
                        min = chaJu;
                        count = i;
                    }
                } else if (i > jiexian) {
                    int newJu = Math.abs(lSum - rSum - p2 * (i - jiexian));
                    if (newJu < min) {
                        min = newJu;
                        count = i;
                    }
                }
            }
            System.out.println(count + 1);
        }
    }
}
