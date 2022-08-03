package easy_compute;

import java.util.Arrays;

/**
 * @Description: 顺序打印矩阵 这叫简单？😡,刷过确实,hhh
 * @author: LGD
 * @date:2022/8/3 15:13
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] spiral = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
        System.out.println(Arrays.toString(spiralOrder2(spiral)));
    }

    //由外层到里层思路
    public static int[] spiralOrder2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 )
            return new int[0];
        int rows = matrix.length,cols = matrix[0].length,left = 0,right = cols - 1,top = 0,bottom = rows - 1;
        int index = 0;
        int[] array = new int[rows * cols];
        while(left <= right && top <= bottom){
            for (int col = left; col <= right; col++) {
                array[index++] = matrix[top][col];
            }
            for (int row = top + 1; row <= bottom; row++) {
                array[index++] = matrix[row][right];
            }
            if(left < right && top < bottom){
                for (int col = right-1; col > left; col--) {
                    array[index++] = matrix[bottom][col];
                }
                for (int row = bottom; row > top; row--) {
                    array[index++] = matrix[row][left];
                }
            }
            left ++;
            top ++;
            right --;
            bottom --;
        }
        return array;
    }
}
