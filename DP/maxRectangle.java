class Solution {
    static int maxArea(int mat[][]) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int[] height=new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1) height[j]++;
                else height[j]=0;
            }
            ans=Math.max(ans,largestRectangleArea(height));
        }
        return ans;
    }
    static int largestRectangleArea(int[] heights) {
        int largeRect=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stk.isEmpty()&&heights[stk.peek()]>heights[i]){
                int ele=stk.peek();stk.pop();
                int nse=i;
                int pse=stk.isEmpty()?-1:stk.peek();
                largeRect=Math.max(largeRect,(nse-pse-1)*heights[ele]);
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int ele=stk.peek();stk.pop();
            int nse=heights.length;
            int pse=stk.isEmpty()?-1:stk.peek();
            largeRect=Math.max(largeRect,(nse-pse-1)*heights[ele]);
        }
        return largeRect;
    }
}
