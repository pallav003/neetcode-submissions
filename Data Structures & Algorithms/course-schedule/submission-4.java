class Solution {
    private Map<Integer,List<Integer>> store = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i =0;i< numCourses;i++) {
            store.put(i, new ArrayList<>());
        }
        for(int [] pre : prerequisites) {
            store.get(pre[0]).add(pre[1]);
        }

        for(int i =0;i<numCourses;i++) {
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int c) {
        if(visited.contains(c)) {
            return false;
        }
        if(store.get(c).isEmpty()){
            return true;
        }
        visited.add(c);
        for(int pre : store.get(c)) {
            if(!dfs(pre)) {
                return false;
            }
        }
        // store.put(c, new ArrayList<>());
        visited.remove(c);
        return true;
    }
}
