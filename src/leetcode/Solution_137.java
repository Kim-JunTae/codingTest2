package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Solution_137 {

    //문제 137. Single Number II
    public static void main(String[] args) {
        //Example1
        int[] nums1 = {2,2,3,2};

        //Example2
        int[] nums2 = {0,1,0,1,0,1,99};

        //Result
        System.out.println("singleNumber(nums1) : " + singleNumber(nums1));
        System.out.println("singleNumber(nums2) : " + singleNumber(nums2));
    }

    /**
     * 전제 조건 : 하나의 요소 제외하고 같은 요소가 3번 존재함
     * @param nums
     * @return int[] 중 요소가 하나인 요소의 값
     * @apiNote ㄹㅇ 어거지로 만들지 않았나 생각함
     */
    public static int singleNumber(int[] nums) {
        //정렬 후 검색
        int checkIndex = 0;
        int wrongNumber = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++){

            if(checkIndex == 2){
                checkIndex = 0;
            }

            //같으면 체크
            if(nums[i] == nums[i+1]){
                checkIndex++;
                wrongNumber = 0;
            }else{
                wrongNumber++;
            }

            if(i==0 && nums[i] != nums[i+1]){
                return nums[0];
            }

            if(wrongNumber == 2){
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }//end singleNumber()
}
