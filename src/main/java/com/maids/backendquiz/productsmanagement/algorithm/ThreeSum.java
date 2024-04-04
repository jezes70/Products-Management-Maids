package com.maids.backendquiz.productsmanagement.algorithm;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> findTriplets(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length < 3) {
            return result;
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == targetSum) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    result.add(triplet);
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int targetSum = 0;
        List<List<Integer>> result = threeSum.findTriplets(arr, targetSum);
        System.out.println("Triplets that sum up to " + targetSum + ":");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}

