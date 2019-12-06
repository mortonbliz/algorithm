package com.rpc.algorithm.day1;

public class Solution {

    public static int removeDuplicates(int[] nums) {
        //判断数组是否为空
        if(nums == null || nums.length == 1){
            return nums.length;
        }
        //定义变量（第一个和第二个下标）
        int i = 0,j = 1;
        //循环数组
        while(j < nums.length){
            //如果当前下标的数据和后一个下标数据一样，j就往后走一下，直到不一样，i往下走，j下标替换掉i下标的值，j往后走一下，i+1就是不重复数据的长度
            if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,2,2,5,5,6,7};
        int newNum = removeDuplicates(num);
        for (int i = 0; i < newNum; i++) {
            System.out.print(" " + num[i]);
        }
    }
}
