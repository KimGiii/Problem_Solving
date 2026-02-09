package algorithm;

public class powerSet {
    static int[] p = {1, 2, 3, 4, 5};
    static int n = p.length;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        visited = new boolean[n];
        subset(0);
        System.out.println("부분집합 개수: " + count);
    }

    private static void subset(int cnt) {
        if (cnt == n) {
            count++;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(p[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        visited[cnt] = true;
        subset(cnt + 1);

        visited[cnt] = false;
        subset(cnt + 1);
    }
}
