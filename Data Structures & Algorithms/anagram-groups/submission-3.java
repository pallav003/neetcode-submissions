class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++) {
            int[]arr = new int[26];
            for(int j = 0; j<strs[i].length();j++) {
                arr[strs[i].charAt(j)-'a']++;
            }
            map.computeIfAbsent(Arrays.toString(arr), k-> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
