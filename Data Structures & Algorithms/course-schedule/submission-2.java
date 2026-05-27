class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visitedSet = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            map.get(preq[1]).add(preq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visitedSet)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, HashSet<Integer> visitedSet) {
        if (visitedSet.contains(course)) return false;
        visitedSet.add(course);

        for (int preq : map.get(course)) {
            if (!dfs(preq, map, visitedSet)) {
                return false;
            }
        }
        visitedSet.remove(course);
        return true;

    }
}

