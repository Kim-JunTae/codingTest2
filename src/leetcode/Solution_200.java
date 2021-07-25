package leetcode;

public class Solution_200 {

    //문제 200. Number of islands
    public static void main(String[] args) {
        //Example1
        char[][] grid1 ={{'1','1','1','1','0'},{'1','1','0','1','1'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        //Example2
        char[][] grid2 ={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        //Result
        System.out.println("numIslands(grid1) : " + numIslands(grid1));
        System.out.println("numIslands(grid2) : " + numIslands(grid2));
    }

    /**
     * 매번나오는 DFS, BFS 문제... 그러면 뭐하나 못푸는데
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                result += dfs(grid, m, n, visited, x, y);
            }
        }
        
        return result;
    }

    private static int dfs(char[][] grid, int m, int n, boolean[][] visited, int x, int y){
        //상하좌우용 배열
        int[] positionX = {0,1,0,-1};
        int[] positionY = {1,0,-1,0};

        //예외 처리
        if(y < 0 || y == m || x < 0 || x == n || visited[y][x] || grid[y][x] == '0') return 0;

        //체크
        visited[y][x] = true;

        //상하좌우
        for(int i=0; i<4; i++){
            dfs(grid,m,n,visited,x+positionX[i], y+positionY[i]);
        }
        return 1;
    }//end dfs()
}
