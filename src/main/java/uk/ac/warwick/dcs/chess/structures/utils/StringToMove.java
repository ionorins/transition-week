package uk.ac.warwick.dcs.chess.structures.utils;

import uk.ac.warwick.dcs.chess.Board;
import uk.ac.warwick.dcs.chess.Move;
import uk.ac.warwick.dcs.chess.piece.ChessPiece;

public class StringToMove {

    private static int charToInt(char c) {
        switch (c) {
            case 'h':
            case '1':
                return 7;
            case '2':
            case 'g':
                return 6;
            case 'f':
            case '3':
                return 5;
            case 'e':
            case '4':
                return 4;
            case 'd':
            case '5':
                return 3;
            case 'c':
            case '6':
                return 2;
            case 'b':
            case '7':
                return 1;
            case 'a':
            case '8':
                return 0;
        }

        return -1;
    }

    public static Move run(String string, Board board) {
        int destinationVertical = charToInt(string.charAt(3));
        int destinationHorizontal = charToInt(string.charAt(2));
        int sourceVertical = charToInt(string.charAt(1));
        int sourceHorizontal = charToInt(string.charAt(0));
        boolean takePiece = board.pieceAtLocation(destinationVertical, destinationHorizontal) != null;
        ChessPiece piece = board.pieceAtLocation(sourceVertical, sourceHorizontal);
        return new Move(piece, destinationVertical, destinationHorizontal, takePiece);
    }

}
