package Chapter_2;

/**
 * 功能描述
 *
 * @author 古月
 * @date 2023/09/26  18:52
 */
public class ChessBoard {
    private static int[][] board;
    //tr,tc：确定哪个小棋盘的坐标；dr,dc：特殊点坐标
    public static void cover(int tr, int tc, int dr, int dc, int size) {
        if (size == 1) return;
        int s = size / 2;
        //特殊点在左上角
        if (dr < tr + s && dc < tc + s) {
            board[tr + s - 1][tc + s] = 1;
            board[tr + s][tc + s - 1] = 1;
            board[tr + s][tc + s] = 1;
            cover(tr, tc, dr, dc, s);
            cover(tr, tc + s, tr + s - 1, tc + s, s);
            cover(tr + s, tc, tr + s, tc + s - 1, s);
            cover(tr + s, tc + s, tr + s, tc + s, s);
        }
        //特殊点在右上角
        if (dr < tr + s && dc >= tc + s) {
            board[tr + s - 1][tc + s - 1] = 1;
            board[tr + s][tc + s - 1] = 1;
            board[tr + s][tc + s] = 1;
            cover(tr, tc, tr + s - 1, tc + s - 1, s);
            cover(tr, tc + s, dr, dc, s);
            cover(tr + s, tc, tr + s, tc + s - 1, s);
            cover(tr + s, tc + s, tr + s, tc + s, s);
        }
        //特殊点在左下角
        if (dr >= tr + s && dc < tc + s) {
            board[tr + s - 1][tc + s - 1] = 1;
            board[tr + s - 1][tc + s] = 1;
            board[tr + s][tc + s] = 1;
            cover(tr, tc, tr + s - 1, tc + s - 1, s);
            cover(tr, tc + s, tr + s - 1, tc + s, s);
            cover(tr + s, tc, dr, dc, s);
            cover(tr + s, tc + s, tr + s, tc + s, s);
        }
        //特殊点在右下角
        if (dr >= tr + s && dc >= tc + s) {
            board[tr + s - 1][tc + s - 1] = 1;
            board[tr + s - 1][tc + s] = 1;
            board[tr + s][tc + s - 1] = 1;
            cover(tr, tc, tr + s - 1, tc + s - 1, s);
            cover(tr, tc + s, tr + s - 1, tc + s, s);
            cover(tr + s, tc, tr + s, tc + s - 1, s);
            cover(tr + s, tc + s, dr, dc, s);
        }
    }
    public static void main(String[] args) {
        int dr = 2;
        int dc = 7;
        int size = 8;
        board = new int[size][size];
        board[dr][dc] = 1;
        cover(0, 0, dr, dc, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();  // 换行
        }
    }
}