package calculator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = readLine();

        InputParser inputParser = new InputParser();
        List<Integer> numbers = inputParser.extractNumbers(input);

        Calc calc = new Calc(numbers);
        calc.addNumber();
        calc.printResult();
    }
}

class Calc {

    private int result;
    private List<Integer> numbers;

    public Calc(List<Integer> numbers) {

        this.numbers = numbers;
    }

    public void addNumber() {

        for (int number : numbers) {
            result += number;
        }
    }

    public void printResult() {

        System.out.println("결과 : " + result);
    }
}



