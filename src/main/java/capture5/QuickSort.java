package capture5;

import java.util.Arrays;

/**
 * 基本思想:通过一趟排序将待排记录分隔成独立的两部分,其中一部分记录的关键字
 * 均比另一部分的关键字小,则可分别对着两部分记录继续进行排序,以达到整个序列有序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{10,8,7,5,6,9,3,1,2,4,0,0};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array,int low,int high){
        if(high-low<=1){
            return;
        }
        /**
         * 说明:
         * 1.将基准值放在第一位
         * 2.从后向前遍历,如果目标值小于基准值,交换位置;
         * 3.交换位置后从前向后遍历,如果目标值大于基准值,交换位置;
         * 4.以上完成了数组分组,左边是小于基准值的,右边是大于基准值的
         * 4.递归
         */
        int base = low;
        int baseValue = array[base];
        int end = high;
        int begin = low;
        boolean odd = true;
        while(end>begin){
            if(odd){
                if(array[end]<baseValue){
                    array[base] = array[end];
                    array[end] = baseValue;
                    base = end;
                    odd = false;
                }
                end--;
            }else{
                if(array[begin]>baseValue){
                    array[base] = array[begin];
                    array[begin] = baseValue;
                    base = begin;
                    odd = true;
                }
                begin ++;
            }
        }
        quickSort(array,0,base);
        quickSort(array,base+1,high);
    }
}
