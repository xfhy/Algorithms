package linkedlist;

/**
 * @author : xfhy
 * Create time : 2020/7/4 7:05 上午
 * Description : 单向链表
 */
public class MyLinkedList {

    /**
     * 头节点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node last;
    /**
     * 链表长度
     */
    private int size;

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 链表查找元素   获取相应位置的节点
     *
     * @param index 查找的位置: [0,size-1]
     */
    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 链表插入元素
     */
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            //头部插入
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            //尾部插入
            last.next = insertNode;
            last = insertNode;
        } else {
            //中间插入
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     */
    public Node remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node deleteNode = null;
        if (index == 0) {
            //删除头部
            deleteNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾部  找到倒数第二个,指向空
            Node lsatPreNode = get(index - 1);
            deleteNode = lsatPreNode.next;
            lsatPreNode.next = null;
            last = lsatPreNode;
        } else {
            //删除中间 找到需要删除的上一个,然后指向下一个的下一个
            Node preNode = get(index - 1);
            deleteNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return deleteNode;
    }

    /**
     * 链表修改元素
     */
    public void update(int data, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node node = get(index);
        node.data = data;
    }

}
