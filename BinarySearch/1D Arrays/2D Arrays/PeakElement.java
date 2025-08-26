// Given an integer array arr, find the index of any peak element (an element strictly greater than its neighbors).

class PeakElement {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightSmaller = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            if (leftSmaller && rightSmaller) {
                return mid; // found a peak
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1; // move left
            } else {
                left = mid + 1;  // move right
            }
        }
        return -1; // should never reach here
    }
}
