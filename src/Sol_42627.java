/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42627
    디스크 컨트롤러

    우선순위 디스크 컨트롤러 시뮬레이션
    jobs: 각 작업이 [작업 요청 시각, 작업 소요 시간] 형태로 주어진 2차원 배열

    동작 방식:
    1. 요청이 들어온 작업은 대기 큐에 저장됨.
    2. 하드디스크가 쉬고 있고 대기 큐가 비어있지 않다면, 작업을 꺼내서 실행.
    3. 작업의 우선순위는 소요 시간이 짧은 순, 요청 시각이 빠른 순, 작업 번호가 작은 순으로 결정됨.
    4. 작업이 끝난 순간에 다른 작업이 들어와도 바로 큐에 저장하고 다음 작업 선택.

    모든 작업의 평균 반환 시간(작업이 요청된 시점부터 완료된 시점까지 걸린 시간)의 정수 부분.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol_42627 {

    private static class Process {
        public int reqTime;
        public int cost;
        public int taskNum;

        public Process(int reqTime, int cost, int taskNum) {
            this.reqTime = reqTime;
            this.cost = cost;
            this.taskNum = taskNum;
        }
    }

    public int solution(int[][] jobs) {
        // 작업 배열을 *요청 시점 기준* 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 우선순위 큐 선언 (소요 시간 기준)
        PriorityQueue<Process> q = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);

        int total = 0;
        int time = 0;
        int jobIdx = 0;
        int processCount = 0;

        while (processCount < jobs.length) {

            // 현재 시간(currentTime)까지 요청된 모든 작업을 큐에 추가
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= time) {
                q.offer(new Process(jobs[jobIdx][0], jobs[jobIdx][1], jobIdx));
                jobIdx++;
            }

            if (q.isEmpty()) {
                // 큐가 비어있다면 -> 현재 처리할 작업이 없음 (유휴 상태)
                // 다음 작업의 요청 시간으로 현재 시간을 점프
                time = jobs[jobIdx][0];
            } else {
                // 큐에 작업이 있다면 -> 가장 소요 시간이 짧은 작업을 처리
                Process p = q.poll();
                time += p.cost;
                total += time - p.reqTime;
                processCount++;
                printDebugInfo(time, q, p, total, jobIdx, processCount);
            }
        }

        return total / jobs.length;
    }

    private void printDebugInfo(int time, PriorityQueue<Process> q, Process currentProcess, int total, int jobIdx, int processCount) {
        System.out.printf("시간: %d ================================\n", time);
        System.out.print("대기 큐: [");
        if (q.isEmpty()) {
            System.out.print("빈 큐");
        } else {
            boolean first = true;
            for (Process p : q) {
                if (!first) System.out.print(", ");
                System.out.printf("{Task_No: %d, Req_Time: %d, Cost: %d}",
                        p.taskNum, p.reqTime, p.cost);
                first = false;
            }
        }
        System.out.println("]");
        System.out.printf("처리된 작업: {Task_No: %d, Req_Time: %d, Cost: %d} 반환시간: %d\n",
                currentProcess.taskNum, currentProcess.reqTime,
                currentProcess.cost, time - currentProcess.reqTime);
        System.out.printf("Total Time: %d\n", total);
        System.out.printf("Process Count: %d\n", processCount);
        System.out.printf("Next Index: %d\n", jobIdx);
        System.out.println("========================================");
    }

}
