// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_176963 sol = new Sol_176963();

        String[] name = new String[]{"may", "kein", "kain", "radi"};
        int[] yearning = new int[]{5, 10, 1, 3};
        String[][] photo = new String[][]{
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(sol.solution(name,yearning,photo)));
    }
}
