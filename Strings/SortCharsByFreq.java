class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> no=new HashMap<>();
        String ans="";
        for(int i=0;i<s.length();i++){
            no.put(s.charAt(i),no.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> li=new ArrayList<>(no.entrySet());
        li.sort((a,b)->b.getValue()-a.getValue()); 
        for(int i=0;i<li.size();i++){
            char c=li.get(i).getKey();
            int j=li.get(i).getValue();
            while(j>0){
                ans+=c;
                j--;
            }
        }
        return ans;
    }
}
