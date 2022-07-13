package order;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/12 8:59
 */
public class twoDivide {



    public static void main(String[] args) {
        System.out.println(firstBadVersion(7));
    }

    public static int firstBadVersion(int n) {
        int start = 1 , end = n;
        while(start  < end){
            //这种写法int过大可能会越界
            int mid = start + end >> 1;
            //这种相对好点
            //start / 2 + end / 2
            //这种更快
            //start + (end - start) / 2

            if(isBadVersion(mid)){
               end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static boolean isBadVersion(int n){
        if(n<4){
            return false;
        }else{
            return true;
        }
    }

}
