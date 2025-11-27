package Lv2.다이나믹프로그래밍;

public class Sol_12900 {
    public int solution(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        final long MOD = 1_000_000_007L;
        long a = 1;
        long b = 2;
        for (int i = 3; i <= n; i++) {
            long c = (a + b) % MOD;
            a = b;
            b = c;
        }
        return (int) b;
    }

    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());
        Sol_12900 sol = new Sol_12900();
        System.out.println(sol.solution(n));
    }
}
