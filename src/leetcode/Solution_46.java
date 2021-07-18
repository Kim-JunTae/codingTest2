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

        List<List<Integer>> result1 = permute(nums1);
        List<List<Integer>> result2 = permute(nums2);
        List<List<Integer>> result3 = permute(nums3);

        System.out.println("result1 : " + result1);

        System.out.println("------------------------------------------------");

        System.out.println("result2 : " + result2);

        System.out.println("------------------------------------------------");

        System.out.println("result3 : " + result3);

        System.out.println("------------------------------------------------");
    }

    //https://leetcode.com/problems/permutations/discuss/1339709/Java-solution-backtracking-to-return-permutations

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int targetIndex = 1;

        //1. 1차 세팅
        for(int i=0; i<nums.length; i++){
            List<Integer> item = new ArrayList<>();
            item.add(nums[i]);
            result.add(item);
        }

        makePermutation(targetIndex, nums, result);

        return result;
    }

    public static List<List<Integer>> makePermutation(int targetIndex, int[] nums, List<List<Integer>> result){

        if(targetIndex == nums.length){
            return result;
        }

        for(List<Integer> item : result) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                boolean chk = false;

                for (int i = 0; i < item.size(); i++) {
                    if (num != item.get(i)){
                        chk = true;
                    }
                }
                if (chk) {
                    item.add(num);
                    result.add(item);
                    break;
                }
            }
        }

        targetIndex++;

        return makePermutation(targetIndex, nums, result);
    }
}
