class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> inDegree = new HashMap<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c,new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i< words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int len = Math.min(word1.length(),word2.length());

            for(int j = 0; j<len;j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (!graph.get(word1.charAt(j)).contains(word2.charAt(j))) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    inDegree.put(word2.charAt(j), inDegree.get(word2.charAt(j))+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character,Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        String s = "";
        while(!queue.isEmpty()) {
           char curr = queue.poll();
           s+=curr;
           for(char next : graph.get(curr)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if(inDegree.get(next) == 0) {
                    queue.add(next);
                }
           }
        }
        return s.length() == inDegree.size() ? s : "";
    }
}
