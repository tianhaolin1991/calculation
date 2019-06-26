package capture2;

/**
 * 选择排序算法:表现最稳定的排序算法之一,因为无论什么数据进去都是O(n2)
 * 原理:先在未排序的的序列中找到最小的元素,然后再从剩余的元素中找到最小的元素....
 * 1.初始状态:无序区为R[1...n],有序区为空
 * 2.第i次排序开始时候,无序区有n-i+1个数,有序区为i-1个数
 * 3.n-1趟结束,数组就有序化了
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{10,4,1,55,2,13,41,61,12,3};
        int[] sortedArray = selectionSort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }

    public static int[] selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = i;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}



