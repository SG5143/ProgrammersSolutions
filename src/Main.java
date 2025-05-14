/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_12946 sol = new Sol_12946();
        int[][] result = sol.solution(6);

        for (int[] a : result) {
            System.out.print("[" + a[0] + ", " + a[1] + "] ");
        }

    }
}
