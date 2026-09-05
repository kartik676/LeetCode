/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int i=0;
        int n = mountainArr.length();
        int j = n-1;
        int peak = peak(mountainArr);
        int asc= Asc(mountainArr,peak,target);
        
        if(asc>-1){
            return asc;
        }else{

        
        return dec(mountainArr,peak,target);
        }

    }

    public int peak(MountainArray mountainArr){
        int i=0;
        int n = mountainArr.length();
        int j = n-1;

        

        while(i<j){
            
            int mid = i+(j-i)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return j;
    }

    public int Asc(MountainArray mountainArr, int j,int target) {

        int i = 0;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mountainArr.get(mid) < target) {
                i = mid + 1;
            } else if (mountainArr.get(mid)> target) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int dec(MountainArray mountainArr, int i,int target){
        int j=mountainArr.length()-1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mountainArr.get(mid) < target) {
                i = mid + 1;
            } else if (mountainArr.get(mid)> target) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

}