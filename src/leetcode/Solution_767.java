package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_767 {

    //문제 767. Reorganize String
    public static void main(String[] args) {
        //Example1
        String s = "aab";

        //Example2
//        String s = "aaab";

        System.out.println(reorganizeString(s));

    }


    public static String reorganizeString(String s) {
        //1. 영 소문자 26개의 갯수를 저장하고 반복적으로 배치한다.

        //2. 맵 사용 aabbbc a : 2, b : 3, c : 1
        Map<Character, Integer> charIntMap = new HashMap<>();
        for(char currentChar : s.toCharArray()){
            //각 문자의 갯수를 map에 추가해준다.
            charIntMap.put(currentChar, charIntMap.getOrDefault(currentChar, 0)+1);
        }

        //결과값으로 줄 재구성된 문자열
        StringBuilder reorganizedString = new StringBuilder();

        //갯수의 역순으로 들어가있는 queue 구조
        Queue<Character> queue = new PriorityQueue((a, b) -> charIntMap.get(b) - charIntMap.get(a));
        //맵의 키들만(영 소문자들만) 넣어준다.
        queue.addAll(charIntMap.keySet());

        //두 문자를 비교해서 재구성해준다.
        while (queue.size() > 1){ // s : aabbbc, b : 3, a : 2, c : 1 -> b, a, c
            //가장 갯수가 많은 문자부터 시작
            Character first = queue.poll();                 //가장 갯수가 많은 문자 b
            reorganizedString.append(first);                //추가
            charIntMap.put(first, charIntMap.get(first)-1); //맵에서 갯수 변경 b : 2, a :2, c : 1, a, c

            //두번째로 갯수가 많은 문자 시작
            Character second = queue.poll();                 //a
            reorganizedString.append(second);                //
            charIntMap.put(second, charIntMap.get(second)-1);   // b : 2, a :1, c : 1, a, c

            if(charIntMap.get(first) > 0) queue.add(first);     // queue : c , b
            if(charIntMap.get(second) > 0) queue.add(second);   // queue : c , b, a
        }

        //한문자가 남았을 때 추가해줄 로직
        if(!queue.isEmpty()){
            if(charIntMap.get(queue.peek()) > 1){
                return "";
            } else {
                reorganizedString.append(queue.peek());
            }
        }

        return reorganizedString.toString();
    }
}
