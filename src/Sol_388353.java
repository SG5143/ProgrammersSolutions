/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/388353
 */

public class Sol_388353 {
    private final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int EMPTY = -1;

    public int solution(String[] storage, String[] requests) {
        int[][] grid = changeIntGrid(storage);

        for (String request : requests) {
            int reqNum = request.charAt(0) - 'A';

            if (request.length() > 1) crane(grid, reqNum);
            else forkLift(grid, reqNum);
        }

        int count = 0;
        for(int[] row : grid){
            for(int num : row){
                if(num != EMPTY) count++;
            }
        }

        return count;
    }

    private void forkLift(int[][] storageArr, int requestNum) {
        boolean[][] isVisited = new boolean[storageArr.length][storageArr[0].length];

        for (int i = 0; i < storageArr.length; i++) {
            for (int j = 0; j < storageArr[0].length; j++) {
                boolean validRange = i == 0 || j == 0 || i == storageArr.length - 1 || j == storageArr[0].length - 1;
                if (validRange && !isVisited[i][j]) {
                    dfs(storageArr, i, j, requestNum, isVisited);
                }
            }
        }
    }

    private void dfs(int[][] storageArr, int i, int j, int requestNum, boolean[][] isVisited) {
        boolean isValidPosition = i >= 0 && i < storageArr.length && j >= 0 && j < storageArr[0].length;
        if (!isValidPosition || isVisited[i][j]) return;

        isVisited[i][j] = true;

        if (storageArr[i][j] == requestNum) {
            storageArr[i][j] = EMPTY;
            return;
        }

        if (storageArr[i][j] != EMPTY) return;

        for(int[] dir : DIRECTIONS){
            dfs(storageArr, i + dir[0], j + dir[1], requestNum, isVisited);
        }
    }

    private void crane(int[][] storageArr, int requestNum) {
        for (int i = 0; i < storageArr.length; i++) {
            for (int j = 0; j < storageArr[0].length; j++) {
                if (storageArr[i][j] == requestNum) {
                    storageArr[i][j] = EMPTY;
                }
            }
        }
    }

    private int[][] changeIntGrid(String[] storage) {
        int rows = storage.length;
        int cols = storage[0].length();
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = storage[i].charAt(j) - 'A';
            }
        }

        return grid;
    }
}
