package algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class GraphDFS_Stack {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;

    public GraphDFS_Stack(int vertices) {
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int here = stack.pop();

            if (!visited[here]) {
                System.out.println("DFS visits" + here);
                visited[here] = true;
                for (int i = adj.get(here).size() - 1; i >= 0; i--) {
                    int there = adj.get(here).get(i);

                    if (!visited[there]) stack.push(there);
                }
            }
        }
    }

    public void dfsAll() {
        visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) dfs(i);
        }
    }
}
