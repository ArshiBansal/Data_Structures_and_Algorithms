//Lower Bound

public class LowerUpperBound {
    public static int lowerBound(int[] arr, int x) {
        int left = 0, right = arr.length; // right is n, not n-1
        int ans = arr.length; // default if no valid index found

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                ans = mid;       // possible answer
                right = mid;     // search left half
            } else {
                left = mid + 1;  // search right half
            }
        }
        return ans;
    }
}

//Upper Bound

/*public class LowerUpperBound {
    public static int upperBound(int[] arr, int x) {
        int left = 0, right = arr.length; // right = n
        int ans = arr.length; // default if no valid index found

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > x) {
                ans = mid;      // possible answer
                right = mid;    // search left half
            } else {
                left = mid + 1; // search right half
            }
        }
        return ans;
    }
}*/
