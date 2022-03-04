package example;

import java.util.Currency;

public class ObjectsTest {
    public static void main(String[] args) {
        int[] a = new int[]{5,4,3,8,2,42,95};
        for(int i:a)
            System.out.print(i+" ");
        long start = System.currentTimeMillis();
        a = new ObjectsTest().ZhiJieChaRu(a);
        long end = System.currentTimeMillis();
        System.out.println(" ");
        for(int i:a)
            System.out.print(i+" ");
        System.out.println("共计花费"+(end-start)+"毫秒");
    }
    //手搓冒泡
    /**
     * 思路：就是俩层循环，外头那个从开始到最后第二个
     * 里头那个循环从开始比到n-i个，当然，这叫沉底法
     * 如果小的到上头，我再来个
     * @param a
     * @return
     */
    public int[] ChenDi(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if(a[j]>a[j+1]){
                 int temp = a[j];
                 a[j]=a[j+1];
                 a[j+1]= temp;
                }
            }
        }
        return a;
    }
    public int[] MaoPao(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = a.length-1;j >i; j--) {
                if(a[j]<a[j-1]){
                    int temp = a[j];
                    a[j]=a[j-1];
                    a[j-1]= temp;
                }
            }
        }
        return a;
    }
    //直接选择排序
    public int[] ZhiJieXuanZe(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j]<a[min]){
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }
    //直接插入排序
    public int[] ZhiJieChaRu(int[] array){
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(array[i]<array[j])
                {
                    int temp=array[i];
                    System.arraycopy(array,j,array,j+1,i-j);
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}
