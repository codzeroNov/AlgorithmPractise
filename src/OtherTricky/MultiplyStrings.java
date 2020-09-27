package OtherTricky;

public class MultiplyStrings {
/*
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

    示例 1:
    输入: num1 = "2", num2 = "3"
    输出: "6"

    示例 2:
    输入: num1 = "123", num2 = "456"
    输出: "56088"
    说明：

    num1 和 num2 的长度小于110。
    num1 和 num2 只包含数字 0-9。
    num1 和 num2 均不以零开头，除非是数字 0 本身。
    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
*/


    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = multi + res[p2];
                //i+j 是最终结果的高位，i+j+1 是低位。
                // 由于计算顺序就是从右往左、从低到高的，所以每一轮都不需要高位是否要进位，下一轮自然会去处理。
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (str.length() == 0 && res[i] == 0) continue;
            str.append(res[i]);
        }

        return str.length() == 0 ? "0" : str.toString();

    }

}
