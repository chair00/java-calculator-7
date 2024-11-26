package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InputParser {

    // 구분자 배열 저장
    private List<String> delimiters;

    public InputParser() {
        // 기본 구분자 저장
        delimiters = new ArrayList<>(Arrays.asList(",", ":"));
    }

    // 숫자 리스트 반환 함수
    public List<Integer> extractNumbers(String input) {

        // 커스텀 문자열 있는지 확인 후 저장
        if(input.startsWith("//")) {
            // indexOf는 해당 문자열을 찾고, 없을 시 -1을 리턴한다.
            int endIndexCustomDelimiter = input.indexOf("\\n");
            if (endIndexCustomDelimiter != -1) {
                String delimiter = input.substring(2, endIndexCustomDelimiter);
                delimiters.add(delimiter);
                input = input.substring(endIndexCustomDelimiter + 2);
            }
        }

        // 문자열 내에서 숫자 추출(구분자로 구분)
        String regex = String.join("|", delimiters);
        String[] parts = input.split(regex);

        List<Integer> numbers = new ArrayList<>();

        // 각 문자열 숫자로 변환하기
        for(String part : parts) {
            // valid 체크
            if(!isValidNumber(part)) {
                throw new IllegalArgumentException("양수만 입력 가능합니다. : " + part);
            }
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }

    // 숫자 valid 하는 boolean 함수(공백, 문자열인지, 음수인지 체크, 소수체크?)
    private boolean isValidNumber(String str) {
        return str.matches("\\d+");
    }

}
