class Solution {
    public int findMin(int[] nums) {

        // Analysis:

        // [1,2]
        // [2,1]

        // [1,2,3]
        // [3,1,2]
        // [2,3,1]
        // [1,2,3]

        // [1,2,3,4]
        // [4,1,2,3]
        // [3,4,1,2]
        // [2,3,4,1]
        // [1,2,3,4]

        // it is safe to say that when nums[0] < nums[nums.length], then answer is nums[o]
        // ie, when nums[low] <= nums[high], then answer is nums[low]

        // intermediate case
        // [3,4,1,2]
        // nums[low] is 3
        // nums[high] is 2
        // nums[mid] is 4
        // since the base case is not true,
        // we can say that minimum is to the right of mid
        // so, we update limits: low = mid + 1; high remains.
        // next iteration nums[low] < nums[high] is true.
        // we are done. just return nums[low]

        // intermediate case
        // [2,3,4,1]
        // nums[low] is 2
        // nums[high] is 1
        // nums[mid] = is 3
        // Base case: nums[low] < nums[high] ? false
        // since the base case is not true,
        // we can say that minimum is to the right of mid

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] <= nums[high])
                return nums[low];
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
