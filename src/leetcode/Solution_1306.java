package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_1306 {

    //문제 1306. Jump Game III
    public static void main(String[] args) {
        //Example1
        int[] arr1 = {4,2,3,0,3,1,2};
        int start1 = 5;

        //Example2
        int[] arr2 = {4,2,3,0,3,1,2};
        int start2 = 0;

        //Example3
        int[] arr3 = {3,0,2,1,2};
        int start3 = 2;

        //Example4
        int[] arr4 = {0,3,0,6,3,3,4};
        int start4 = 6;

        //Example5 : StackOverflowError 이유 : visited 체크 안함
        int[] arr5 = {58,48,64,36,19,19,67,13,32,2,59,50,29,68,50,0,69,31,54,20,22,43,30,9,68,71,20,22,48,74,2,65,27,54,30,5,66,24,64,68,9,31,50,59,15,72,6,49,11,71,12,61,5,66,30,1,2,39,59,35,53,21,76,17,71,40,68,57,64,53,70,21,50,49,25,63,35};
        int start5 = 46;

        System.out.println(canReach(arr5, start5));

    }

    //Try1 DFS
    public static boolean canReach(int[] arr, int start) {
        //배열 체크
        if(arr == null || arr.length == 0) return false;
        //방문 체크
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        //DFS
        return dfs(arr, start+arr[start], visited, start) || dfs(arr, start-arr[start], visited, start);
    }

    public static boolean dfs(int[] arr, int resultIndex, boolean[] visited, int index){
        //배열 값이 0이어서 index값이 같을 때
        if(resultIndex == index) return true;
        //방문 체크
        visited[index] = true;
        //다음 moving Index 값이 배열의 크기를 벗어나거나 방문했던 index에 왔을 때 false 반환
        if(resultIndex > arr.length-1 || resultIndex < 0 || visited[resultIndex] ) return false;
        else if(arr[resultIndex] == 0) return true;

        return dfs(arr, resultIndex+arr[resultIndex], visited, resultIndex) || dfs(arr, resultIndex-arr[resultIndex], visited, resultIndex);
    }
}
