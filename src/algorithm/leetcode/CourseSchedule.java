package algorithm.leetcode;

import java.util.ArrayList;

/**
 * Created by hy on 2015/9/11.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList();
        }
        boolean [] visited = new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }
    private boolean dfs(ArrayList[]graph,boolean[]visited,int course){
        if(visited[course]){
            return false;
        }else{
            visited[course]=true;
        }
        for(int i=0;i<graph[course].size();i++){
            if(!dfs(graph,visited,(Integer)graph[course].get(i))){
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}
