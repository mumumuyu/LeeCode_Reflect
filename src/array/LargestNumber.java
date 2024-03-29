package array;

import com.sun.deploy.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
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
/*        String lalala = String.valueOf("lalala");
        char[] chars = lalala.toCharArray();
        chars[0] = 'g';
        System.out.println(lalala);*/
//        System.out.println(new Date().getTime());
        /*SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Calendar calendar = Calendar.getInstance();
        String format = df.format(calendar.getTime());
        System.out.println(format);*/
        Map<String, Set<String>> stopIdMap = new HashMap<>();
        ArrayList<String> lists = new ArrayList<>();
        lists.add("123");
        lists.add("234");
        lists.add("345");

        for(String stopId: lists) {
            if (stopIdMap == null || stopIdMap.size() <= 0 || stopIdMap.get("stopName") == null) {
                Set<String> nameSet = new HashSet<>();
                nameSet.add(String.valueOf(stopId));
                stopIdMap.put("stopName", nameSet);
            } else {
                stopIdMap.get("stopName").add(String.valueOf(stopId));
                stopIdMap.replace("stopName", stopIdMap.get("stopName"));
            }
        }
        System.out.println(StringUtils.join(Arrays.asList(stopIdMap.get("stopName").toArray()), ","));
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
