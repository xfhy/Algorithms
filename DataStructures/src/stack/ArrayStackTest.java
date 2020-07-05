package stack;

/**
 * @author : xfhy
 * Create time : 2020/7/5 9:45 上午
 * Description :
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
//        arrayStack.pop();
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.pop());
//        System.out.println(arrayStack.pop());
    }

}
