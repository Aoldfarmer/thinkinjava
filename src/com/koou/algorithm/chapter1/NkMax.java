package com.koou.algorithm.chapter1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-05-11 2:51 PM
 */
public class NkMax {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i ++) {
            array[i] = random.nextInt(3000);
        }
        long c1 = System.currentTimeMillis();
        System.out.println(getSortedArrayAlgorithm1(array, 5000));
        System.out.println("Time:" + (System.currentTimeMillis() - c1));

        long c2 = System.currentTimeMillis();
        System.out.println(getSortedArrayAlgorithm2(array, 5000));
        System.out.println("Time:" + (System.currentTimeMillis() - c2));
    }

    public static int getSortedArrayAlgorithm1(int[] arrays, int k) {

        return sortArray(arrays)[k-1];
    }

    public static int getSortedArrayAlgorithm2(int[] arrays, int k) {
        int[] arraysFrontK = sortArray(Arrays.copyOfRange(arrays, 0 ,k));
        for (int i = k; i < arrays.length; i++) {
            if (!(arrays[i] < arraysFrontK[k-1])) {
                int[] temp = new int[k+1];
                for (int n = 0; n < arraysFrontK.length; n++) {
                    temp[n] = arraysFrontK[n];
                }
                temp[k] = arrays[i];
                arraysFrontK = Arrays.copyOfRange(sortArray(temp), 0 , k);
            }
        }
        return arraysFrontK[k-1];
    }

    public static int[] sortArray(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i; j < arrays.length; j++) {
                if (arrays[i] < arrays[j]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        return arrays;
    }
}
