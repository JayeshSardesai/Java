// User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        Arrays.sort(frogs);
        boolean[] skip=new boolean[N];
        for(int i=0;i<N;i++){
            if(skip[i]) continue;
            for(int j=i+1;j<N;j++){
                if(frogs[j]%frogs[i]==0) skip[j]=true;
            }
        }
        int[] vis=new int[leaves+1];
        for(int i=0;i<frogs.length;i++){
            if(skip[i]) continue;
            int step=frogs[i];
            if(step>leaves) continue;
            int j=step;
            while(j<=leaves){
                vis[j]=1;
                j=j+step;
            }
        }
        int ans=0;
        for(int i=1;i<vis.length;i++)
            if(vis[i]==0) ans++;
        return ans;
    }
}
