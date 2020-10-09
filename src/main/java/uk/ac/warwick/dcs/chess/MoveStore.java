package uk.ac.warwick.dcs.chess;

import java.io.Serializable;
import java.util.ArrayList;

public class MoveStore implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Move> moves;

    public MoveStore() {
        this.moves = new ArrayList<Move>();
    }

    public void clear() {
        this.moves.clear();
    }

    public void add(Move m) {
        this.moves.add(m);
    }

    public Move[] movesToArray() {
        return moves.toArray(new Move[moves.size()]);
    }

    public void cleanInvalidMoves(Board board) {
        // ArrayList<Move> newMoves = new ArrayList<Move>();

        // // board.validateMove(this.moves.get(0));
        // for (Move move : moves) {
        //     Board tmpBoard = board.cloneBoard();

        //     if (move.isTakePiece()) {
        //         // Remove piece from board.
        //         tmpBoard.removePiece(move.getDestinationVertical(), move.getDestinationHorizontal());
        //     }

        //     tmpBoard.applyMove(move);

        //     System.out.println("white");

        //     if (move.getPiece().isWhite() && tmpBoard.testWhiteInCheck())
        //         break;

        //     System.out.println("black");
        //     if (!move.getPiece().isWhite() && tmpBoard.testBlackInCheck())
        //         break;

        //     newMoves.add(move);
        // }

        // moves = newMoves;
    }
}
