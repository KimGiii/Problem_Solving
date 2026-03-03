package coding_test.boj.march.mar03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 백준 2644 : 촌수계산
*
* 알고리즘 : BFS
 */


public class BFS_2644 {
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int familyCount = Integer.parseInt(line);

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

        ans = countFamilyRank(familyRelation, target1, target2);

        System.out.println(ans);
    }

    private static int countFamilyRank(List<Integer>[] familyRelation, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[familyRelation.length];
        Arrays.fill(dist, -1);

        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return dist[current];
            }

            for (int next : familyRelation[current]) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }

        return -1;
    }
}
