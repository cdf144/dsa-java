package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DecimalToBinary {

    public static String toBinaryString(long n) {
        List<Integer> binaryArr = new ArrayList<>();
        while (n > 0) {
            if (n % 2 == 0) {
                binaryArr.add(0);
            } else {
                binaryArr.add(1);
            }
            n /= 2;
        }

        StringBuilder binaryString = new StringBuilder(binaryArr.size());
        for (int i = binaryArr.size() - 1; i >= 0; i--) {
            binaryString.append(binaryArr.get(i));
        }

        return binaryString.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        System.out.print(toBinaryString(n));

        bufferedReader.close();
    }
}