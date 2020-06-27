package array;

/**
 * @author : xfhy
 * Create time : 2020/6/27 8:56 上午
 * Description : 数组基本操作
 */
public class MyArray {
    private int size;
    private int[] array;

    public MyArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    /**
     * 插入元素到数组
     *
     * @param element 元素
     * @param index   索引
     */
    public void insert(int element, int index) {
        //从末尾一位开始,把前面的一位,拷贝到后面一位,然后将元素放入index
        //可能涉及到扩容
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("越界了");
        }
        if (size >= array.length) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    private void resize() {
        if (size <= 0) {
            return;
        }
        int[] arrayTemp = new int[size * 2];
        System.arraycopy(array, 0, arrayTemp, 0, size);
        array = arrayTemp;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("越界了");
        }

        //从index开始往后,后一位覆盖前一位
        int deleteElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteElement;
    }

    public void update(int element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("越界了");
        }
        array[index] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("越界了");
        }
        return array[index];
    }

    public void output() {
        System.out.println("-------------------");
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("-------------------");
    }

}
