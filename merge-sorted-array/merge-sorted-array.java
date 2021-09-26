class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Copy the nums2 to nums1
        int p = m;
        for(int i = 0;i<n;i++){
            nums1[p] = nums2[i];
            p++;
        }
        
        Arrays.sort(nums1);
    }
}