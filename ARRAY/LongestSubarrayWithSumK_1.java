import java.util.HashMap;

public class LongestSubarrayWithSumK_1 {
 public static int lenOfLongSubarr(int A[], int N, int K) {
  // HashMap to store the prefix sum and its corresponding index
  HashMap<Integer, Integer> map = new HashMap<>();
  int sum = 0; // Initialize the prefix sum
  int maxLength = 0; // To store the maximum length of subarray

  for (int i = 0; i < N; i++) {
      sum += A[i]; // Update the prefix sum

      // Check if the current prefix sum is equal to K
      if (sum == K) {
          maxLength = i + 1;
      }

      // Check if there exists a prefix sum such that current prefix sum - K is in the map
      if (map.containsKey(sum - K)) {
       maxLength = Math.max(maxLength, i - map.get(sum - K));
      }

      // Store the prefix sum and index if it's not already present
      if (!map.containsKey(sum)) {
          map.put(sum, i);
      }
  }

  return maxLength;
 }
 public static void main(String[] args) {
  int arr [] = {1, 4, 20, 3, 10, 5};
  System.out.println(lenOfLongSubarr(arr,arr.length,33));
 }
}
