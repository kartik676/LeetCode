class Solution {
    public int removeDuplicates(int[] nums) {
        int pt1 = 0;
        int pt2 = 1;
        int count = 1;

        while (pt2 < nums.length) {
            if (nums[pt1] != nums[pt2])
             {
                nums[pt1 + 1] = nums[pt2];
                pt1++;
                count++;
            }
            pt2++;

        }
        return count;
    }
}