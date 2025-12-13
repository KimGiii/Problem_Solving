package coding_test.종만북.분할정복;

import java.util.ArrayList;

public class 일반빠른곱셈_분할정복 {
    static void normalize(ArrayList<Integer> num) {
        //num.addLast(0);

        // 자릿수 올림 처리
        for (int i = 0; i < num.size() - 1; i++) {
            if (num.get(i) < 0) {
                int borrow = (Math.abs(num.get(i)) + 9 ) / 10;
                num.set(i+1, num.get(i+1) - borrow);
                num.set(i, num.get(i) + borrow * 10);
            } else {
                num.set(i+1, num.get(i+1) + num.get(i) / 10);
                num.set(i, num.get(i) % 10);
            }
        }

        while (num.size() > 1 && num.get(num.size() - 1) == 0) {
           // num.removeLast();
        }
    }

    static ArrayList<Integer> multiply(ArrayList<Integer> num1, ArrayList<Integer> num2) {
        ArrayList<Integer> result = new ArrayList<>();

        // 결과 배열 초기화 (최대 크기는 num1.size() + num2.size())
        for (int i = 0; i < num1.size() + num2.size(); i++) {
            result.add(0);
        }

        for (int i = 0; i < num1.size(); i++) {
            for (int j = 0; j < num2.size(); j++) {
                result.set(i + j, result.get(i + j) + num1.get(i) * num2.get(j));
            }
        }
        normalize(result);

        return result;
    }

    public static void main(String[] args) {
        // 테스트 1: 123 * 456 = 56088
        ArrayList<Integer> num1 = new ArrayList<>();
        num1.add(3); num1.add(2); num1.add(1); // 123을 역순으로

        ArrayList<Integer> num2 = new ArrayList<>();
        num2.add(6); num2.add(5); num2.add(4); // 456을 역순으로

        ArrayList<Integer> result = multiply(num1, num2);

        System.out.print("123 * 456 = ");
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
        System.out.println(" (expected: 56088)");

        // 테스트 2: 999 * 999 = 998001
        ArrayList<Integer> num3 = new ArrayList<>();
        num3.add(9); num3.add(9); num3.add(9);

        ArrayList<Integer> num4 = new ArrayList<>();
        num4.add(9); num4.add(9); num4.add(9);

        result = multiply(num3, num4);

        System.out.print("999 * 999 = ");
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
        System.out.println(" (expected: 998001)");
    }
}
