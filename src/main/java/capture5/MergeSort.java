package capture5;

import java.util.Arrays;

/**
 * 归并排序:
 * 1.将长度n的输入序列分成两个长度n/2的子序列
 * 2.将两个子序列分别采用归并排序
 * 3.将两个排序好的子序列合并成一个最终的排序序列
 * */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{10,4,1,55,2,13,41,61,12,3};
        int[] ints = mergedSort(array);
        String s = Arrays.toString(ints);
        System.out.println(s);
    }

    public static int[] mergedSort(int[] array){
        if(array.length<2){
            return array;
        }
        int middle = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,middle);
        int[] right = Arrays.copyOfRange(array,middle,array.length);
        return merge(mergedSort(left),mergedSort(right));

    }

    //将两个排序好的数组合并,升序排列
    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length + right.length];
        for (int index = 0,i=0,j=0; index < result.length; index++) {
            if(i>=left.length){
                result[index] = right[j++];
            }else if(j>=right.length){
                result[index] = left[i++];
            }else if(left[i]<right[j]){
                result[index] = left[i++];
            }else{
                result[index] = right[j++];
            }
        }
        return result;
    }
}
