package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Compute {

    public static void extraLongFactorials(int n) {
        int[] resultArr = new int[200];
        resultArr[0] = 1;
        int digitCount = 1;
        int remain = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < digitCount; j++) {
                int a = resultArr[j] * i + remain;
                resultArr[j] = a % 10;
                remain = a / 10;
            }

            while (remain > 0) {
                resultArr[digitCount] = remain % 10;
                remain /= 10;
                digitCount++;
            }
        }

        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(resultArr[i]);
        }
    }

}

public class LongFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Compute.extraLongFactorials(n);

        bufferedReader.close();
    }
}
