/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42862 sol = new Sol_42862();

        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{3};

        int result = sol.solution(n, lost, reserve);

        System.out.println("\n"+result);
    }
}
