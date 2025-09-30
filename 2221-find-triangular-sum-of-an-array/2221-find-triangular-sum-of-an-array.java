import java.math.BigInteger;
class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        BigInteger ans = BigInteger.ZERO;
        BigInteger coeff = BigInteger.ONE; // (n-1)C0
        for(int i=0;i<n;i++) {
            // ans = ans + (nums[i] * coeff);
            ans = ans.add(coeff.multiply(BigInteger.valueOf(nums[i])));
            
            // coeff = (coeff * (n-i-1)) / (i+1);
            coeff = coeff.multiply(BigInteger.valueOf(n-i-1)).divide(BigInteger.valueOf(i+1));
        }
        return ans.mod(BigInteger.TEN).intValue();
    }
}