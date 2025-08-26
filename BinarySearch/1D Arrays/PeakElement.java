// Given an array of length N. Peak element is defined as the element greater than both of its neighbors. 
// Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'. 
// Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.

public class PeakElement {

    public static int findPeak(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightSmaller = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            if (leftSmaller && rightSmaller) {
                return mid; // found peak
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1; // move left
            } else {
                left = mid + 1; // move right
            }
        }

        return -1; // This line will never be reached for valid input
    }
}
