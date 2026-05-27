class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
     int [] arr1 = new int [26];
     int [] arr2 = new int [26];

     for(int i = 0;i< s1.length();i++) {
        arr1[s1.charAt(i)-'a'] += 1 ;
        arr2[s2.charAt(i)-'a'] += 1;
     }
     if (Arrays.equals(arr1,arr2)) {
        return true;
     }
     int left = 0;
     int right = s1.length();
     for (;right < s2.length();right++) {
        arr2[s2.charAt(left) - 'a'] -= 1;
        arr2[s2.charAt(right) - 'a'] += 1;
        left++;
        if (Arrays.equals(arr1,arr2)) {
        return true;
        }
     }
     return false;


    }
}
