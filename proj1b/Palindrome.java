public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dword = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            dword.addLast(word.charAt(i));
        }
        return dword;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> dword = wordToDeque(word);

        /**
        while(dword.size() > 1) {
            if(dword.removeFirst() != dword.removeLast())
                return false;
        }
        return true;    */

        return isPalindromeHelper(dword);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dword = wordToDeque(word);

        while (dword.size() > 1) {
            if (!cc.equalChars(dword.removeFirst(), dword.removeLast())) {
                return false;
            }
        }
        return true;

    }

    private boolean isPalindromeHelper(Deque<Character> word) {
        if (word.isEmpty() || word.size() == 1) {
            return true;
        } else {
            return (word.removeFirst() == word.removeLast()) && isPalindromeHelper(word);
        }
    }
}
