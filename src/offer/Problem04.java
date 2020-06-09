package offer;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/5/25 9:49
 *
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 */
public class Problem04 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean numberIn2DArray = findNumberIn2DArray3(matrix, 17);
        System.out.println(numberIn2DArray);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int width = matrix[0].length;
        int length = matrix.length;
        int before=0;
        int after=width-1;
        for (;before<matrix.length&&after>=0;){
            System.out.println(matrix[before][after]);
            if(target == matrix[before][after]){
                return true;
            }else if(target < matrix[before][after]){
                after--;
            }else if(target > matrix[before][after]){
                before++;
            }
        }

        return false;
    }

    public static boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;

        while (row < rows && column >=0){
            System.out.println( matrix[row][column]);
            if(target == matrix[row][column]){
                return true;
            }else if(target > matrix[row][column]){
                row++;
            }else {
                column--;
            }
        }

        return false;
    }
}
