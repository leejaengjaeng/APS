package highlevelkit.binarysearch;

/*
n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.

처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.

모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.

입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
심사관은 1명 이상 100,000명 이하입니다.
입출력 예
n	times	return
6	[7, 10]	28

https://programmers.co.kr/learn/courses/30/lessons/43238

앞에선 시간 되는대로 쭉쭉 들어가고 마지막 한명인 경우만 기다릴지 말지 결정하면 될듯..?
-> 땡..

https://changyeon2.tistory.com/20

 */

import java.math.BigInteger;
import java.util.PriorityQueue;

public class 입국심사 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
        System.out.println(solution(100, new int[]{1, 100, 100, 100}));
        System.out.println(solution(3, new int[]{1, 100, 100, 11, 20, 33, 55, 12, 5, 1, 2, 3}));
    }


    public static long solution(int n, int[] times) {
        PriorityQueue<Officer> timeTable = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            timeTable.add(new Officer(new BigInteger(String.valueOf(times[i])), new BigInteger("0")));
        }

        // 완전히 논리부터 틀렸음...

        for (int person = 1; person <= n; person++) {
            Officer shortestEndTimeOfficer = timeTable.poll();
            shortestEndTimeOfficer.acceptPerson();
            timeTable.add(shortestEndTimeOfficer);
        }

        Officer answer = timeTable.peek();
        for (Object officer : timeTable.toArray()) {
            if (answer.endTime.compareTo(((Officer) officer).endTime) < 0) {
                answer = (Officer) officer;
            }
        }

        return answer.endTime.longValue();
    }

}

class Officer implements Comparable<Officer> {
    BigInteger time;
    BigInteger endTime;

    public Officer(BigInteger time, BigInteger endTime) {
        this.time = time;
        this.endTime = endTime;
    }

    public void acceptPerson() {
        this.endTime = this.endTime.add(this.time);
    }

    @Override
    public int compareTo(Officer compareTarget) {
        return this.endTime.add(this.time).compareTo(compareTarget.endTime.add(compareTarget.time));
    }
}

