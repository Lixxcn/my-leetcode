package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Li-Xiaoxu
 * @version 1.0
 * @date 2020/6/10 11:06
 */
public class Problem12 {
    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
//        char[][] board = {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//        boolean exist = problem12.exist(board, word);
//        System.out.println(exist);
//
//        char[][] board1 = {{'a'}};
//        String word1 = "ab";
//        boolean exist1 = problem12.exist(board1, word1);
//        System.out.println(exist1);

//        char[][] board2 = {{'a','b'}};
//        String word2 = "ba";
//        boolean exist2 = problem12.exist(board2, word2);
//        System.out.println(exist2);

//        char[][] board2 = {{'a','a'}};
//        String word2 = "aaa";
//        boolean exist2 = problem12.exist(board2, word2);
//        System.out.println(exist2);

        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
        String word = "AAB";
        boolean exist = problem12.exist1(board, word);
        System.out.println(exist);
    }
    public boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
    public boolean exist(char[][] board, String word) {
        int length = word.length();
        int index = 0;
        
        int rows = board.length;
        int columns = board[0].length;

        List<RemoveElement> removeElements = new ArrayList<>();

        for(int row=0; row<rows; row++){
            for(int column=0; column<columns; column++){
                if(word.charAt(index) == board[row][column]){
                    removeElements.add(new RemoveElement(row,column));
                    while (index < length -1) {
                        index++;
                        if (row - 1 >= 0 && board[row - 1][column] == word.charAt(index) && !removeElements.contains(new RemoveElement(row-1,column))) {//上
                            row = row - 1;
                            removeElements.add(new RemoveElement(row,column));
                        } else if (row + 1 < rows && board[row + 1][column] == word.charAt(index) && !removeElements.contains(new RemoveElement(row+1,column))) {//下
                            row = row + 1;
                            removeElements.add(new RemoveElement(row,column));
                        } else if (column - 1 >= 0 && board[row][column - 1] == word.charAt(index) && !removeElements.contains(new RemoveElement(row,column-1))) {//左
                            column = column - 1;
                            removeElements.add(new RemoveElement(row,column));
                        } else if (column + 1 < columns && board[row][column + 1] == word.charAt(index) && !removeElements.contains(new RemoveElement(row,column+1))) {//右
                            column = column + 1;
                            removeElements.add(new RemoveElement(row,column));
                        }else {
                            return false;
                        }
                    }
                    if(index == length-1){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class RemoveElement{
    int row;
    int column;

    public RemoveElement(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

//    public boolean contains(int row, int column){
//        if(this.row == row && this.column == column){
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveElement that = (RemoveElement) o;
        return row == that.row &&
                column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
