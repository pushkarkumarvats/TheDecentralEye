import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int pre = 0;  // length of previous increasing segment
        int cur = 0;  // length of current increasing segment
        int mx = 0;   // maximum adjacent increasing subarray length
        
        for (int i = 0; i < nums.size(); i++) {
            cur++;
            // if end of list OR not strictly increasing anymore
            if (i == nums.size() - 1 || nums.get(i) >= nums.get(i + 1)) {
                // check within same segment or between previous and current
                mx = Math.max(mx, cur / 2);
                mx = Math.max(mx, Math.min(pre, cur));
                
                pre = cur;
                cur = 0;
            }
        }
        
        return mx >= k;
    }
}
