package sol_251119;

import java.util.ArrayList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
 * 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
 * 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
 * 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
 * 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다.
 * 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
 * 지도의 각 칸에 적힌 숫자는 식량을 나타내는데,
 * 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은
 * 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다.
 * 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서
 * 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
 * <p>
 * 지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때,
 * 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
 * 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
 */

public class Sol_154540_1 {
    private static final int SEA = -1;
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[] solution(String[] maps) {

        int rows = maps.length;
        int cols = maps[0].length();

        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = maps[i].charAt(j) == 'X' ? SEA : maps[i].charAt(j) - '0';
            }
        }

        // 방문 여부 추적
        boolean[][] visited = new boolean[rows][cols];
        ArrayList<Integer> islandDays = new ArrayList<>();

        // 모든 셀 탐색
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != SEA && !visited[i][j]) {
                    // 새로운 섬 발견 시 DFS 시작
                    int days = dfs(grid, visited, i, j, rows, cols);
                    islandDays.add(days);
                }
            }
        }

        // 섬이 없으면 [-1] 반환
        if (islandDays.isEmpty()) return new int[]{-1};

        // 오름차순 정렬
        return islandDays.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        // 경계, 바다, 방문한 셀 처리
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == SEA || visited[row][col]) {
            return 0;
        }

        // 현재 셀 방문 처리 및 값 합산
        visited[row][col] = true;
        int totalDays = grid[row][col];

        // 네 방향 탐색
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            totalDays += dfs(grid, visited, newRow, newCol, rows, cols);
        }

        return totalDays;
    }
}
