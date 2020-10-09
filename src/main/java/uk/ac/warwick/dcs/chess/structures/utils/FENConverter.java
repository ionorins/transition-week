package uk.ac.warwick.dcs.chess.structures.utils;

import uk.ac.warwick.dcs.chess.Board;
import uk.ac.warwick.dcs.chess.Player;
import uk.ac.warwick.dcs.chess.piece.*;

public class FENConverter {
    public FENConverter() {
    }

    public static String convert(Board board, Player player) {
        StringBuilder FEN = new StringBuilder();

//        iterate through rows
        for (int y = 0; y < 8; y++) {
//            keep count of blanks on row
            int blanks = 0;

            for (int x = 0; x < 8; x++) {
                ChessPiece piece = board.pieceAtLocation(x, y);

                if (piece == null) {
                    blanks++;
                } else {
//                    end of blanks, append and reset counter
                    if (blanks > 0) {
                        FEN.append(blanks);
                        blanks = 0;
                    }

                    if (piece instanceof Pawn) {
                        FEN.append(piece.isWhite() ? "P" : "p");
                    } else if (piece instanceof Knight) {
                        FEN.append(piece.isWhite() ? "N" : "n");
                    } else if (piece instanceof Bishop) {
                        FEN.append(piece.isWhite() ? "B" : "b");
                    } else if (piece instanceof Rook) {
                        FEN.append(piece.isWhite() ? "R" : "r");
                    } else if (piece instanceof Queen) {
                        FEN.append(piece.isWhite() ? "Q" : "q");
                    } else if (piece instanceof King) {
                        FEN.append(piece.isWhite() ? "K" : "k");
                    }
                }
            }
            if (y != 7) FEN.append("/");
        }

        FEN.append(player.getIsWhite() ? " w" : " b")
                .append(" -")
                .append(" -")
                .append(" 0")
                .append(" 0");

        return FEN.toString();
    }
}
