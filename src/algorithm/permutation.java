package algorithm;

import java.util.Arrays;

public class permutation {
    static int[] perm;
    static boolean[] visited;
    static int n;
    static int r;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) {
        perm = new int[]{1, 2, 3, 4, 5};
        n = perm.length;
        r = 3;
        nums = new int[r];
        visited = new boolean[n];
        perm(0);
        System.out.println(count);
    }

    private static void perm(int cnt) {
        if (cnt == r) {
            System.out.println(Arrays.toString(nums));
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nums[cnt] = perm[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
