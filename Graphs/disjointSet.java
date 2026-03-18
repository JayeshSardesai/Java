/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        // add code here.
        if(x==par[x]) return x;
        return find(par,par[x]);
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        int parx=find(par,x);
        int parz=find(par,z);
        if(parx==parz) return;
        par[parx]=parz;
    }
}
