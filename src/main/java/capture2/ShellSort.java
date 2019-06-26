package capture2;

import java.util.Arrays;

/**
 * 希尔排序:它简单插入排序经过改进后的一个更高效的版本,也称为缩小增量排序
 * 也称为缩小增量排序,同时该算法是第一个冲破O(n^2)的算法
 * 算法描述:
 * 1.选择增量gap = length/2,缩小增量继续以gap = gap/2的方式,
 *   这种增量选择我们可以用一个增量序列表示{n/2,(n/2)/2....1}
 * 2.选择一个增量序列:t1,t2....tk其中t1>t2>...>tk
 * 3.按增量序列个数k,对序列进行k次排序
 * 4.每次排序,根据对应的增量ti,将待排序列分割成若干长队为m的子序列,分别
 *   对各个子表进行直接插入排序,仅增量银子为1时,整个序列作为一个表来处理,
 *   表长度即为整个序列的长度
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{10,4,1,55,2,13,41,61,12,3,9,24,56,12,15,67,85,44,46,78,76};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void shellSort(int[] array){
        int gap = array.length/2;
        while(gap>0){
            for (int i = gap; i<array.length; i++) {
                int current = array[i];
                int preIndex = i-gap;
                while(preIndex>=0&&current<array[preIndex]){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex+gap] = current;
            }
            gap = gap/2;
        }
    }
}
