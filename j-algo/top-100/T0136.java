import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 136.只出现一次的数字
 * <a href="https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-05.
 */
public class T0136 {
    public static void main(String[] args) {
        T0136 t = new T0136();
        assertEquals(1, t.singleNumber(new int[]{2,2,1}));
    }

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
