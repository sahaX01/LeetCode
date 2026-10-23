class Solution {
    public int countPrimes(int n) {
        
        int prime[] = new int[n+1];
        for(int i=2; i<=n; i++){
            prime[i] = 1;
        }
        for(int i=2; i*i<=n; i++){
            if(prime[i] == 1){
                for(int j=i*i; j<=n; j=j+i){
                    prime[j] = 0;
                }
            }
        }
        
        int ans = 0;
        for(int i=2; i<=n; i++){
            if(prime[i] == 1 && i<n) ans++;
        }

        return ans;
    }
}