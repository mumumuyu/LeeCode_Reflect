package array;

import java.util.LinkedList;

/**
 * @Description:
 * 执行用时：1619 ms, 在所有 Java 提交中击败了5.07%的用户
 * 内存消耗：45.9 MB, 在所有 Java 提交中击败了25.92%的用户
 * @author: LGD
 * @date:2022/9/13 15:56
 */
class MovingAverage {

    LinkedList<Integer> doubles;

    int limit;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        doubles = new LinkedList<>();
        limit = size;
    }

    public double next(int val) {
        doubles.add(val);
        double sum = 0.0;
        if(doubles.size()<=limit){
            for (Integer dou:doubles){
                sum +=dou;
            }
            return sum/doubles.size();
        }else{
            for (int i = 1; i <= limit; i++) {
                Integer aDouble = doubles.get(doubles.size() - i);
                sum+=aDouble;
            }

            return sum/limit;
        }
    }
}
