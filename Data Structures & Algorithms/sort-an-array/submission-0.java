class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right-left) / 2;
        mergeSort(nums,left, mid);
        mergeSort(nums,mid+1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
    int[] arr = new int[right - left + 1];

    int i = left;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) {
            arr[k++] = nums[i++];
        } else {
            arr[k++] = nums[j++];
        }
    }

    while (i <= mid) {
        arr[k++] = nums[i++];
    }

    while (j <= right) {
        arr[k++] = nums[j++];
    }

    for (i = 0; i < arr.length; i++) {
        nums[left + i] = arr[i];
    }
}
}