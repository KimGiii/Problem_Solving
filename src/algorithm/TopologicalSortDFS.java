package algorithm;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;
    // 위상 정렬 결과를 담을 스택
    Stack<Integer> topoStack;

    public TopologicalSortDFS(int vertices) {
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[vertices];
        topoStack = new Stack<>();
    }

    // 간선 추가 (방향 그래프이므로 단방향으로만 추가)
    public void addDirectedEdge(int u, int v) {
        adj.get(u).add(v); // u 작업이 끝나야 v 작업을 할 수 있음 (u -> v)
    }

    // 깊이 우선 탐색
    public void dfs(int here) {
        visited[here] = true;

        // 선행되어야 하는 다음 작업들을 먼저 깊이 탐색
        for (int i = 0; i < adj.get(here).size(); i++) {
            int there = adj.get(here).get(i);
            if (!visited[there]) {
                dfs(there);
            }
        }

        // 나와 연결된 모든 후속 작업의 탐색이 끝났을 때, 나 자신을 스택에 넣음
        // 즉, 가장 마지막에 수행되어야 할 작업이 스택의 가장 밑바닥에 깔리게 됨
        topoStack.push(here);
    }

    // 위상 정렬 실행
    public void topologicalSort() {
        // 그래프가 여러 덩어리로 나뉘어 있을 수 있으므로 모든 정점 확인
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // 스택에서 꺼내며 결과 출력 (먼저 해야 할 작업부터 나오게 됨)
        System.out.print("위상 정렬 결과: ");
        while (!topoStack.isEmpty()) {
            System.out.print(topoStack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 0부터 5까지 총 6개의 작업(정점)이 있다고 가정
        TopologicalSortDFS graph = new TopologicalSortDFS(6);

        // 작업의 순서(의존성) 정의
        graph.addDirectedEdge(5, 2);
        graph.addDirectedEdge(5, 0);
        graph.addDirectedEdge(4, 0);
        graph.addDirectedEdge(4, 1);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 1);

        graph.topologicalSort();
    }
}