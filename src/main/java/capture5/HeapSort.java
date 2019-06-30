package capture5;

/**
 * 堆排序
 * 算法描述:
 * 1.将初始待排序的关键字序列(R1,R2...Rn)构建成大顶堆,此堆为初始的无序区
 * 2.将堆顶元素R[1]与最后一个元素R[n]交换,此时得到新的无序区(R1..Rn-1)和新的有序区R[n],
 *   且满足R[1,2...n-1]<=R[n]
 * 3.由于新交换后的新堆顶肯能违反堆的性质,因此需要对当前无序区R[1...n-1]调整为新堆,
 * 然后再将R[1]与无序区最后一个元素交换.得到新的无序区R[1..n-2]和新的有序区R[n-1,n]
 * 不断重复此过程直到有序区的元素个数为n-1时,排序完成
 */
public class HeapSort {
    public static void main(String[] args) {

    }

    public static int[] heapSort(int[] array){
        int len = array.length;
        //1.构建一个最大的堆
        buidMaxHeap(array);
        //2.循环将堆最大值与末位交换
        while(len>0){
            swap(array,0,len-1);
            len --;
            adjustHeap(array,0);
        }
        return array;
    }

    //构建大顶堆
    private static void buidMaxHeap(int[] array) {
        int len = array.length;
        for(int i = len/2;i<array.length;i++){
            //调整大顶堆
            changeHeap(array,i);
        }
    }

    private static void changeHeap(int[] array, int i) {
        int maxIndex = i;
        if(i*2<len && array[i]*2>array[maxIndex])
    }

    private static void adjustHeap(int[] array, int i) {
    }

    private static void swap(int[] array, int i, int i1) {
    }


}
