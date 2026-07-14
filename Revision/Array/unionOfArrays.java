// Here we are trying to skip the duplicates using while loop inside the main loop.
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        int i = 0;
        int j = 0;
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        while(i < n && j < m) {
            while (i > 0 && i < n && a[i] == a[i - 1]) i++;
            while(j > 0 && j < m && b[j] == b[j - 1]) j++;
            if (i == n || j == m) break;
            if (a[i] < b[j]){
                res.add(a[i++]);
            } else if(a[i] > b[j]) {
                res.add(b[j++]);
            } else{
                res.add(a[i]);
                i++;
                j++;
            }
        }
        while(i < n) {
            if (i == 0 || a[i] != a[i - 1]){
                res.add(a[i]);
            }
            i++;
        }
        while(j < m) {
            if (j == 0 || b[j] != b[j - 1]){
                res.add(b[j]);
            }
            j++;
        }
        return res;
    }
}

// Here we are ignoring the element which is equal to last element of list.
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        int i = 0;
        int j = 0;
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        if(a[i] < b[j]) res.add(a[i++]);
        else res.add(b[j++]);
        int prev = res.get(0);
        while(i < n && j < m) {
            if (a[i] < b[j]){
                if (a[i] != prev) res.add(prev = a[i]);
                i++;
            } else if(a[i] > b[j]) {
                if(b[j] != prev) res.add(prev = b[j]);
                j++;
            } else{
                if (a[i] != prev) res.add(prev = a[i]);
                i++;
                j++;
            }
        }
        while(i < n) {
            if (a[i] != prev){
                res.add(prev = a[i]);
            }
            i++;
        }
        while(j < m) {
            if (b[j] != prev){
                res.add(prev = b[j]);
            }
            j++;
        }
        return res;
    }
}
