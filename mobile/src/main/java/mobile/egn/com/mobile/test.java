package mobile.egn.com.mobile;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test {
    public void solution(int[] A) {
        int value = getValue(A);
        Log.i("hanhmh1203", "final value = " + value);

//        int[] B = printDistinct(A, A.length);
//        Arrays.sort(B);
//
//        for (int i = 0; i < B.length; i++) {
//            Log.i("hanhmh1203", "i = " + i);
//            Log.i("hanhmh1203", "B[i] = " + B[i]);
//            System.out.print("  i : " + i);
//            System.out.print("A[i]" + B[i]);
//            if (i == 0) {
//                if (1 < Math.abs(B[i])) return 1;
//            }
//            if (i > 0 && i < Math.abs(B[i]) - 1) {
//                return i;
//            }
//        }
//        return B[B.length - 1] + 1;

//
//        Arrays.sort(A);
//        A = printDistinct(A, A.length);
//        for (int i = 0; i < A.length; i++) {
//            System.out.print("  i : " + i);
//            System.out.print("A[i]" + A[i]);
//            if (i == 0) {
//                if (1 < Math.abs(A[i])) return 1;
//            }
//            if (i > 0 && i < Math.abs(A[i]) - 1) {
//                return i;
//            }
//        }
//        return A[A.length - 1] + 1;
    }

    private int getValue(int[] A) {
//        int[] B = printDistinct(A, A.length);
//        Arrays.sort(B);

//        for (int i = 0; i < B.length; i++) {
//            Log.i("hanhmh1203", "i = " + i);
//            Log.i("hanhmh1203", "B[i] = " + B[i]);
//            System.out.print("  i : " + i);
//            System.out.print("A[i]" + B[i]);
//            if (i == 0) {
//                if (1 < Math.abs(B[i])) return 1;
//            }
//            if (i > 0 && i < Math.abs(B[i]) - 1) {
//                return i+1;
//            }
//        }
//        return B[B.length - 1] + 1;

        int[] B = printDistinct(A, A.length);
        Arrays.sort(B);
        int value = 1;
        while (isInArray(value, B)) {
            value++;
        }
        return  value;
    }

    static int[] printDistinct(int arr[], int n) {
        // Pick all elements one by one
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, String> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.put(i, "");
        }
        int[]array = new int[hash.size()];
        for (int key : hash.keySet()) {
            list.add(key);
        }
//        int[] primitive= list.stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
//        int[] primitive = list.stream().mapToInt().toArray() ;
        return arr;
    }

    private boolean isInArray(int value, int[] A) {
        boolean isIn = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == value) {
                return  true;
            }
        }
        return isIn;
    }

    private int getMinimum(int oldValue, int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < min && min > oldValue) {
                min = A[i];
            }
        }
        return min;

    }
}