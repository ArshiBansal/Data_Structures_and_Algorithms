import java.util.*;

class MaxHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    private void heapifyUp(int i) {
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            Collections.swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int largest = i;
        int l = left(i), r = right(i);

        if (l < heap.size() && heap.get(l) > heap.get(largest)) largest = l;
        if (r < heap.size() && heap.get(r) > heap.get(largest)) largest = r;

        if (largest != i) {
            Collections.swap(heap, i, largest);
            heapifyDown(largest);
        }
    }

    public void push(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public int pop() {
        if (heap.isEmpty()) return -1;
        int root = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) heapifyDown(0);
        return root;
    }

    public int peek() {
        return heap.isEmpty() ? -1 : heap.get(0);
    }

    public void printHeap() {
        for (int val : heap) System.out.print(val + " ");
        System.out.println();
    }
}

public class maxheap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxHeap mh = new MaxHeap();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            mh.push(sc.nextInt());
        }

        System.out.print("Max Heap: ");
        mh.printHeap();

        System.out.println("Extract Max: " + mh.pop());
        System.out.print("Heap after extraction: ");
        mh.printHeap();

        sc.close();
    }
}
