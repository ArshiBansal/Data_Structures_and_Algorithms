import java.util.*;

public class mintomax {
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void convertMinToMaxHeap(int[] arr, int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in Min Heap: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter Min Heap elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        convertMinToMaxHeap(arr, n);

        System.out.print("Converted Max Heap: ");
        for (int val : arr) System.out.print(val + " ");
        System.out.println();

        sc.close();
    }
}
