class Solution {
    private int time = 0;
    private void dfs(int node, int par, ArrayList<ArrayList<Integer>> adj,
                     int[] low, int[] vis, int[] mark, int[] tin) {
        vis[node] = 1;
        tin[node] = low[node] = time++;
        int child = 0;
        for (int it : adj.get(node)) {
            if (it == par) continue;
            if (vis[it] == 0) {
                dfs(it, node, adj, low, vis, mark, tin);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] >= tin[node] && par != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if (par == -1 && child > 1) {
            mark[node] = 1;
        }
    }
    public ArrayList<Integer> articulationPoints(int V,
            ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] low = new int[V];
        int[] tin = new int[V];
        int[] mark = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, adj, low, vis, mark, tin);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) ans.add(i);
        }
        if (ans.size() == 0) ans.add(-1);
        return ans;
    }
}

// GFG solution require threads it will give stack overflow for the above solution
import java.util.concurrent.atomic.AtomicReference;

class Solution {
    private int time = 0;

    private void dfs(int node, int par, ArrayList<ArrayList<Integer>> adj,
                     int[] low, int[] vis, int[] mark, int[] tin) {

        vis[node] = 1;
        tin[node] = low[node] = time++;
        int child = 0;

        for (int it : adj.get(node)) {
            if (it == par) continue;

            if (vis[it] == 0) {
                dfs(it, node, adj, low, vis, mark, tin);

                low[node] = Math.min(low[node], low[it]);

                if (low[it] >= tin[node] && par != -1) {
                    mark[node] = 1;
                }

                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if (child > 1 && par == -1) {
            mark[node] = 1;
        }
    }

    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {

        AtomicReference<ArrayList<Integer>> result = new AtomicReference<>();

        Thread t = new Thread(null, () -> {
            result.set(solve(V, adj));
        }, "1", 1 << 26);

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result.get();
    }

    private ArrayList<Integer> solve(int V, ArrayList<ArrayList<Integer>> adj) {

        time = 0;

        int[] vis = new int[V];
        int[] low = new int[V];
        int[] tin = new int[V];
        int[] mark = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, adj, low, vis, mark, tin);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) ans.add(i);
        }

        if (ans.size() == 0) ans.add(-1);

        return ans;
    }
}
