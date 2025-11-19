package sol_251119;/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12949
    행렬의 곱셈

    2차원 행렬 arr1과 arr2를 입력받아,
    arr1에 arr2를 곱한 결과를 반환하는 함수,
    solution을 완성해주세요.

    제한 조건
    행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
    행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
    곱할 수 있는 배열만 주어집니다.
 */

public class Sol_12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int k = arr1[0].length;
        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int l = 0; l < k; l++) {
                    sum += arr1[i][l] * arr2[l][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Sol_12949 sol = new Sol_12949();
        int[][] arr1 = { {1, 4}, {3, 2}, {4, 1} };
        int[][] arr2 = { {3, 3}, {3, 3} };
        int[][] result = sol.solution(arr1, arr2);

        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
