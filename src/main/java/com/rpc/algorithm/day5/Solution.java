package com.hshc.partner.modules.tmall;

class Solution {
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index; i < nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for(int i = 0; i < nums.length;i++){
            System.out.print(" "+nums[i]);
        }
    }
}
