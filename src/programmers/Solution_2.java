package programmers;

public class Solution_2 {

    //문제2. 네이버웹툰 개발 챌린지 1차 코딩테스트
    public static void main(String[] args) {
        //Example1
        String s1 = "abcxyasdfasdfxyabc";
//        String[] result = {abc, xy, asdf, xy, abc};
        String s2 = "abcxyqwertyxyabc";
        String s3 = "abcabcabcabc";
        String s4 = "llttaattll";
        String s5 = "zzzzzz";
        String s6 = "abcdef";

        System.out.println(solution(s1));
    }

    public static String[] solution(String s){
        String[] answer = {};

        String[] result = s.split("");

        for(int i=0; i<result.length/2; i++){
            if(!result[i].equals(result[result.length-1-i])){

            }
        }

        return answer;
    }

    //실패?
//    public static String[] solution(String s){
//        String[] answer = {};
//
//        int[] checkIndex = {};
//
//        int frontIndex = 0;
//        int backIndex = s.length()-1;
//        int length = 1;
//
//        String frontString = s.substring(frontIndex, length);
//        String backString = s.substring(backIndex, backIndex+length);
//
//        if(frontString.equals(backString)){
//
//            frontIndex++;
//            backIndex--;
//        }else{
//
//            if(frontIndex > backIndex){
//
//            }
//
//            frontIndex++;
//            backIndex--;
//            length++;
//        }
//
//        return answer;
//    }
}
