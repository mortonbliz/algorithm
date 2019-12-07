package com.rpc.algorithm.day2;

import java.util.Arrays;

/*
 * 189 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * */
public class Solution {
    /* 思路一（可能会超时并且很慢）
     * Brute Force交换
     * 就是循环并让num[j]不断和最后一个元素交换，循环次
     * 两个循环，外层k次，内层j从0开始，j<num.len次
     * J层不断将最后一个元素移到前面后j++（本质是一直交换temp和num[j])，循环k次
     * 时间复杂度O(n*k)
     * 空间O(1)
     * */

    public static void rotate1(int[] nums, int k) {
        int temp;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = nums[nums.length - 1];
                nums[nums.length - 1] = temp;
            }
        }
    }

    /*思路2
     * 用 % 放置
     * a[（i+k）%len]=num[i]
     * 需要开辟一个新数组，而题目是尽可能原地
     * 时间复杂度O（n)
     * 空间复杂度O（n)
     * */

    public static void rotate2(int[] nums, int k) {

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

    }

    /*
     *  思路3
     *  依然是 % 放置，这次不开辟新数组
     *  对于每一个元素（i+k）%len是他们应该在的位置，
     *  让他们自己去找自己的位置，在位置上的原来的元素保存成pre然后换成这个元素去寻找自己的位置
     *  当满足某个condition的时候就停止
     *  然后变化最外层循环索引继续变化位置用以达到要求
     *
     * */
    public static void rotate3(int[] nums, int k) {
        int count = 0;
//        k = k % nums.length;
        for (int i = 0; count < nums.length; i++) {
            int currentIndex = i;
            int prevEle = nums[currentIndex];
            do {
                int nextIndex = (currentIndex + k) % nums.length;
                int tempEle = nums[nextIndex];
                nums[nextIndex] = prevEle;
                prevEle = tempEle;
                currentIndex = nextIndex;
                count++;
            } while (i != currentIndex);
        }

    }


    /* 思路4
     * 二次旋转
     * Original List                   : 1 2 3 4 5 6 7
     * After reversing all numbers     : 7 6 5 4 3 2 1
     * After reversing first k numbers : 5 6 7 4 3 2 1
     * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     * 旋转函数是二分交换元素，然后头++，尾--
     * 时间复杂度O(n)
     * 空间复杂度O（1)
     * */

    public static void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /* 思路
     *
     * */
    public static void rotate4(int[] nums, int n) {
        int length = nums.length;
        for (int i = 0; i < n ; i++) {
            int last = nums[length - 1];
            for (int j = 0; j <length ; j++) {
                int temp = nums[j];
                nums[j] = last;
                last = temp;
            }
        }
        for (int i = 0; i < length ; i++) {
            System.out.print(" " + nums[i]);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate4(arr, 3);
    }
}
