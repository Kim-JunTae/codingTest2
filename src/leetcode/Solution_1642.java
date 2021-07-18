package leetcode;

import java.util.PriorityQueue;

public class Solution_1642 {

    //문제 1642. Furthest Building You Can Reach
    public static void main(String[] args) {
        //Example1
//        int[] heights = {4,2,7,6,9,14,12};
//        int bricks = 5;
//        int ladders = 1;

        //Example2
        int[] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;

        //Example3
//        int[] heights = {14,3,19,3};
//        int bricks = 17;
//        int ladders = 0;

        System.out.println(furthestBuilding1(heights,bricks,ladders));
        System.out.println(furthestBuilding2(heights,bricks,ladders));
    }

    public static int furthestBuilding2(int[] heights, int bricks, int ladders){

        //우선 순위를 갖는 큐 구조
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        //변수
        int currentBricks = bricks;
        int currentLadders = ladders;

        //For문 시작
        for(int i=0; i<heights.length-1; i++){
            int differenceHeight = heights[i+1] - heights[i];

            if(differenceHeight > 0){

                if(currentLadders > 0){  //사다리 수만큼 queue 증가
                    queue.add(differenceHeight);
                    currentLadders--;
                } else if(queue.size() > 0 && differenceHeight > queue.peek()){ //큐의 값이 존재하고 큐의 가장 작은 값이 높이차 보다 작을 때
                    //큐의 가장 작은 값을 벽돌에서 뺴주고 현재의 높이 차를 큐에 넣어준다.
                    queue.add(differenceHeight);
                    currentBricks -= queue.poll();
                } else {
                    currentBricks -= differenceHeight;
                }

                if(currentBricks < 0) return i;
            }
        }

        return heights.length-1;
    }//end furthestBuilding2()

    //벽돌 사용의 효율을 따질 수 없다.
    public static int furthestBuilding1(int[] heights, int bricks, int ladders){
        //결과
        int result = 0;

        //변수
        int currentBricks = bricks;
        int currentLadders = ladders;
        int currentPosition = 0;

        //For문 시작
        for(int i=1; i<heights.length; i++){
            //높이 차이가 있다면 벽돌과 사다리를 찾자!
            if(heights[i]-heights[i-1] > 0){
                int differenceHeight = heights[i] - heights[i-1];

                //벽돌부터 소비
                if(differenceHeight <= currentBricks){
                    currentBricks -= differenceHeight;
                    currentPosition = i;
                }else{
                    //벽돌로 갈 수 없다면 사다리 사용
                    if(currentLadders > 0){
                        currentLadders--;
                        currentPosition = i;
                    }
                }
            }else{ //현재 위치가 다음 위치보다 높다면 패스

            }
        }
        result = currentPosition;
        return result;
    }//end furthestBuilding1()
}
