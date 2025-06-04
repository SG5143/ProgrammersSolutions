import java.util.Arrays;

/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42578 sol = new Sol_42578();

        String[][] clothes = new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        System.out.println(sol.solution(clothes));
    }
}
