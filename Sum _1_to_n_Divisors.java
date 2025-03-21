int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(i%j==0){
                    ans=ans+j;
                    if(i/j!=j){
                        ans=ans+(i/j);
                    }
                }
            }
        }
        return ans;
