package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> backTop = new Stack<>();
        Stack<Integer> frontTop = new Stack<>();

        int queryCount = sc.nextInt();
        for (int i = 1; i <= queryCount; i++) {
            int queryType = sc.nextInt();
            switch (queryType) {
                case 1:
                    int value = sc.nextInt();
                    enqueue(backTop, value);
                    break;
                case 2:
                    dequeue(backTop, frontTop);
                    break;
                case 3:
                    printTop(backTop, frontTop);
                    break;
            }
        }

        sc.close();
    }

    private static void switchStack(Stack<Integer> backTop, Stack<Integer> frontTop) {
        if (frontTop.isEmpty()) {
            while (!backTop.isEmpty()) {
                frontTop.push(backTop.pop());
            }
        }
    }

    private static void enqueue(Stack<Integer> backTop, int value) {
        backTop.push(value);
    }

    private static void dequeue(Stack<Integer> backTop, Stack<Integer> frontTop) {
        switchStack(backTop, frontTop);
        frontTop.pop();
    }

    private static void printTop(Stack<Integer> backTop, Stack<Integer> frontTop) {
        switchStack(backTop, frontTop);
        System.out.println(frontTop.peek());
    }
}
