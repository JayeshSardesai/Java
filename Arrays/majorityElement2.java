class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> li=new ArrayList<>();
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
            if(hash.get(nums[i])>nums.length/3){
                if(!li.contains(nums[i])){
                li.add(nums[i]);
                }
            }
        }
        return li;
    }
}
