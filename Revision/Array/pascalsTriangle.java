class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tringle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int val = tringle.get(i - 1).get(j) + tringle.get(i - 1).get(j - 1);
                    row.add(val);
                }
            }
            tringle.add(row);
        }
        return tringle;
    }
}
