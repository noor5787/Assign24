package in.ineuron.in;
public class UglyNumber {
    public static int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;

        int idx2 = 0, idx3 = 0, idx5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            uglyNumbers[i] = min;

            if (factor2 == min)
                factor2 = 2 * uglyNumbers[++idx2];
            if (factor3 == min)
                factor3 = 3 * uglyNumbers[++idx3];
            if (factor5 == min)
                factor5 = 5 * uglyNumbers[++idx5];
        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        int uglyNumber = nthUglyNumber(n);
        System.out.println("The " + n + "th ugly number is: " + uglyNumber);
    }
}
