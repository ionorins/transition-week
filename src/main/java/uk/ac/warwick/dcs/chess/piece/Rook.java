package uk.ac.warwick.dcs.chess.piece;

import uk.ac.warwick.dcs.chess.*;

public class Rook extends ChessPiece {
    private static final long serialVersionUID = 1L;

    public Rook(Board board, boolean isWhite, int vertical, int horizontal) {
        super(board, isWhite, (char) ((int) ChessIcons.W_ROOK + (isWhite ? 0 : 6)), vertical, horizontal);
    }

    @Override
    public Move[] getAvailableMoves() {
        availableMoves.clear();

        // down
        int v = this.vertical;
        int h = this.horizontal;

        while (++v < 8) {
            if (board.pieceAtLocation(v, h) == null)
                availableMoves.add(new Move(this, v, h, false));
            else {
                if (board.pieceAtLocation(v, h).isWhite() != this.isWhite())
                    availableMoves.add(new Move(this, v, h, true));
                break;
            }
        }

        // up
        v = this.vertical;
        h = this.horizontal;

        while (--v >= 0) {
            if (board.pieceAtLocation(v, h) == null)
                availableMoves.add(new Move(this, v, h, false));
            else {
                if (board.pieceAtLocation(v, h).isWhite() != this.isWhite())
                    availableMoves.add(new Move(this, v, h, true));
                break;
            }
        }

        // right
        v = this.vertical;
        h = this.horizontal;

        while (++h < 8) {
            if (board.pieceAtLocation(v, h) == null)
                availableMoves.add(new Move(this, v, h, false));
            else {
                if (board.pieceAtLocation(v, h).isWhite() != this.isWhite())
                    availableMoves.add(new Move(this, v, h, true));
                break;
            }
        }

        // left
        v = this.vertical;
        h = this.horizontal;

        while (--h >= 0) {
            if (board.pieceAtLocation(v, h) == null)
                availableMoves.add(new Move(this, v, h, false));
            else {
                if (board.pieceAtLocation(v, h).isWhite() != this.isWhite())
                    availableMoves.add(new Move(this, v, h, true));
                break;
            }
        }

        availableMoves.cleanInvalidMoves(board);
        return availableMoves.movesToArray();
    }

}
