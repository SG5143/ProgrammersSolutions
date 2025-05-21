/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42576 sol = new Sol_42576();

        String[] participant = new String[]{"leo", "eden", "kiki"};
        String[] completion = new String[]{"eden", "kiki"};

        String result = sol.solution(participant,completion);

        System.out.println(result);
    }
}
