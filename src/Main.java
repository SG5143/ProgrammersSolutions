/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42587 sol = new Sol_42587();

        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;

        System.out.println(sol.solution(priorities, location));
    }
}
