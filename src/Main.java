/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_388351 sol = new Sol_388351();

        int[] schedules = new int[]{700, 800, 1100};
        int[][] timelogs = new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};

        int result = sol.solution(schedules, timelogs,5);

        System.out.println(result);
    }
}
