

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Find peak
        int peak = peak(nums,n);

        // Step 2: Search in ascending part
        int lefthalf = left(nums, peak, target);
        if (lefthalf != -1) return lefthalf;

        // Step 3: Search in descending part
        return right(nums, peak + 1, n - 1, target);
    }

    // Find peak index
    public int peak(int[] nums,int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    // Binary search on ascending part
    public int left(int[] nums, int end, int target) {
        int i = 0, j = end;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int val = nums[mid];
            if (val == target) return mid;
            if (val < target) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }

    // Binary search on descending part
    public int right(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];
            if (val == target) return mid;
            if (val < target) start = mid + 1; // reversed logic
            else end = mid - 1;
        }
        return -1;
    }
}
