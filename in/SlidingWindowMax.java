package in.ineuron.in;
import java.util.*;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current window from the front of the deque
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1)
                deque.pollFirst();
            
            // Remove elements that are smaller than the current element from the back of the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            
            // Add the current element to the back of the deque
            deque.offerLast(i);
            
            // The front of the deque contains the maximum element for the current window
            if (i >= k - 1)
                result[index++] = nums[deque.peekFirst()];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        SlidingWindowMax solution = new SlidingWindowMax();
        int[] result = solution.maxSlidingWindow(nums, k);
        
        System.out.println(Arrays.toString(result));
    }
}
