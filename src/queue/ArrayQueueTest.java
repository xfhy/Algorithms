package queue;

/**
 * @author : xfhy
 * Create time : 2020/7/5 9:59 上午
 * Description :
 */
public class ArrayQueueTest {

    public static void main(String[] args) throws Exception {
        ArrayQueue myQueue = new ArrayQueue(6);
        myQueue.enQueue(3);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(1);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(2);
        myQueue.enQueue(4);
        myQueue.enQueue(9);
        myQueue.output();
    }

}
