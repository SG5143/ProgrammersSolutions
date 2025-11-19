package sol_251119;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */

public class Sol_43105 {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];

        for (int i = 0; i < triangle[size - 1].length; i++) {
            dp[size - 1][i] = triangle[size - 1][i];
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i+1][j + 1]);
            }
        }

        /* 테스트 배열 형태
        30  0   0   0   0
        23  21  0   0   0
        20  13  10  0   0
        7   12  10  10  0
        4   5   2   6   5
        */

        return dp[0][0];
    }
}
