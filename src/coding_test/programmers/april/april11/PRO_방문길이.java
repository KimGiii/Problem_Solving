package coding_test.programmers.april.april11;

import java.util.HashSet;
import java.util.Set;

public class PRO_방문길이 {

    class Solution {

        public int solution(String dirs) {
            int x = 0, y = 0;
            Set<String> visited = new HashSet<>();

            for (char dir : dirs.toCharArray()) {
                int nx = x, ny = y;

                if (dir == 'U') ny++;
                else if (dir == 'D') ny--;
                else if (dir == 'R') nx++;
                else if (dir == 'L') nx--;

                if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

                String path = Math.min(x, nx) + ", " + Math.min(y, ny) + ", "
                        + Math.max(x, nx) + ", " + Math.max(y, ny);

                visited.add(path);

                x = nx;
                y = ny;
            }

            return visited.size();
        }
    }
}
