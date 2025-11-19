package sol_251119;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/340213
 * 당신은 동영상 재생기를 만들고 있습니다.
 * 당신의 동영상 재생기는 10초 전으로 이동, 10초 후로 이동,
 * 오프닝 건너뛰기 3가지 기능을 지원합니다.
 * 각 기능이 수행하는 작업은 다음과 같습니다.
 * <p>
 * 10초 전으로 이동: 사용자가 "prev" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 전으로 이동합니다.
 * 현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동합니다. 영상의 처음 위치는 0분 0초입니다.
 * 10초 후로 이동: 사용자가 "next" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 후로 이동합니다.
 * 동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동합니다. 영상의 마지막 위치는 동영상의 길이와 같습니다.
 * 오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동합니다.
 * 동영상의 길이를 나타내는 문자열 video_len, 기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos,
 * 오프닝 시작 시각을 나타내는 문자열 op_start, 오프닝이 끝나는 시각을 나타내는 문자열 op_end,
 * 사용자의 입력을 나타내는 1차원 문자열 배열 commands가 매개변수로 주어집니다.
 * <p>
 * 이때 사용자의 입력이 모두 끝난 후 동영상의 위치를 "mm:ss" 형식으로 return 하도록 solution 함수를 완성해 주세요.
 */

public class Sol_340213 {
    private static final String COMMAND_PREV = "prev"; // 명령어 prev 상수
    private static final String COMMAND_NEXT = "next"; // 명령어 next 상수
    private static final int TIME_STEP = 10; // 10초 이동 상수


    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoTime = convertTimeToSeconds(video_len);
        int posTime = convertTimeToSeconds(pos);
        int opStart = convertTimeToSeconds(op_start);
        int opEnd = convertTimeToSeconds(op_end);

        int resultTime = posTime;
        for (String command : commands) {
            if (COMMAND_PREV.equals(command))
                resultTime = handlePrev(resultTime, opStart, opEnd);
            else if (COMMAND_NEXT.equals(command))
                resultTime = handleNext(resultTime, videoTime, opStart, opEnd);
        }

        return convertSecondsToTime(resultTime);
    }

    // "prev" 명령 처리 메서드
    private int handlePrev(int currentTime, int opStart, int opEnd) {
        // 10초 전으로 이동 (최소는 0초)
        currentTime = Math.max(currentTime - TIME_STEP, 0);

        // 이동한 곳이 오프닝 구간이면 오프닝 끝자락으로
        if (isWithinOpening(currentTime, opStart, opEnd)) currentTime = opEnd;
        return currentTime;
    }

    // "next" 명령 처리 메서드
    private int handleNext(int currentTime, int videoTime, int opStart, int opEnd) {
        // 오프닝 내부일 경우 오프닝 끝자락으로 스킵
        if (isWithinOpening(currentTime, opStart, opEnd)) {
            currentTime = Math.min(opEnd + TIME_STEP, videoTime);
        }
        // 이후 이동할 위치가 오프닝 내부에 진입할 경우 오프닝 끝자락으로 스킵
        else if (isWithinOpening(currentTime + TIME_STEP, opStart, opEnd)) {
            currentTime = opEnd;
        }
        // 일반적인 10초 이동 > 영상 길이 초과 시 영상 끝 시간으로
        else {
            currentTime = Math.min(currentTime + TIME_STEP, videoTime);
        }

        return currentTime;
    }

    // 오프닝 구간 확인
    private boolean isWithinOpening(int currentTime, int opStart, int opEnd) {
        return currentTime >= opStart && currentTime <= opEnd;
    }

    // mm:ss 형식의 시간을 초 단위로 변환
    private int convertTimeToSeconds(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        return hour * 60 + minute;
    }

    // 초 단위를 mm:ss 형식으로 변환
    private String convertSecondsToTime(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}
