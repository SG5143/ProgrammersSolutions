/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42587
    문제 설명
    운영체제의 역할 중 하나는 컴퓨터 시스템의 자원을 효율적으로 관리하는 것입니다.
    이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.

    1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
    2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
    3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
        3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
        예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고,
        우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.

    현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와,
    몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때,
    해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.

    제한사항
    priorities의 길이는 1 이상 100 이하입니다.
    priorities의 원소는 1 이상 9 이하의 정수입니다.
    priorities의 원소는 우선순위를 나타내며 숫자가 클 수록 우선순위가 높습니다.
    location은 0 이상 (대기 큐에 있는 프로세스 수 - 1) 이하의 값을 가집니다.
    priorities의 가장 앞에 있으면 0, 두 번째에 있으면 1 … 과 같이 표현합니다.

 */
import java.util.LinkedList;
import java.util.Queue;

public class Sol_42587 {

    // 프로세스의 우선순위와 원래 인덱스를 저장하는 내부 클래스
    private static class Process {
        int priority; // 프로세스의 우선순위 (1~9, 숫자가 클수록 우선순위 높음)
        int index; // 프로세스의 원래 위치 (입력 배열에서의 인덱스)

        Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    // priorities: 프로세스 우선순위 배열, location: 실행 순서를 확인할 프로세스의 인덱스
    // 반환값: location에 해당하는 프로세스가 실행되는 순서
    public int solution(int[] priorities, int location) {
        // LinkedList를 사용한 큐 생성 (FIFO 구조로 프로세스 관리)
        Queue<Process> queue = new LinkedList<>();

        // 각 프로세스의 우선순위와 원래 인덱스를 Process 객체로 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(priorities[i], i));
        }

        // 실행 순서를 카운트하는 변수 (몇 번째로 실행되는지 추적)
        int order = 0;

        while (!queue.isEmpty()) {
            // 큐의 맨 앞 프로세스를 꺼냄
            Process curProcess = queue.poll();

            // noneMatch: 큐에 현재 프로세스보다 높은 우선순위가 없으면 true 반환
            boolean isMaxPriority = queue.stream().noneMatch(p -> p.priority > curProcess.priority);

            if (isMaxPriority) {
                order++;
                if (curProcess.index == location) return order;
            }
            // 더 높은 우선순위가 있다면, 현재 프로세스를 큐의 뒤로 다시 삽입
            else {
                queue.add(curProcess);
            }
        }

        // 정상적으로 location에 해당하는 프로세스를 찾으면 위에서 반환되므로, 이 줄은 실행되지 않음.
        return -1;
    }

}
