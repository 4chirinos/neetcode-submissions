class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (target == nums[low]) {
            return low;
        }
        if (target == nums[high]) {
            return high;
        }
        int pivotIndex = getPivotIndex(nums);
        System.out.println("pivotIndex: " + pivotIndex);
        if (target == nums[pivotIndex]) {
            return pivotIndex;
        }
        if (target > nums[pivotIndex] && target < nums[high]) {
            low = pivotIndex + 1;
        } else {
            high = pivotIndex - 1;
        }
        return binarySearch(low, high, nums, target);
    }

    private static int binarySearch(int low, int high, int[] nums, int target) {
        System.out.println(String.format("low %d, high %d", low, high));
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int getPivotIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return low;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
