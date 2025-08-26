public class FloorCeil {
    
    // Find Floor (greatest element <= x)
    public static int floor(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int ans = -1; // default if no floor exists

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                return arr[mid]; // exact match is the floor
            } else if (arr[mid] < x) {
                ans = arr[mid];  // possible floor
                left = mid + 1;  // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return ans;
    }

    // Find Ceil (smallest element >= x)
    public static int ceil(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int ans = -1; // default if no ceil exists

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                return arr[mid]; // exact match is the ceil
            } else if (arr[mid] < x) {
                left = mid + 1;  // search right half
            } else {
                ans = arr[mid];  // possible ceil
                right = mid - 1; // search left half
            }
        }
        return ans;
    }
}
