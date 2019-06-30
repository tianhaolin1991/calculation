package capture2;

/**
 * 插入排序:是一种简单的拍苏算法
 * 其工作原理是通过构建有序数列,对于未排序数据找到已排序序列(初始为array[0])中的位置
 * 1.从第一个元素开始,该元素可以认为已经被排序
 * 2.取出下一个元素,在已经排序的元素序列中从后向前扫描
 * 3.如果该元素大于新元素,则将该元素移到下一位
 * 4.重复3,直到找到新元素的位置
 * 5.重复2-4步骤
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{4,10,1,55,2,13,41,61,12,3};
        injectionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void injectionSort(int[] array){
        int preIndex;
        int currentValue;
        for (int i = 1; i < array.length; i++) {
            preIndex = i - 1;
            currentValue = array[i];
            while(preIndex>=0&&array[preIndex]>currentValue){
                array[preIndex + 1] = array[preIndex];
                preIndex --;
            }
            array[preIndex+1] = currentValue;
        }
    }
}
