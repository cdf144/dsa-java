import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        Stack<StringBuilder> res = new Stack<>();

        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int op = sc.nextInt();
            int val = 0;
            switch (op) {
                case 1: // append
                    res.add(new StringBuilder(str));
                    str.append(sc.next());
                    break;
                case 2: // delete
                    val = sc.nextInt();
                    res.add(new StringBuilder(str));
                    str = new StringBuilder(str.substring(0, str.length() - val));
                    break;
                case 3: // print
                    val = sc.nextInt();
                    System.out.println(str.charAt(val - 1));
                    break;
                case 4: // undo
                    str = res.pop();
                    break;
                default:
                    break;
            }
        }

        sc.close();
    }
}