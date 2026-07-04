package Lv3;

public class Sol_150367 {

    static long[] NUMBERS = {7, 42, 5};

    public static void main() {
        Sol_150367 sol = new Sol_150367();
        sol.solution(NUMBERS);
    }

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int len = binary.length();
            int treeLen = 1;
            while (treeLen < len) {
                treeLen = (treeLen + 1) * 2 - 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < treeLen - len; j++) {
                sb.append("0");
            }
            sb.append(binary);

            boolean isTrue = check(sb.toString());

            if (isTrue) answer[i] = 1;
            else answer[i] = 0;
        }

        return answer;
    }

    private boolean check(String s) {
        if (s.length() <= 1) return true;

        int mid = s.length() / 2;
        char root = s.charAt(mid);

        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);

        if (root == '0' && (left.contains("1") || right.contains("1"))) {
            return false;
        }

        return check(left) && check(right);
    }

}
