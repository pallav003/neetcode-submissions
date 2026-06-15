class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int boatsRequired = 0;
        while(left<=right) {
            if(people[left] + people[right] <= limit) {
                boatsRequired++;
                left++;
                right--;
            }
            else {
                if (people[left] > people[right]) {
                    left++;boatsRequired++;
                }
                else {
                right--;
                boatsRequired++;
            }
            }
        }
        return boatsRequired;
    }
}