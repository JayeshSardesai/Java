class Solution {
    public int[] twoSum(int[] a, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            map.put(a[i], i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            int rem = target - a[i];
            if (map.containsKey(rem) && map.get(rem) != i) {
                int j = map.get(rem);
                ans[0] = (j < i)?j:i;
                ans[1] = (j > i)?j:i;
            }
        }
        return ans;
    }
} 
