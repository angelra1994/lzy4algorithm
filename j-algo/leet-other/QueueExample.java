import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {
    public static void main(String[] args) {
        // 使用有容量限制的队列演示区别
        Queue<Integer> queue = new ArrayBlockingQueue<>(3);
        
        // 添加元素
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        // 此时队列已满，演示两种方法的区别
        
        // 1. 使用 add() 方法 - 抛出异常
        try {
            queue.add(4); // 抛出 IllegalStateException: Queue full
        } catch (IllegalStateException e) {
            System.out.println("add() 方法抛出异常 IllegalStateException: " + e.getMessage());
        }
        
        // 2. 使用 offer() 方法 - 返回 false
        boolean result = queue.offer(4);
        System.out.println("offer() 方法返回: " + result); // 输出: false
        
        // 3. 对于无容量限制的队列（如 LinkedList），两者行为相同
        Queue<Integer> unlimitedQueue = new LinkedList<>();
        System.out.println("LinkedList add(): " + unlimitedQueue.add(1));    // true
        System.out.println("LinkedList offer(): " + unlimitedQueue.offer(2)); // true
    }
}