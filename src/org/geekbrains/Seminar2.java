package org.geekbrains;
import java.util.List;
import java.util.ArrayList;


public class Seminar2 {
    public static int count;
    public static void main(String[] args) {

    System.out.println("Seminar2 Task1 insert Data:");

    int[][] grid = new int[] [] {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        printArrayArrays(grid);
        System.out.println("Result = " + maxAreaOfIsland(grid));
        int[][] grid1 = new int [] [] {{0,0,0,0,0,0,0,0}};
        printArrayArrays(grid1);
        System.out.println("Result = " + maxAreaOfIsland(grid1));
        int[][] grid2 = new int [] [] {{0,0,0,0,0,0,0,0},{0,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0}};
        printArrayArrays(grid2);
        System.out.println("Result = " + maxAreaOfIsland(grid2));

    System.out.println("---------------------------------------------------");

    int[][] image2_1 = new int [] [] {{1,1,1},{1,1,0},{1,0,1}};
    int sr = 1,sc = 1,color = 2;
    System.out.println("Seminar2 Task2 insert Data (1):");
    System.out.print("image [][] :");
    printArrayArrays(image2_1);
    System.out.println("sr = "+sr+" sc = "+sc+" color = "+color);
    int [][] resultTask2_1 = floodFill(image2_1,sr,sc,color);
    System.out.print("Result Array Arrays :");
    printArrayArrays(resultTask2_1);

    int[][] image2_2 = new int [] [] {{0,0,0},{0,0,0}};
    sr = 0; sc = 0; color = 0;
    System.out.println("Seminar2 Task2 insert Data (2):");
    System.out.print("image [][] :");
    printArrayArrays(image2_2);
    System.out.println("sr = "+sr+" sc = "+sc+" color = "+color);
    int [][] resultTask2_2 = floodFill(image2_2,sr,sc,color);
    System.out.print("Result Array Arrays :");
    printArrayArrays(resultTask2_2);

    int[][] image2_3 = new int [] [] {{1,0,1},{0,1,1},{1,1,1}};
    sr = 1; sc = 1; color = 3;
    System.out.println("Seminar2 Task2 insert Data (3):");
    System.out.print("image [][] :");
    printArrayArrays(image2_3);
    System.out.println("sr = "+sr+" sc = "+sc+" color = "+color);
    int [][] resultTask2_3 = floodFill(image2_3,sr,sc,color);
    System.out.print("Result Array Arrays :");
    printArrayArrays(resultTask2_3);

   System.out.println("---------------------------------------------------");
// Task3

   System.out.println("Task3 TreeNode");
   TreeNode root1 = new TreeNode();
   root1.val=1;
   root1.left  = new TreeNode();
   root1.left.val=2;
   root1.left.left = new TreeNode();
   root1.left.left.val=5;

   root1.right = new TreeNode();
   root1.right.val=3;
        System.out.println("Insert TreeNode: 1,2,3,null,5");
        System.out.println("Result Tree: " + binaryTreePaths(root1));

   TreeNode root2 = new TreeNode();
   root2.val=7;
   root2.left  = new TreeNode();
   root2.left.val=6;
   root2.left.left = new TreeNode();
   root2.left.left.val=4;

   root2.right = new TreeNode();
   root2.right.val=3;
   root2.right.right = new TreeNode();
   root2.right.right.val=2;
        System.out.println("Insert TreeNode: 7,6,3,4,null,2");
        System.out.println("Result Tree: " + binaryTreePaths(root2));

   TreeNode root3 = new TreeNode();
   root3.val=3;
        System.out.println("Insert TreeNode: 3");
        System.out.println("Result Tree: " + binaryTreePaths(root3));
    }

    //Task1
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        //int[] count = new int[1];
        //int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    //count[0] = 0;
                    count = 0;
                    //checkPoint(grid, i, j, m, n, count);
                    checkPoint(grid, i, j, m, n);
                    //maxArea = Math.max(count[0], maxArea);
                    maxArea = Math.max(count, maxArea);
                }
            }
        }
        return maxArea;
    }
    //Task1
    private static void checkPoint(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i>= m || j >= n || grid[i][j] != 1){
            return;
        }
        //помечаем проверенную клетку
        grid[i][j] = -1;
        //count[0]++;
        count++;
        checkPoint(grid, i + 1, j, m, n);
        checkPoint(grid, i - 1, j, m, n);
        checkPoint(grid, i, j + 1, m, n);
        checkPoint(grid, i, j - 1, m, n);
    }

    private static void printArrayArrays(int [][] grid){
        System.out.print("[");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("[");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]");
        System.out.println();
    }

////////////////////////////////////////////////////////////////////////////
    //Task2
public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    if(oldColor!= newColor){
        image[sr][sc] = newColor;
        if(sr - 1 >= 0 && image[sr - 1][sc] == oldColor){
            floodFill(image, sr-1, sc, newColor);
        }
        if(sc - 1 >= 0 && image[sr][sc- 1] == oldColor){
            floodFill(image, sr, sc-1, newColor);
        }
        if(sr + 1 < image.length && image[sr + 1][sc] == oldColor){
            floodFill(image, sr+1, sc, newColor);
        }
        if(sc + 1 < image[0].length && image[sr][sc+1] == oldColor){
            floodFill(image, sr, sc+1, newColor);
        }
    }
    return image;
}

// Task3
//-------------------------------------------------------------------------------------
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root != null) searchBT(root, "", result);
        return result;
    }

    private static void searchBT(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) result.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", result);
        if (root.right != null) searchBT(root.right, path + root.val + "->", result);
    }

    // Task4
//----------------------------------------------------------------------------------------

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        return p != null && q != null && p.val == q.val &&
                isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

//}
