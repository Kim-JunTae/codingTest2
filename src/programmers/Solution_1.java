package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_1 {

    //문제1. 네이버웹툰 개발 챌린지 1차 코딩테스트
    public static void main(String[] args) {
        //Example1
        int[] prices = {13000,88000,10000};
        int[] discounts = {30, 20};

        //Example2
//        int[] prices = {32000,18000,42500};
//        int[] discounts = {50,20,65};

        System.out.println(solution(prices, discounts));
    }

    public static int solution(int[] prices, int[] discounts){
        int answer = 0;

        int endIndexDiscounts = discounts.length-1;
        int endIndexPrices = prices.length-1;

        Arrays.sort(prices);
        Arrays.sort(discounts);

        for(int i = endIndexDiscounts; i>=0; i--){
            int discountPrice = (prices[endIndexPrices]*discounts[i])/100;
            answer += prices[endIndexPrices] - discountPrice;
            endIndexPrices--;
        }

        while (endIndexPrices >= 0){
            answer += prices[endIndexPrices];
            endIndexPrices--;
        }

        return answer;
    }
}
