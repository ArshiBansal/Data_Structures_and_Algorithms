// Given an integer array arr of size N, sorted in ascending order (with distinct values).
// Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated. 

//Brute

/*public class findRotation {

    public static int countRotations(int[] arr) {
        int n = arr.length; //size of array.
        int ans = Integer.MAX_VALUE, index = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] < ans) {
                    ans = arr[i];
                    index = i;
                }
            }
        return index;

    }
}*/

//Optimal
public class findRotation {

    public static int countRotations(int[] arr) {
        int left = 0, right = arr.length - 1;
        int n = arr.length;

        while (left <= right) {
            // If array is already sorted
            if (arr[left] <= arr[right]) {
                return left; // minimum element is at index left
            }

            int mid = left + (right - left) / 2;
            int next = (mid + 1) % n; // circular next
            int prev = (mid + n - 1) % n; // circular prev

            // Check if mid is minimum
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // Decide which half to choose
            if (arr[mid] >= arr[left]) {
                // Left part is sorted, minimum must be in right part
                left = mid + 1;
            } else {
                // Right part is sorted, minimum must be in left part
                right = mid - 1;
            }
        }

        return 0; // default, though this line should never be reached
    }
}
