package InputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class IOBench {
    static final String PATH_INPUT = "src"
            + File.separator + "main"
            + File.separator + "java"
            + File.separator + "InputOutput"
            + File.separator + "input.txt";

    static class Stopwatch {
        private final long startTime;

        /**
         * Stopwatch constructor. Start is the program startTime
         * (wall-clock time) time in miliseconds.
         */
        public Stopwatch() {
            this.startTime = System.currentTimeMillis();
        }

        /**
         * Calculate the elapsed CPU time (how long it has
         * been since the program started)
         * @return Elapsed time (wall-clock time)
         */
        public double elapsedTime() {
            long currentTime = System.currentTimeMillis();
            return (currentTime - this.startTime) / 1000.0;
        }
    }

    /**
     * Credits: <a href="https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/">GeeksForGeeks Fast I/O in Java</a>
     */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static List<List<Integer>> bufferedRead(InputStream in) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        List<List<Integer>> edges = new ArrayList<>();

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                IntStream.range(0, m).forEach(i -> {
                    try {
                        List<Integer> list = new ArrayList<>();
                        for (String s : bufferedReader.readLine().split(" ")) {
                            Integer parseInt = Integer.parseInt(s);
                            list.add(parseInt);
                        }
                        edges.add(list);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                int s = Integer.parseInt(bufferedReader.readLine().trim());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        return edges;
    }

    static List<List<Integer>> fastReaderRead(InputStream in) {
        FastReader fastReader = new FastReader(in);
        List<List<Integer>> edges = new ArrayList<>();

        int t = fastReader.nextInt();
        IntStream.range(0, t).forEach(tItr -> {
            int n = fastReader.nextInt();
            int m = fastReader.nextInt();

            IntStream.range(0, m).forEach(i -> {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    list.add(fastReader.nextInt());
                }
                edges.add(list);
            });

            int s = fastReader.nextInt();
        });

        return edges;
    }

    static boolean check(List<List<Integer>> list1, List<List<Integer>> list2) {
        if (list1.size() != list2.size() || list1.get(0).size() != list2.get(0).size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        File file = new File(IOBench.PATH_INPUT);
        try {
            FileInputStream in1 = new FileInputStream(file);
            FileInputStream in2 = new FileInputStream(file);

            Stopwatch stopwatch = new Stopwatch();
            List<List<Integer>> bufferedList = IOBench.bufferedRead(in1);
            System.out.println("Buffered Reading took: " + stopwatch.elapsedTime() + "s");

            stopwatch = new Stopwatch();
            List<List<Integer>> fastReaderList = IOBench.fastReaderRead(in2);
            System.out.println("FastReader Reading took: " + stopwatch.elapsedTime() + "s");

            System.out.println(check(bufferedList, fastReaderList)
                    ? "2 Reading results are identical."
                    : "2 Reading results are different!"
            );
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }
}
