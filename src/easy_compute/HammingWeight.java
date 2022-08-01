package easy_compute;

/**
 * @Description:
 * @author: LGD
 * @date:2022/8/1 9:37
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight2(
                00_000_000_000_000_000_000_000_000_001_011));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }
}
