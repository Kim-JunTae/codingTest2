package programmers;

public class Solution_3 {

    //문제3. 네이버웹툰 개발 챌린지 1차 코딩테스트
    public static void main(String[] args) {
        //Example1
        String s1 = "aabcbcd";
        String t1 = "abc";

        //Example2
        String s2 = "aabcbcd";
        String t2 = "abc";

        System.out.println(solution(s1, t1));
    }

    public static int solution(String s, String t){
        int result = -1;

        int count = 0;

        //제거할 문자열이 있는지 확인하는 함수
        while(canReplaceAndRemove(s, t)){
            s = s.replaceFirst(t, "");
            result = ++count;
        }

        return result;
    }

    private static boolean canReplaceAndRemove(String s, String t) {
        boolean canReplace = false;

        if(s.indexOf(t) != -1){
            canReplace = true;
        }

        return canReplace;
    }//end canReplaceAndRemove()

}
