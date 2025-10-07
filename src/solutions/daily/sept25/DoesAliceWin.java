package solutions.daily.sept25;

/*
3227: Vowels Game in a String (MED)
 */

public class DoesAliceWin {

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        else return false;
    }

    public boolean doesAliceWin(String s) {
        int cnt_vowels = 0;
        for (char c: s.toCharArray()) {
           if (isVowel(c)) cnt_vowels++;
        }
        if (cnt_vowels == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        DoesAliceWin d = new DoesAliceWin();

    }
}
