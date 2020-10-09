package uk.ac.warwick.dcs.chess.piece;
import uk.ac.warwick.dcs.chess.*;
public class Knight extends ChessPiece {
    private static final long serialVersionUID = 1L;
    public Knight(Board board, boolean isWhite, int vertical, int horizontal) {
        super(board, isWhite, (char)((int)ChessIcons.W_KNIGHT + (isWhite ? 0 : 6)), vertical, horizontal);
    }
    @Override
    public Move[] getAvailableMoves() {
        availableMoves.clear();
        int v = this.vertical;
        int h = this.horizontal;
        int[][] positions = {
                {v+2, h+1}, {v+1, h+2}, {v-1, h+2}, {v-2, h+1}, {v-2, h-1}, {v-1, h-2}, {v+1, h-2}, {v+2, h-1}
        };
        for (int[] vh : positions) {
            if (vh[0] < 0 || vh[0] > 7 || vh[1] < 0 || vh[1] > 7) break;
            if (board.pieceAtLocation(vh[0], vh[1]) == null)
                availableMoves.add(new Move(this, vh[0], vh[1], false));
            else {
                if (board.pieceAtLocation(vh[0], vh[1]).isWhite() != this.isWhite())
                    availableMoves.add(new Move(this, vh[0], vh[1], true));
            }
        }
        return availableMoves.movesToArray();
    }
}