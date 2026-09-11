class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int boats = 0;
        
        while (i <= j) {
            // The heaviest person (people[j]) always takes a boat this turn
            if (people[i] + people[j] <= limit) {
                i++;   // lightest person also fits, so carry them too
            }
            j--;       // heaviest person is now carried
            boats++;   // one boat used
        }
        
        return boats;
    }
}