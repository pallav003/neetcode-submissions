class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> outputMap = new HashMap<>();
    for(String str : strs) {
        int[] arr = new int[26];
        for(int i = 0; i<str.length();i++) {
            arr[str.charAt(i)- 'a']++;
        }
        String temp = Arrays.toString(arr);
        List<String> list = outputMap.getOrDefault(temp, new ArrayList<>());
        list.add(str);
        outputMap.put(temp, list);
    }
    return new ArrayList<>(outputMap.values());       
    }
}
