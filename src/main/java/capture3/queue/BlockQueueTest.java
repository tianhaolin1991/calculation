package capture3.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列的消费者
 *
 **/
public class BlockQueueTest {
    public static void main(String[] args) {
        BlockQueueTest blockQueueTest = new BlockQueueTest();
        Producer producer = blockQueueTest.new Producer();
        Customer customer = blockQueueTest.new Customer();
        producer.start();
        customer.start();
    }

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    class Producer extends Thread{
        @Override
        public void run(){
            //生产数据
            producer();
        }

        private void producer(){
            int i = 0;
            while(true){
                try {
                    queue.put(i);
                    System.out.println("向队列中添加元素"+i+",队列剩余空间:"+(queueSize-queue.size()));
                    i++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Customer extends Thread{
        @Override
        public void run(){
            //消费数据
            consume();
        }
        private void consume(){
            while(true){
                try {
                    Integer take = queue.take();
                    System.out.println("从队列中取走元素:"+take+",队列剩余空间:"+(queueSize-queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
