package capture3.queue;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 非阻塞队列的消费者
 **/
public class UnBlockQueueTest {
    public static void main(String[] args) {
        UnBlockQueueTest blockQueueTest = new UnBlockQueueTest();
        Producer producer = blockQueueTest.new Producer();
        Customer customer = blockQueueTest.new Customer();
        producer.start();
        customer.start();
    }

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

    class Producer extends Thread {
        @Override
        public void run() {
            //生产数据
            producer();
        }

        private void producer() {
            int i = 1;
            while (true) {
                try {
                    Thread.sleep(new Random().nextInt(300));
                    synchronized (queue) {
                        if (queue.size() == queueSize) {
                            System.out.println("队列已满,需要等待消费...");
                            queue.wait();
                        }
                        queue.offer(i);
                        queue.notifyAll();
                        System.out.println("向队列中添加元素" + i + ",队列剩余空间:" + (queueSize - queue.size()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Customer extends Thread {
        @Override
        public void run() {
            //消费数据
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    Thread.sleep(new Random().nextInt(300));
                    synchronized (queue) {
                        if (queue.size() == 0) {
                            System.out.println("队列为空,需要等待数据填充...");
                            queue.wait();
                        }
                        Integer take = queue.poll();
                        queue.notifyAll();
                        System.out.println("从队列中取走元素:" + take + ",队列剩余空间:" + (queueSize - queue.size()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
