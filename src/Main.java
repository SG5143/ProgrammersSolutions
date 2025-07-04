// 출력 테스트 용도
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sol_76501 sol = new Sol_76501();

        int[] absolutes = new int[]{4,7,12};
        boolean[] signs = new boolean[]{true,false,true};

        System.out.println(sol.solution(absolutes, signs));
    }
}
