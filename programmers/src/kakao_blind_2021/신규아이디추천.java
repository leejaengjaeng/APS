package kakao_blind_2021;

/*
https://programmers.co.kr/learn/courses/30/lessons/72410

실패... 실패 케이스 모르겠음...
 */

public class 신규아이디추천 {

    public static void main(String[] args) {
        check("...!@BaT#*..y.abcdefghijklm","bat.y.abcdefghi");
        check("z-+.^.","z--");
        check("=.=","aaa");
        check("123_.def","123_.def");
        check("abcdefghijklmn.p","abcdefghijklmn");

        check("123456789012345.6","123456789012345");
        check("12345678901234.6","12345678901234");
        check("~!@#$%&*()=+[{]}:?,<>/" ,"aaa");
        check(".1.","111");

        check(".............................................","aaa");


        check("DLWODUD1234567890","dlwodud12345678");
        check("`!@#$%^&*()_+=-0","_-0");

        check("..123..123..12..3.","123.123.12.3");
        check("...이재영.aBW,ㄲ꾸..123..이재...쟁!@#","이재영.abwㄲ꾸.123.이");
    }

    public static void check(String input, String output) {
        String result = solution(input);
        if (!result.equals(output)) {
            System.out.println(result);
        } else {
            System.out.println("Success");
        }
    }

    public static String solution(String new_id) {
        String answer = "";
        StringBuilder resultId = new StringBuilder();

        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        for (int i = 0; i < new_id.length(); i++) {
            char character = new_id.charAt(i);

            //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            boolean isNumeric = '0' <= character && character <= '9';
            boolean isAcceptableSpecialCharacter = character == '-' || character == '_' || character == '.';
            if (!Character.isAlphabetic(character) && !isNumeric && !isAcceptableSpecialCharacter) {
                continue;
            }

            //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            if (character == '.') {
                int dotLength = 0;
                for (int next = i + 1; next < new_id.length(); next++) {
                    if (new_id.charAt(next) == '.') {
                        dotLength++;
                    } else {
                        break;
                    }
                }
                i += dotLength;
            }

            resultId.append(character);
        }
        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (resultId.length() != 0 && resultId.charAt(0) == '.') {
            resultId = resultId.deleteCharAt(0);
        }
        if (resultId.length() != 0 && resultId.charAt(resultId.length() - 1) == '.') {
            resultId = resultId.deleteCharAt(resultId.length() - 1);
        }


        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (resultId.length() == 0) {
            resultId = resultId.append("a");
        }

        answer = resultId.toString();

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (answer.length() <= 2) {
            char lastCharacter = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += lastCharacter;
            }
        }

        return answer;
    }
}

