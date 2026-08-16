class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
            Analysis:
            - Lowest eating rate is 1; it is not viable to eat 0 bananas per hour
            - Fatest eating rate is equals to the highest pile, ie, max(piles[i])
            - Search Space (SS) for eating rates ranges from [1, max(piles[i])]
            - Need to check every element in SS and take the best one
        */
        int low = 1;
        int high = Integer.MIN_VALUE;
        int solution = -1;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Search Space goes from [low, high]
        // now we need to try with every element
        // but we will apply Binary Search to pick them

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isEatingRateFastEnough(mid, piles, h)) {
                solution = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return solution;
    }

    private static boolean isEatingRateFastEnough(int rate, int[] piles, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / rate;
            if (pile % rate > 0)
                hours += 1;
        }
        return hours <= h;
    }
}
