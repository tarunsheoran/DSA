class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;

        int[] left = new int[n];   // length of increasing subarray ending at i
        int[] right = new int[n];  // length of increasing subarray starting at i

        // Build left (prefix increasing lengths)
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) < nums.get(i))
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        // Build right (suffix increasing lengths)
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1))
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        // Compute maximum possible k
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, Math.min(left[i], right[i + 1]));
        }

        return ans;
    }
}
