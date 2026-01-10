class Solution {
    public int[] twoSum(int[] a, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            int temp=target-a[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(a[i],i);
        }
        return new int[]{};
    }
} 
