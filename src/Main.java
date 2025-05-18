/**
 * 출력 테스트 용도
 */

public class Main {
    public static void main(String[] args) {
        Sol_388353 sol = new Sol_388353();

        String[] storage = new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = new String[]{"A", "BB", "A"};

        int result = sol.solution(storage, requests);

        System.out.println(result);
    }
}
