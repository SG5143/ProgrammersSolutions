package Lv2.구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_154538 {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        if (x > y) return -1;

        boolean[] visited = new boolean[y + 1];
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();

        q.add(x);
        steps.add(0);
        visited[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int cnt = steps.poll();

            int[] nexts = {cur + n, cur * 2, cur * 3};
            for (int nxt : nexts) {
                if (nxt == y) return cnt + 1;
                if (nxt > 0 && nxt < visited.length && !visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                    steps.add(cnt + 1);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        Sol_154538 sol = new Sol_154538();
        System.out.println(sol.solution(x, y, n));
        sc.close();
    }
}
