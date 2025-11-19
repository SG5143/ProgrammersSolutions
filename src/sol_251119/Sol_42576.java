package sol_251119;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * -해시 1문제-
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다.
 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
 * 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */

public class Sol_42576 {
    public String solution(String[] participant, String[] completion) {

        quickSort(participant, 0 , participant.length-1);
        quickSort(completion, 0 , completion.length-1);

        for(int i = 0 ; i < completion.length ; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[participant.length-1];
    }

    private void quickSort(String[] array, int left, int right) {
        if (left >= right) return;

        int pivot = partition(array, left, right);

        quickSort(array, left, pivot-1);
        quickSort(array, pivot+1, right);
    }

    private int partition(String[] array, int left, int right) {
        int low = left;
        int high = right;
        String pivot = array[left];
        while (low < high) {
            while(array[high].compareTo(pivot) > 0 && low < high){
                high--;
            }

            while(array[low].compareTo(pivot) <= 0 && low < high){
                low++;
            }

            swap(array, low, high);
        }

        swap(array, left, low);

        return low;
    }

    private void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
