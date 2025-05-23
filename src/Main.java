/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_43105 sol = new Sol_43105();

        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = sol.solution(triangle);

        System.out.println(result);
    }
}
