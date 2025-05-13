/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_154540 sol = new Sol_154540();
        String[] map = new String[]{"X591X","X1X5X","X231X", "1XXX1"};
        int[] result = sol.solution(map);

        for (int j : result) {
            System.out.print(j + " ");
        }

    }
}
