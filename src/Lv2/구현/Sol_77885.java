package Lv2.구현;
/* 비트마스킹 */

public class Sol_77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            if ((x & 1L) == 0) {
                answer[i] = x + 1;
            }
            else {
                long t = x + 1;
                long diff = x ^ t;
                diff >>= 2;
                answer[i] = t + diff;
            }
        }

        return answer;
    }
}
