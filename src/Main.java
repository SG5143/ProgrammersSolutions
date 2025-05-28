/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_42586 sol = new Sol_42586();

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        int[] result = sol.solution(progresses, speeds);

        for(int r: result){
            System.out.print(r + " ");
        }
    }
}
