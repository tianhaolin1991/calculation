package capture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 冒泡排序算法
 * 算法描述:比较相邻的两个元素,如果前一个比后一个大,就交换他们两个(升序排列)
 * 依次对所有的元素做如下操作,则第一轮结束后末尾是最大的数
 * 从头开始针对所有元素做以上操作(除了最后一个)
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(5000));
        }
        bubbleSort(list);
        System.out.println(list);
    }

    private static void bubbleSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-i-1; j++) {
                if(list.get(j)>list.get(j+1)){
                    temp(j,j+1,list);
                }
            }
        }
    }

    private static void temp(Integer a , Integer b , List<Integer> list){
        Integer aElement  = list.get(a);
        Integer bElement = list.get(b);
        Integer temp = aElement;
        list.set(a,bElement);
        list.set(b,temp);
    }
}
