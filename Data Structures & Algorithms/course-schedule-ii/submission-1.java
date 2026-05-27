class Solution {
      public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visitedSet = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        Set<Integer> courseVisited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            map.get(preq[1]).add(preq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visitedSet,courseVisited,output)) {
                return new int[0];
            }
        }
       
        Collections.reverse(output);
        return output.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, HashSet<Integer> visitedSet,
                        Set<Integer> courseVisited, List<Integer> output) {
        if (visitedSet.contains(course)) return false;
        if(courseVisited.contains(course)) return true;
        visitedSet.add(course);

        for (int preq : map.get(course)) {
            if (!dfs(preq, map, visitedSet, courseVisited, output)) {
                return false;
            }
        }
        courseVisited.add(course);
        visitedSet.remove(course);
        output.add(course);
        return true;

    }
}
