package OtherTricky;

public class ZigZagConversion {
/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);
*/
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int i = 0;
        while (i < c.length) {
            for (int row = 0; row < numRows && i < c.length; row++)
                sbs[row].append(c[i++]);
            for (int row = numRows - 2; row >= 1 && i < c.length; row--)
                sbs[row].append(c[i++]);
        }

        for (int idx = 1; idx < numRows; idx++)
            sbs[0].append(sbs[idx]);

        return sbs[0].toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows <= 1) return s;
        char[] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int direct = -1, row = 0;
        for (int i = 0; i < c.length; i++) {
            sb[row].append(c[i]);
            if (row == 0 || row == numRows - 1)
                direct = 0 - direct;
            row += direct;
        }

        for (int idx = 1; idx < numRows; idx++)
            sb[0].append(sb[idx]);

        return sb[0].toString();
    }
}
