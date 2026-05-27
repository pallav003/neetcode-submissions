class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        Map<Integer,Integer> inDegree = new HashMap<>();

        for(int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int preq = prerequisite[1];
            List<Integer> list = adj.getOrDefault(preq, new ArrayList<>());
            list.add(course);
            adj.put(preq,list);
            inDegree.put(course, inDegree.getOrDefault(course,0)+1);
        }
        System.out.println(adj);
        System.out.println(inDegree);
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++) {
            if(inDegree.getOrDefault(i,0) == 0) {
                queue.add(i);
            }
        }
        int completeCount = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            completeCount++;
            for(int neighbour : adj.getOrDefault(node, new ArrayList<>())) {
                int newDegree = inDegree.get(neighbour)-1;
                if(newDegree == 0) {
                    queue.add(neighbour);
                }
                inDegree.put(neighbour,newDegree);

            }
        }
        return completeCount == numCourses;
    }
}
