class Solution {
     public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private boolean canEatAll(int[] piles, int h, int mid) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += pile / mid; // Equivalent to Math.ceil(pile / k)
            if (pile % mid != 0) {
                hoursNeeded++;
            }
            if (hoursNeeded > h) return false; // Early exit if exceeded
        }
        return hoursNeeded <= h;
    }
}
