package capture3.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 优先级队列
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        //inteSort();
        customerSort();
    }

    //插入integer数据,自动排序,然后打印出来
    public static void inteSort(){
        Queue<Integer> integerQueue = new PriorityQueue<Integer>(10);
        Random rand = new Random();
        for(int i = 0;i<10;i++){
            integerQueue.offer(rand.nextInt(100));
        }

        while(integerQueue.size()>0){
            Integer poll = integerQueue.poll();
            System.out.println(poll);
        }
    }
    //对象排序,将对象插入到优先级队列中
    //如果想比较对象中的属性的话,需要建立一个比较器
    public static void customerSort(){
        Queue<Customer> integerQueue = new PriorityQueue<Customer>(10, new Comparator<Customer>() {
            public int compare(Customer o1, Customer o2) {
                return o1.getId()-o2.getId();
            }
        });
        Random random = new Random();
        for(int i = 0;i<10;i++){
            Customer customer = new Customer();
            customer.setId(random.nextInt(100));
            customer.setName(i+"");
            integerQueue.offer(customer);
        }
        while(integerQueue.size()>0){
            Customer poll = integerQueue.poll();
            System.out.println(poll);
            System.out.println("======================================");
        }
    }

}
class Customer{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
