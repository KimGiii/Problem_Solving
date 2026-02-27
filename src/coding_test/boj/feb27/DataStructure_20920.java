package coding_test.boj.feb27;

import java.io.*;
import java.util.*;

/*
 * 백준 20920 - 영단어 암기는 괴로워
 *
 * 알고리즘 : Data Structure / Sort
 */

public class DataStructure_20920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wordCount = Integer.parseInt(st.nextToken());
        int wordLength = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            if (word.length() >= wordLength) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        createWordNote(wordCountMap, wordLength);

    }

    private static void createWordNote(Map<String, Integer> dictionary, int wordLength) {
        List<Map.Entry<String, Integer>> wordList = new LinkedList<>(dictionary.entrySet());
        wordList.sort((o1, o2) -> {
            int frequency1 = o1.getValue();
            int frequency2 = o2.getValue();

            if (frequency1 != frequency2) {
                return frequency2 - frequency1;
            }

            int length1 = o1.getKey().length();
            int length2 = o2.getKey().length();

            if (length1 != length2) {
                return length2 - length1;
            }

            return o1.getKey().compareTo(o2.getKey());
        });

        List<Map.Entry<String, Integer>> result = new ArrayList<>(wordList);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : result) {
            sb.append(entry.getKey()).append('\n');
        }

        System.out.print(sb.toString().trim());
    }
}
