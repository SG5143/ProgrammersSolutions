package Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Sol_118667 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int val : queue1) {
            sum1 += val;
            q1.add(val);
        }
        for (int val : queue2) {
            sum2 += val;
            q2.add(val);
        }

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        long targetSum = (sum1 + sum2) / 2;
        int count = 0;
        int maxAttempts = (queue1.length + queue2.length) * 2;

        while (sum1 != targetSum) {
            if (count > maxAttempts) {
                return -1;
            }

            if (sum1 > targetSum) {
                int val = q1.poll();
                sum1 -= val;
                q2.add(val);
            } else {
                int val = q2.poll();
                sum1 += val;
                q1.add(val);
            }
            count++;
        }

        return count;
    }
}
