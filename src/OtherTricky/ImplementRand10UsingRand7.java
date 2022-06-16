package OtherTricky;

public class ImplementRand10UsingRand7 {
    /*
        Given the API rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
        You can only call the API rand7 and you shouldn't call any other API. Please don't use the system's Math.random().

        Notice that Each test case has one argument n, the number of times that your implemented function rand10 will be called while testing.
    */
    public int rand10() {
        // https://leetcode.com/problems/implement-rand10-using-rand7/discuss/150301/Three-line-Java-solution-the-idea-can-be-generalized-to-%22Implement-RandM()-Using-RandN()%22
        int res = Integer.MAX_VALUE;

        while (res > 40)
            res = 7 * (rand7() - 1) + rand7();

        return res % 10 + 1;
    }

    private int rand7(){
        return (int) (Math.random() * 7);
    }
}
