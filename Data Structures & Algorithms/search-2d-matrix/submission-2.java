class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;
        int k = 0;
        int[] nums = new int[n];
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++, k++) {
                nums[k] = row[i];
            }
        }
        return isTargetPresent(target, nums);
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
