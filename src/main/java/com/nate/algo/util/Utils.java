package com.nate.algo.util;

import java.util.Random;

public final class Utils {

    private Utils() {}

    public static <T> void swap(T[] arr, int i, int j) {
        assert (arr != null);
        assert (i >= 0 && i < arr.length);
        assert (j >= 0 && j < arr.length);

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> void shuffle(T[] arr) {
        assert (arr != null);

        Random rd = new Random();
        for (int i = (arr.length - 1); i >= 0; i--) {
            int j = rd.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    public static <K> int hash(K key) {
        return key.hashCode();
    }
}
