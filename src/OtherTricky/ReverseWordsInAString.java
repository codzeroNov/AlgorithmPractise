package OtherTricky;

public class ReverseWordsInAString {
    //Given an input string, reverse the string word by word.
    public String reverseWords(String s) {
        if (s == null) return null;

        int len = s.length();
        char[] c = s.toCharArray();


        //1. reverse whole string s
        reverse(c, 0, len);
        //2. reverse every single word
        reverseSingleWord(c, len);
        //3. clean spaces
        return cleanSpace(c, 0, len);

    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start++] = c[end];
            c[end--] = temp;
        }
    }

    private void reverseSingleWord(char[] c, int end) {
        int l = 0, r = 0;
        while (l < end) {
            while (l < r || (l < end && c[l] == ' ')) l++;
            while (r < l || (r < end && c[r] != ' ')) r++;
            reverse(c, l, r - 1);
        }
    }

    private String cleanSpace(char[] c, int start, int end) {
        int l = 0, r = 0;

        while (r < end) {
            while (r < end && c[r] == ' ') r++;//skip spaces
            while (r < end && c[r] != ' ' ) c[l++] = c[r++];//copy to previous position
            while (r < end && c[r] == ' ') r++;//skip spaces. if r reaches tail, the next line won't work.
            if (r < end) c[l++] = ' ';
        }

        return new String(c).substring(0, l);
    }
}
