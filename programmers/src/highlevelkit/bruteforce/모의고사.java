package highlevelkit.bruteforce;

/*
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]

https://programmers.co.kr/learn/courses/30/lessons/42840
 */

import java.util.Arrays;

public class 모의고사 {

    public static void main(String[] args) {
        int[] result1 = solution(new int[]{1, 2, 3, 4, 5});
        int[] result2 = solution(new int[]{1, 3, 2, 4, 2});
        System.out.println(result2);
    }


    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] firstManAnswerSet = new int[]{1, 2, 3, 4, 5};
        int[] secondManAnswerSet = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdManAnswerSet = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        for (int currentNumber = 0; currentNumber < answers.length; currentNumber++) {
            int currentAnswer = answers[currentNumber];

            if (firstManAnswerSet[currentNumber % firstManAnswerSet.length] == currentAnswer) {
                firstScore++;
            }

            if (secondManAnswerSet[currentNumber % secondManAnswerSet.length] == currentAnswer) {
                secondScore++;
            }

            if (thirdManAnswerSet[currentNumber % thirdManAnswerSet.length] == currentAnswer) {
                thirdScore++;
            }
        }

        //비교.... 쓰레기같은 코드..
        if (firstScore == secondScore && secondScore == thirdScore) {
            answer = new int[]{1, 2, 3};
        }
        else if (firstScore == secondScore) {
            if (firstScore > thirdScore) {
                answer = new int[]{1, 2};
            } else {
                answer = new int[]{3};
            }
        }
        else if (firstScore == thirdScore) {
            if (firstScore > secondScore) {
                answer = new int[]{1, 3};
            } else {
                answer = new int[]{2};
            }
        }
        else if (secondScore == thirdScore) {
            if (secondScore > firstScore) {
                answer = new int[]{2, 3};
            } else {
                answer = new int[]{1};
            }
        }
        else if(firstScore > secondScore && firstScore > thirdScore) {
            answer = new int[]{1};
        }
        else if(secondScore > firstScore && secondScore > thirdScore) {
            answer = new int[]{2};
        }
        else if(thirdScore > secondScore && thirdScore > firstScore) {
            answer = new int[]{3};
        }

        /*  이런식으로 비교 로직 구현 할 수 있음
            
            LinkedList<Integer> list = new LinkedList<Integer>();
            int max = 0;
            for (int i = 0; i < 3; ++i) {
                if (m[i] > max) {
                    list = new LinkedList<Integer>();
                    list.add(i + 1);
                    max = m[i];
                } else if (m[i] == max) {
                    list.add(i + 1);
                }
            }
         */
        return answer;
    }
}