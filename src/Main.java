// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_172928 sol = new Sol_172928();

        String[] park = new String[]{"SOO","OOO","OOO"};
        String[] route = new String[]{"E 2","S 2","W 1"};

        int[] result = sol.solution(park, route);

        System.out.println(Arrays.toString(result));
    }
}
