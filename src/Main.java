/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_12938 sol = new Sol_12938();
        int[] result = sol.solution(3, 11);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }

    }
}
