/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42583
    문제 설명
    트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
    모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
    다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
    다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

    예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
    무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

    경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
    0	[]	[]	[7,4,5,6]
    1~2	[]	[7]	[4,5,6]
    3	[7]	[4]	[5,6]
    4	[7]	[4,5]	[6]
    5	[7,4]	[5]	[6]
    6~7	[7,4,5]	[6]	[]
    8	[7,4,5,6]	[]	[]
    따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

    solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
    다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
    이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

    제한 조건
    bridge_length는 1 이상 10,000 이하입니다.
    weight는 1 이상 10,000 이하입니다.
    truck_weights의 길이는 1 이상 10,000 이하입니다.
    모든 트럭의 무게는 1 이상 weight 이하입니다.
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Sol_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();     // 다리를 표현하는 큐
        int bridgeWeight = 0;                           // 현재 다리에 올라가 있는 트럭 무게 합계
        int time = 0;                                   // 총 경과 시간
        int truckIndex = 0;                             // 현재 트럭 인덱스

        // 모든 트럭이 다리를 건너고, 다리에 트럭이 없을 때까지 반복
        while (truckIndex < truck_weights.length || bridgeWeight != 0) {
            // 다리 길이가 다 찼으면 트럭 한 대를 내보냄
            // && bridge_length > 1 조건은 필요 X 에디터 경고 제거용
            if (bridge.size() == bridge_length && bridge_length > 1) {
                bridgeWeight -= bridge.poll();
            }

            // 다음 트럭을 다리에 올릴 수 있으면 올림
            if (truckIndex < truck_weights.length && bridgeWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                bridgeWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                // 다리에 트럭이 못 올라가면 빈 공간(무게 0) 추가
                bridge.offer(0);
            }

            time++;

            // 디버깅 출력
            System.out.printf(
                    "%d초 결과 -- 총 무게: %d, 다음 인덱스: %d\n",
                    time,
                    bridgeWeight,
                    truckIndex
            );
        }

        return time;
    }
}
