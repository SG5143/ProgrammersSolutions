// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_178871 sol = new Sol_178871();

        String[] players = new String[] {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = new String[] {"kai", "kai", "mine", "mine"};

        String[] result = sol.solution(players, callings);

        System.out.println(Arrays.toString(result));
    }
}
