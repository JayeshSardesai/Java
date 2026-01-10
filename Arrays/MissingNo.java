class Solution {
    public int missingNumber(int[] nums) {
        List<Integer> li=Arrays.stream(nums).boxed().toList();
        for(int i=1;i<=nums.length;i++){
            if(!li.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
