#include <iostream>
#include <vector>
using namespace std;

vector<int> bubbleSort(vector<int>& nums) {
    int n = nums.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                swap(nums[j], nums[j + 1]);
            }
        }
    }
    return nums;
}

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> nums(n);
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) cin >> nums[i];

    nums = bubbleSort(nums);

    cout << "Sorted array: ";
    for (int x : nums) cout << x << " ";
    return 0;
}
