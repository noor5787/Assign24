package in.ineuron.in;

import java.util.ArrayList;
import java.util.List;

public class ClosestNumbers {
    public static List<Integer> findClosestNumbers(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search to find the index of the element closest to x
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid;
        }

        // Initialize two pointers to expand from the closest element
        int leftPtr = left - 1;
        int rightPtr = left;

        // Add k closest elements to the result
        for (int i = 0; i < k; i++) {
            if (leftPtr >= 0 && rightPtr < arr.length) {
                int leftDiff = Math.abs(arr[leftPtr] - x);
                int rightDiff = Math.abs(arr[rightPtr] - x);

                if (leftDiff <= rightDiff) {
                    result.add(arr[leftPtr]);
                    leftPtr--;
                } else {
                    result.add(arr[rightPtr]);
                    rightPtr++;
                }
            } else if (leftPtr >= 0) {
                result.add(arr[leftPtr]);
                leftPtr--;
            } else if (rightPtr < arr.length) {
                result.add(arr[rightPtr]);
                rightPtr++;
            }
        }

        // Sort the result in ascending order
        result.sort(null);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> closestNumbers = findClosestNumbers(arr, k, x);

        System.out.println("Closest Numbers:");
        for (int num : closestNumbers) {
            System.out.println(num);
        }
    }
}
