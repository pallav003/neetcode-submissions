class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer,List<Integer>> map = new HashMap<>();
            int[]indegree = new int[numCourses];

            for(int i = 0; i< numCourses;i++) {
                map.put(i, new ArrayList<>());
            }



        for (int[] preq : prerequisites) {
            int course = preq[0];
            int prereq = preq[1];

            map.get(prereq).add(course);
            indegree[course]++;
        }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
            int[] output = new int[numCourses];
            int finish = 0;
            while(!queue.isEmpty()){
                int course = queue.poll();
                output[finish] = course;
                finish++;
                for(int currCourse : map.get(course)) {
                    indegree[currCourse]--;
                    if(indegree[currCourse] == 0) {
                        queue.add(currCourse);
                    }
                }
            }
            if (finish != numCourses) {
            return new int[0];
            }

            return output;

    }
}
