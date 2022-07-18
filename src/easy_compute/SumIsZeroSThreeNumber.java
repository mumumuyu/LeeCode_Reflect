package easy_compute;

import java.util.*;

/**
 * @Description:    数组为0的三个数
 *
 * 靠莽结果超时了，可恶啊
 * 315 / 318 个通过测试用例 最后三个太长了 😡
 *
 * @author: LGD
 * @date:2022/7/18 14:14
 */
public class SumIsZeroSThreeNumber {
    public static void main(String[] args) {
        int[] ints = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> lists = threeSum1(ints);
        for (List<Integer> list:lists){
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <= 2 || nums == null)
            return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();
        List<Set<Integer>> lists2 = new ArrayList<>();
        boolean flag = true;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length ; k++) {
                    if(2*nums[k]<-nums[i]) break;
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    if(nums[i] + nums[j] + nums[k] == 0) {
                        flag = true;

                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        Set<Integer> set = new HashSet<>(list);

                        for (Set<Integer> set2 : lists2) {
                            if(set.equals(set2)){
                                flag = false;
                                break;
                            }
                        }

                        if (flag) {
                            lists.add(list);
                            lists2.add(set);
                        }
                    }
                }
            }
        }

        return lists;
    }

    //可恶啊，超时了，改用双指针
    public static List<List<Integer>> threeSum1(int[] nums) {
        if(nums.length <= 2 || nums == null)
            return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0) break;
            //重复跳过
            if(i>0&&nums[i]==nums[i-1]) continue;
            int c = nums.length -1;
            for(int b = i+1;b<c;b++){
                //当2倍的nums[c]都比负nums[a]小，那么结果都是<0
                if(2*nums[c]<-nums[i]) break;
                //重复跳过
                if(b>i+1&&nums[b]==nums[b-1]) continue;
                while(b<c&&nums[b]+nums[c]+nums[i]>0){
                    c--;
                }
                if(b==c){
                    break;
                }
                if(nums[b]+nums[c]+nums[i]==0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[b]);
                    l.add(nums[c]);
                    lists.add(l);
                }
            }
        }

        return lists;
    }

}

