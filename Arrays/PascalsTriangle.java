class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            int c=1;
            List<Integer> li=new ArrayList<>();
            for(int j=1;j<=i;j++){
                li.add(c);
                c=c*(i-j)/j;
            }
            list.add(li);
        }
        return list;
    }
}
