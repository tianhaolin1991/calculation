package capture5;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,6,8,9,23,45,63};
        int i = binarySearch(array, 0,array.length / 2, 45);
        System.out.println(i);
    }

    public static int binarySearch(int[] array,int begin,int end,int target){

        if(begin>end){
            return -1;
        }

        if(array[end]==target){
            return end;
        }
        if(array[end]>target){
            end = (end+1)/2;
            return binarySearch(array,begin,end,target);
        }else{
            begin = end;
            end = (array.length+end)/2;
            return binarySearch(array,begin,end,target);
        }
    }

}
