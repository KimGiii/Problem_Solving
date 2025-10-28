package coding_test.종만북.분할정복;

import java.util.ArrayList;

import static coding_test.종만북.분할정복.일반빠른곱셈_분할정복.multiply;

public class 카라츠바빠른곱셈_분할정복 {
    static void addTo(ArrayList<Integer> a,ArrayList<Integer> b, int k){
        // a의 크기를 최소한 b.size() + k로 맞춘다
        while(a.size() < b.size() + k) {
            a.add(0);
        }

        // b의 각 자리를 k번째 자리부터 a에 더한다
        for(int i = 0; i < b.size(); i++) {
            a.set(i + k, a.get(i + k) + b.get(i));
        }
    }

    static void subFrom(ArrayList<Integer> a, ArrayList<Integer> b) {
        // a의 크기를 최소한 b.size()로 맞춘다
        while(a.size() < b.size()) {
            a.add(0);
        }

        // b의 각 자리를 a에서 뺀다
        for(int i = 0; i < b.size(); i++) {
            a.set(i, a.get(i) - b.get(i));
        }
    }

    static ArrayList<Integer> karatsuba(ArrayList<Integer> a, ArrayList<Integer> b) {
        int a_size = a.size(), b_size = b.size();

        // a가 b보다 짧을 경우 둘을 바꾼다.
        if (a_size < b_size) return karatsuba(b, a);
        // 기저 사례: a나 b가 비어있는 경우
        if(a_size == 0 || b_size == 0) return new ArrayList<Integer>();
        // 기저 사례: a가 비교적 짧은 경우 O(n^2) 곱셈으로 변경
        if (a_size <= 50) return multiply(a, b);

        int half = a_size / 2;
        // a와 b를 밑에서 half 자리와 나머지로 분리
        ArrayList<Integer> a0 = new ArrayList<>(a.subList(0, half));
        ArrayList<Integer> a1 = new ArrayList<>(a.subList(half, a_size));
        ArrayList<Integer> b0 = new ArrayList<>(b.subList(0, Math.min(b_size, half)));
        ArrayList<Integer> b1 = new ArrayList<>(b.subList(Math.min(b_size, half), b_size));

        // z2 = a1 * b1
        ArrayList<Integer> z2 = karatsuba(a1, b1);
        // z0 = a0 * b0
        ArrayList<Integer> z0 = karatsuba(a0, b0);

        // a0 = a0 + a1; b0 = b0 + b1
        addTo(a0, a1, 0);
        addTo(b0, b1, 0);

        // z1 = (a0 * b0) - z0 - z2
        ArrayList<Integer> z1 = karatsuba(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);

        // ret = z0 + z1 * 10^half + z2 * 10^(half*2)
        ArrayList<Integer> ret = new ArrayList<>();
        addTo(ret, z0, 0);
        addTo(ret, z1, half);
        addTo(ret, z2, half + half);

        return ret;
    }
}
