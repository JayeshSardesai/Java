// GFG format code.
class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        int i = 1;
        int j = 0;
        ArrayList<Integer> uniqueArr = new ArrayList<>();
        uniqueArr.add(arr[0]);
        int n = arr.length;
        while(i < n) {
            if(arr[i] != arr[j]) {
                arr[++j] = arr[i];
                uniqueArr.add(arr[j]);
            }
            i++;
        }
        return uniqueArr;
    }
}

// Leetcode format codes.
// This has O(n) time complexity and O(1) space complexity.
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;
        int n = nums.length;
        while(i < n) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
            i++;
        }
        return j + 1;
    }
}

// This has the time complexity of O(n) but also O(n) space complexity.
class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int i = 1;
        int j = 1;
        int n = nums.length;
        map.put(nums[0],map.getOrDefault(nums[0],0) + 1);
        while(i < n) {
            while (i < n && nums[i - 1] == nums[i]) {
                map.put(nums[i],map.get(nums[i]) + 1);
                i++;
            }
            if (i < n) {
                map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
                nums[j++] = nums[i];
                i++;
            } else {
                break;
            }
        }
        return j;
    }
}
