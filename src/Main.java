/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42748 sol = new Sol_42748();

        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = sol.solution(arr, commands);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
