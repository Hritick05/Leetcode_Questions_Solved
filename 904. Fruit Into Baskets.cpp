class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        unordered_map<int, int> basket; // Stores {fruit_type : count}
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.size(); right++) {
            // 1. Add the current tree's fruit to our window
            basket[fruits[right]]++;

            // 2. If we have more than 2 types of fruits, shrink from the left
            while (basket.size() > 2) {
                basket[fruits[left]]--;
                
                // If count drops to 0, remove that fruit type completely
                if (basket[fruits[left]] == 0) {
                    basket.erase(fruits[left]);
                }
                left++; // Move the left boundary forward
            }

            // 3. Update the maximum window size found so far
            maxFruits = max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
};