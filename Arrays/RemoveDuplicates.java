class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set=new LinkedHashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        Iterator<Integer> it=set.iterator();
        int i=0;
        while(it.hasNext()){
            nums[i++]=it.next();
        }
        return i;
    }
}
