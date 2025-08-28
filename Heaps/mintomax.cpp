#include <iostream>
#include <vector>
using namespace std;

void heapify(vector<int>& arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest])
        largest = left;
    if (right < n && arr[right] > arr[largest])
        largest = right;

    if (largest != i) {
        swap(arr[i], arr[largest]);
        heapify(arr, n, largest);
    }
}

void convertMinToMaxHeap(vector<int>& arr) {
    int n = arr.size();
    // Start from last non-leaf node
    for (int i = (n / 2) - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }
}

int main() {
    int n;
    cout << "Enter number of elements in Min Heap: ";
    cin >> n;

    vector<int> arr(n);
    cout << "Enter Min Heap elements: ";
    for (int i = 0; i < n; i++) cin >> arr[i];

    convertMinToMaxHeap(arr);

    cout << "Converted Max Heap: ";
    for (int val : arr) cout << val << " ";
    cout << endl;

    return 0;
}
