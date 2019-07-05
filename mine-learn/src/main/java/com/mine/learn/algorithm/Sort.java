package com.mine.learn.algorithm;

public class Sort {
    private static int[] items = new int[]{4, 5, 6, 1, 3, 2};

    public static void ofInsertion() {
        if (items.length == 1) {
            return;
        }

        for (int i = 0; i < items.length; i++) {
            boolean flag = false;
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                if (flag) {
                    int temp1 = items[j];
                    items[j] = temp;
                    temp = temp1;
                } else {
                    if (items[i] < items[j]) {
                        temp = items[j];
                        items[j] = items[i];
                        flag = true;
                    }
                }
            }
        }
    }

    public static void ofInsertionCorrect() {
        if (items.length == 1) {
            return;
        }
        for (int i = 1; i < items.length; ++i) {
            int value = items[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (value < items[j]) {
                    items[j + 1] = items[j];
                } else {
                    break;
                }
            }
            items[j + 1] = value;
        }
    }

    public static void ofBubble() {
        if (items.length == 1) {
            return;
        }

        for (int i = 0; i <= items.length; ++i) {
            int value = items[0];
            boolean flag = false;
            for (int j = 1; j < items.length - i; ++j) {
                if (value <= items[j]) {
                    value = items[j];
                } else {
                    items[j - 1] = items[j];
                    items[j] = value;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }

            System.err.print("第" + (i + 1) + "趟:");
            for (int k = 0; k < items.length; k++) {
                System.err.print(" " + items[k]);
            }
            System.err.println();
        }
    }

    public static void ofBubbleCorrect() {
        if (items.length == 1) {
            return;
        }

        for (int i = 0; i <= items.length; ++i) {
            boolean flag = false;
            for (int j = 0; j < items.length - i - 1; ++j) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j + 1];
                    items[j + 1] = items[j];
                    items[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
//        ofInsertion();
//        ofInsertionCorrect();
//        ofBubble();
        ofBubbleCorrect();
        for (int i = 0; i < items.length; i++) {
            System.err.println(items[i]);
        }
    }
}
