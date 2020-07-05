package stack;

/**
 * @author : xfhy
 * Create time : 2020/7/5 9:24 上午
 * Description : 数组实现的栈 FILO
 */
public class ArrayStack {

    private int rear = -1;
    private int[] array;

    public ArrayStack(int capacity) {
        this.array = new int[capacity];
    }

    public void push(int data) {
        rear++;
        if (rear >= array.length) {
            resize();
        }
        array[rear] = data;
    }

    public int pop() {
        if (rear < 0) {
            throw new IndexOutOfBoundsException("超出栈范围了");
        }
        int result = array[rear];
        rear--;
        return result;
    }

    private void resize() {
        int[] arrayTemp = new int[array.length * 2];
        System.arraycopy(array, 0, arrayTemp, 0, array.length);
        array = arrayTemp;
    }

}
