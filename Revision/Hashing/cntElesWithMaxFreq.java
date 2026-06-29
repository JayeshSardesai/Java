class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        // code here
        List<Integer> freq=new ArrayList<>();
        for (int i = 0;i < arr.length;i++) {
            freq.add(0);
        }
        for (int i = 0;i < arr.length;i++) {
            int frequency = freq.get(arr[i]-1);
            freq.set(arr[i]-1,frequency+1);
        }
        return freq;
    }
}
