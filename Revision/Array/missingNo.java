// Leetcode question answer.
class Solution {
    public int missingNumber(int[] nums) {
        int numXr = 0;
        int nXr = 0;
        int n = nums.length;
        for (int i = 0;i < n;i++) {
            numXr = numXr ^ nums[i];
            nXr = nXr ^ (i + 1);
        }
        return (nXr ^ numXr);
    }
}

// GFG question answer.
class Solution {
    int missingNum(int arr[]) {
        // code here
        int arrXr = 0;
        int nXr = 0;
        int  n = arr.length;
        for (int i = 0; i < n;i++) {
            arrXr = arrXr ^ arr[i];
            nXr = nXr ^ (i + 1);
        }
        nXr = nXr ^ (n + 1);
        return (nXr ^ arrXr);
    }
}
