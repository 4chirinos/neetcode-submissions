class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (isTargetPresent(target, row)) return true;
        }
        return false;
    }

    private static boolean isTargetPresent(int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = nums[mid];
            if (current == target) return true;
            if (current > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
