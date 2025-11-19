package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/68645
    삼각 달팽이
    정수 n이 매개변수로 주어집니다.
    다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서
    맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
    첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

    4	[1,2,9,3,10,8,4,5,6,7]
    5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
    6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
 */

public class Sol_68645 {
    private final int[] dx = {1, 0, -1};
    private final int[] dy = {0, 1, -1};

    public int[] solution(int n) {
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];

        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        int x = 0;
        int y = 0;
        int dir = 0;
        int nextNum = 1;
        while (nextNum <= size) {
            triangle[x][y] = nextNum++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= triangle[nx].length || triangle[nx][ny] != 0) {
                dir = (dir + 1) % 3; // 방향 전환
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        int idx = 0;
        for (int[] row : triangle) {
            for (int val : row) {
                answer[idx++] = val;
            }
        }

        return answer;
    }
}
