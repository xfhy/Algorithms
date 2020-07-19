```java
import java.util.HashMap;

/**
 * @author : xfhy
 * Create time : 2020年07月19日09:50:00
 * Description : 剑指 Offer 35. 复杂链表的复制
 */
public class Solution {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        Node originTemp = head;
        while (originTemp != null) {
            size++;
            originTemp = originTemp.next;
        }
        Node[] nodes = new Node[size];
        originTemp = head;
        int index = 0;
        while (originTemp != null) {
            nodes[index] = originTemp;
            index++;
            originTemp = originTemp.next;
        }

        originTemp = head;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        index = 0;
        while (originTemp != null) {
            for (int i = nodes.length - 1; i >= 0; i--) {
                if (originTemp.random != null && originTemp.random.equals(nodes[i])) {
                    hashMap.put(index, i);
                    break;
                }
            }
            index++;
            originTemp = originTemp.next;
        }
        //用一个map存储该位置对应的下标
        //再用一个数组存储所有Node元素

        Node[] copyNodes = new Node[size];
        for (int i = 0; i < nodes.length; i++) {
            copyNodes[i] = new Node(nodes[i].val);
        }
        for (int i = 0; i < copyNodes.length; i++) {
            if (i != copyNodes.length - 1) {
                copyNodes[i].next = copyNodes[i + 1];
            } else {
                copyNodes[i].next = null;
            }

            Integer integer = hashMap.get(i);
            if (integer == null) {
                copyNodes[i].random = null;
            } else {
                copyNodes[i].random = copyNodes[integer];
            }

        }

        return copyNodes[0];
    }

    /**
     * 方案2
     * 该方法的思路比较直接，对于一个结点，分别拷贝此结点、next 指针指向的结点、random 指针指向的结点， 然后进行下一个结点...如果遇到已经出现的结点，那么我们不用拷贝该结点，只需将 next 或 random 指针指向该结点即可。
     */
    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        nodeNodeHashMap.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = getClonedNode(nodeNodeHashMap, oldNode.next);
            newNode.random = getClonedNode(nodeNodeHashMap, oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return nodeNodeHashMap.get(head);
    }

    public static Node getClonedNode(HashMap<Node, Node> hashMap, Node node) {
        if (node == null) {
            return null;
        }
        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        } else {
            Node value = new Node(node.val);
            hashMap.put(node, value);
            return value;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node2;

        System.out.println(copyRandomList2(node1));
    }

}

```