//first approach using heap priorityqueue
class Solution {
    public class job{
        int id;
        int dead;
        int p;
        job(int id,int dead,int profit){
            this.id=id;
            this.dead=dead;
            p=profit;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        int cnt=0,max=0;
        int maxprofit=0;
        PriorityQueue<job> pq=new PriorityQueue<>((a,b)->b.p-a.p);
        for(int i=0;i<n;i++){
            max=Math.max(max,deadline[i]);
            pq.add(new job(i,deadline[i],profit[i]));
        }
        int[] map=new int[max+1];
        Arrays.fill(map,-1);
        while(!pq.isEmpty()){
            job j=pq.poll();
            for(int i=j.dead;i>=1;i--){
                if(map[i]==-1){
                    cnt++;
                    map[i]=j.id;
                    maxprofit+=j.p;
                    break;
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(cnt);
        list.add(maxprofit);
        return list;
    }
}

// Second Approach disjoint set union
import java.util.*;

class Solution {
    class Job {
        int id, dead, profit;
        Job(int id, int dead, int profit) {
            this.id = id;
            this.dead = dead;
            this.profit = profit;
        }
    }
    int[] parent;
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y) {
        parent[x] = y;
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int maxDead = 0;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i, deadline[i], profit[i]);
            maxDead = Math.max(maxDead, deadline[i]);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        parent = new int[maxDead + 1];
        for (int i = 0; i <= maxDead; i++) parent[i] = i;
        int cnt = 0;
        int maxProfit = 0;
        for (Job j : jobs) {
            int availableSlot = find(j.dead);
            if (availableSlot > 0) {
                cnt++;
                maxProfit += j.profit;
                union(availableSlot, find(availableSlot - 1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(cnt);
        ans.add(maxProfit);
        return ans;
    }
}
