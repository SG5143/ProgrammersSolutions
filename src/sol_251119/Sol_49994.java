package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/49994
    방문길이
 */

public class Sol_49994 {
    public int solution(String dirs) {
        boolean[][][][] visited = new boolean[11][11][11][11];
        int x = 0, y = 0, answer = 0;
        for (char c : dirs.toCharArray()) {
            int nx = x, ny = y;
            if (c == 'U') ny++;
            else if (c == 'D') ny--;
            else if (c == 'R') nx++;
            else if (c == 'L') nx--;
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            int xi = x + 5, yi = y + 5, nxi = nx + 5, nyi = ny + 5;
            if (!visited[xi][yi][nxi][nyi]) {
                visited[xi][yi][nxi][nyi] = true;
                visited[nxi][nyi][xi][yi] = true;
                answer++;
            }
            x = nx; y = ny;
        }
        return answer;
    }
}
