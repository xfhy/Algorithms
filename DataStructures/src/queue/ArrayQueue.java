package queue;

/**
 * @author : xfhy
 * Create time : 2020/7/5 9:49 上午
 * Description : 数组实现的循环队列
 */
public class ArrayQueue {

    private int[] array;
    private int front;
    private int near;

    public ArrayQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        if ((near + 1) % array.length == front) {
            throw new Exception("队列已经满了");
        }
        array[near] = element;
        near = (near + 1) % array.length;
    }

    public int deQueue() throws Exception {
        if (near == front) {
            throw new Exception("队列已经出队完了");
        }
        int result = array[front];
        front = (front + 1) % array.length;
        return result;
    }

    public void output() {
        for (int i = front; i != near; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

}
