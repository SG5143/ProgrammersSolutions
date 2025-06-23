// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_340199 sol = new Sol_340199();

        int[] wallet = new int[]{30, 15};
        int[] bill = new int[]{26, 17};

        System.out.println(sol.solution(wallet, bill));
    }
}
