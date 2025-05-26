/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_12906 sol = new Sol_12906();

        int[] arr = {1,1,3,3,0,1,1};
        int[] result = sol.solution(arr);

        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
