import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 215. 数组中的第K个最大元素
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-14.
 */
public class T0215 {

    public static void main(String[] args) {
        T0215 t = new T0215();
        assertEquals(5, t.findKthLargest1(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(5, t.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }

    public int findKthLargest(int[] nums, int k) {
        int r = nums.length - 1, index = partition(nums, 0, r);// partition函数返回pivot的下标
        while (index != k - 1) {
            index = index < k - 1 ? partition(nums, index + 1, r) : partition(nums, 0, index - 1);
        }

        // 根据index和k-1的大小关系确定继续处理哪一块，直到二者相等
        return nums[index];
    }
    private void qsort(int[] nums, int l, int r) {
        if (l < r) {
            int pivotIndex = partition(nums, l, r);
            qsort(nums, l, pivotIndex - 1);
            qsort(nums, pivotIndex + 1, r);
        }
    }

    // 在arr[l..r]范围上进行划分，默认以l位置数据作为枢轴pivot
    private int partition(int[] nums, int l, int r) {
        int p = nums[l];
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < p) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, l, index);
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 堆，又称优先级队列，在逻辑上可以视为一棵完全二叉树，且满足每个节点的值小于等于（小根堆）其左右孩子节点的值。
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);  // 小根堆
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);  // 添加前k个元素到小根堆里面
        }
        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
