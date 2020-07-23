package OtherTricky;

public class CountNumbersOf1BitsInGivenInteger {

    //编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数

    public int countDigitOne(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;

    }
}
