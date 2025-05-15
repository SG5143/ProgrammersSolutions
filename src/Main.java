/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_86971 sol = new Sol_86971();
        int[][] arr = new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int result = sol.solution(9,arr);

        System.out.println(result);
    }
}
