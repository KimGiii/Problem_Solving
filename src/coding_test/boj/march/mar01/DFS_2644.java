package coding_test.boj.march.mar01;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 2644 : 촌수계산
 *
 * 알고리즘 : DFS
 */

public class DFS_2644 {
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int familyCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());

                int relationCount = Integer.parseInt(br.readLine());
                List<Integer>[] familyRelation = new ArrayList[familyCount + 1];
                for (int i = 0; i <= familyCount; i++) {
                    familyRelation[i] = new ArrayList<>();
                }

        for (int i = 0; i < relationCount; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            familyRelation[parent].add(child);
            familyRelation[child].add(parent);
        }

        boolean[] visited = new boolean[familyCount + 1];

        countFamilyRank(familyRelation, visited, target1, target2, 0);

        System.out.println(ans);

    }

    private static void countFamilyRank(List<Integer>[] relation, boolean[] visited, int current, int target, int count) {
        visited[current] = true;

        if (current == target) {
            ans = count;
            return;
        }

        for (int next : relation[current]) {
            if (!visited[next]) {
                countFamilyRank(relation, visited, next, target, count + 1);
            }
        }
    }
}
