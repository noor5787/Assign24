package in.ineuron.in;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if (countMap.get(num) > n / 2) {
                return num;
            }
        }

        throw new IllegalArgumentException("Majority element not found");
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println("Majority Element 1: " + majorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element 2: " + majorityElement(nums2));
    }
}

