// User function Template for Java

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        // code here
        int pagefaults=0;
        HashSet<Integer> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            int page=pages[i];
            if(set.contains(page)){
                q.remove(page);
                q.add(page);
            }else{
                pagefaults++;
                if(set.size()==C){
                    int r=q.poll();
                    set.remove(r);
                }
                set.add(page);
                q.add(page);
            }
        }
        return pagefaults;
    }
}
