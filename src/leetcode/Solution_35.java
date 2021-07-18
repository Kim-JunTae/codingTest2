package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_35 {

    //문제 35. Search Insert Position
    public static void main(String[] args) {
        //Example1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;

        //Example2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;

        //Example3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;

        //Example3
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;

        //Example4
        int[] nums5 = {1};
        int target5 = 0;

        int result1 = searchInsert(nums1, target1);
        int result2 = searchInsert(nums2, target2);
        int result3 = searchInsert(nums3, target3);
        int result4 = searchInsert(nums4, target4);
        int result5 = searchInsert(nums5, target5);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }

    public static int searchInsert(int[] nums, int target) {
        int result = 0;

        int min = 0;
        int max = nums.length-1;

        int mid;

        for (int i=0; i<nums.length; i++){
            mid = (min+max)/2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target){
                min = mid+1;
            }else{
                max = mid-1;
            }

            if(min>max) return min;
        }


        return result;
    }

//    public static int searchInsert(int[] nums, int target) {
//        int result = 0;
//
//        for(int i=0; i<nums.length; i++){
//
//            if(nums[i] >= target){
//                return i;
//            }
//
//        }
//
//        if(nums[nums.length-1] < target) return nums.length;
//
//        return result;
//    }
}
