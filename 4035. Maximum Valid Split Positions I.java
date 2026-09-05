class Solution {
    private int gcd(int a , int b){
        while(b != 0 ){
            int t = b; b = a%b; a = t;
        }
        return a;
    }
    private int score(int[] arr){
        int m = arr.length;
        if(m<=1) return 0;
        int [] pre = new int[m], suf = new int [m];
        pre[0] = arr[0];
        for(int i = 1; i<m; i++) pre[i] = gcd(pre[i-1], arr[i]);
        suf[m-1] = arr[m-1];
        for(int i = m-2; i>= 0; i--) suf[i] = gcd(suf[i+1], arr[i]);
        int count = 0;
        for(int i = 0; i<m-1; i++)
            if(pre[i] ==suf[i+1]) count++;
        return count;
    }
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int best = score(nums);
        for(int j = 0; j<n; j++){
            int [] arr = new int[n-1];
            int idx = 0;
            for(int k = 0; k<n; k++){
                if(k != j) arr[idx++] = nums[k];
            }
            best = Math.max(best, score(arr));
        }
        return best;
    }
}