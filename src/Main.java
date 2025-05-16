/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_389479 sol = new Sol_389479();
        int[] arr = new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int result = sol.solution(arr,3,5);

        System.out.println(result);
    }
}
