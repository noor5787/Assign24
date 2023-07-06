package in.ineuron.in;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Create a priority queue to store the words based on their frequency and lexicographical order
        PriorityQueue<String> pq = new PriorityQueue<>(new WordComparator(frequencyMap));

        // Add words to the priority queue
        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the word with the lowest frequency if the queue exceeds k elements
            }
        }

        // Create a list to store the k most frequent words in the desired order
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll()); // Add words to the front of the list to maintain the correct order
        }

        return result;
    }

    // Custom comparator to compare words based on their frequency and lexicographical order
    private class WordComparator implements Comparator<String> {
        private final Map<String, Integer> frequencyMap;

        public WordComparator(Map<String, Integer> frequencyMap) {
            this.frequencyMap = frequencyMap;
        }

        @Override
        public int compare(String word1, String word2) {
            int frequency1 = frequencyMap.get(word1);
            int frequency2 = frequencyMap.get(word2);
            if (frequency1 != frequency2) {
                return frequency1 - frequency2; // Sort by frequency in ascending order
            } else {
                return word2.compareTo(word1); // Sort by lexicographical order in descending order
            }
        }
    }

public static void main(String[] args) {
    Solution solution = new Solution();
    
    String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
    int k1 = 2;
    List<String> result1 = solution.topKFrequent(words1, k1);
    System.out.println(result1); // Output: [i, love]
    
    String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    int k2 = 4;
    List<String> result2 = solution.topKFrequent(words2, k2);
    System.out.println(result2); // Output: [the, is, sunny, day]
}

}
