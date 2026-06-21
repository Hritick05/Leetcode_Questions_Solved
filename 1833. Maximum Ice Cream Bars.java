class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxcost = 0;

        for(int cost : costs){
            maxcost = Math.max(maxcost, cost);
        }
        int [] count = new int[maxcost+1];
        for(int cost : costs){
            count[cost]++;
        }

        int ans = 0;

        for(int cost = 1; cost <= maxcost; cost++){
            if(count[cost] == 0) continue;

            int canBuy = Math.min(count[cost], coins/cost);
            ans += canBuy;
            coins -= canBuy*cost;

            if(coins < cost) break;
        }

        return ans;
    }
}