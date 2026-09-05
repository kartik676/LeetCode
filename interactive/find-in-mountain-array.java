class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        
        int peak = peak(mountainArr);

        
        int ascIndex = asc(mountainArr, peak, target);
        if (ascIndex != -1) return ascIndex;

    
        return dec(mountainArr, peak + 1, n - 1, target);
    }

    
    public int peak(MountainArray mountainArr) {
        int i = 0, j = mountainArr.length() - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    
    public int asc(MountainArray mountainArr, int end, int target) {
        int i = 0, j = end;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;
            if (val < target) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }

    
    public int dec(MountainArray mountainArr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;
            if (val > target) start = mid + 1; // reversed logic
            else end = mid - 1;
        }
        return -1;
    }
}
