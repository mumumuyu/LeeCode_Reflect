package array;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description:
 *给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 执行用时：6 ms, 在所有 Java 提交中击败了24.15%的用户
 * 内存消耗：41.3 MB, 在所有 Java 提交中击败了26.55%的用户
 * @author: LGD
 * @date:2022/9/6 16:40
 */
public class LargestNumber {

    public static void main(String[] args) {

    }


    public String largestNumber(int[] nums) {
        Integer[] ins = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(ins,
                (a,b)->
                {

                long aw = 10,bw = 10;
                while(aw <= a){
                    aw *= 10;
                }
                while(bw <= b){
                    bw *= 10;
                }

                return (int) ((aw * b + a) - (bw * a + b));
                }
        );
        if(ins[0] == 0)
            return "0";
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer num: ins){
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
