class Solution {
    public int mostFreqEle(int[] arr) {
        // code here
        int mostFreq = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < arr.length;i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if (max < map.get(arr[i])) {
                max = map.get(arr[i]);
                mostFreq = arr[i];
            }else if(max == map.get(arr[i]) && mostFreq < arr[i]) {
                mostFreq = arr[i];
            }
        }
        return mostFreq;
    }
}
