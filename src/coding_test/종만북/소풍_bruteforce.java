package coding_test.종만북;

public class 소풍_bruteforce {
    public static int n;
    private static boolean[][] areFriends;

    private int countPairs(boolean[] selected) {
        int firstFree = -1;
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                firstFree = i;
                break;
            }
        }
        if (firstFree == -1) return 1;

        int ret = 0;
        selected[firstFree] = true;
        for (int pairWith = firstFree + 1; pairWith < n; pairWith++) {
            if (!selected[pairWith] && areFriends[firstFree][pairWith]) {
                selected[firstFree] = selected[pairWith] = true;
                ret += countPairs(selected);
                selected[firstFree] = selected[pairWith] = false;
            }
        }
        selected[firstFree] = false;
        return ret;
    }
}
