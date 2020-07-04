package linkedlist;

/**
 * @author : xfhy
 * Create time : 2020/7/4 1:29 下午
 * Description :
 */
public class LinkedListTest {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(111, 0);
        myLinkedList.insert(112, 1);
        myLinkedList.insert(113, 2);
        myLinkedList.insert(114, 2);
        myLinkedList.update(6, 0);

        myLinkedList.remove(1);

        myLinkedList.output();
    }

}
