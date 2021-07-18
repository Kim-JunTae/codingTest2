package leetcode;

import java.util.*;

public class Solution_46 {

    //문제 46. Permutations
    public static void main(String[] args) {
        //Example1
        int[] nums1 = {1,2,3};

        //Example2
        int[] nums2 = {0,1};

        //Example3
        int[] nums3 = {1};

        System.out.println("------------------------------------------------");
        List<List<Integer>> result1 = permute(nums1);
        System.out.println("result1 : " + result1);

        System.out.println("------------------------------------------------");

        List<List<Integer>> result2 = permute(nums2);
        System.out.println("result2 : " + result2);

        System.out.println("------------------------------------------------");

        List<List<Integer>> result3 = permute(nums3);
        System.out.println("result3 : " + result3);

        System.out.println("------------------------------------------------");
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> item = new ArrayList<>();
        makePermutation(item, 0, nums, result);

        return result;
    }

    public static void makePermutation(List<Integer> item, int index, int[] nums, List<List<Integer>> result){

        //out
        if(index == nums.length){
            result.add(new ArrayList<>(item));
            return;
        }

        List<Integer> newItem = new ArrayList<>(item);

        //insert
        for(int i=0; i<=index; i++){
            newItem.add(i, nums[index]);
            makePermutation(newItem, index+1, nums, result);
            newItem.remove(i);
        }
    }
}
