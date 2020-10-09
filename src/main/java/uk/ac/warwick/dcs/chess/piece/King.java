package uk.ac.warwick.dcs.chess.piece;
import uk.ac.warwick.dcs.chess.*;
public class King extends ChessPiece {
    private static final long serialVersionUID = 1L;
    public King(Board board, boolean isWhite, int vertical, int horizontal) {
        super(board, isWhite, (char)((int)ChessIcons.W_KING + (isWhite ? 0 : 6)), vertical, horizontal);
    }

    @Override
    public Move[] getAvailableMoves() {
        availableMoves.clear();


        int moveH, moveV;
        
        for(int deltaV = -1; deltaV <= 1; deltaV++){
            for(int deltaH = -1; deltaH <= 1; deltaH++){
                moveV = this.vertical + deltaV;
                moveH = this.horizontal + deltaH;
                if(board.locationValid(moveV,moveH) 
                && (board.pieceAtLocation(moveV,moveH) == null || board.pieceAtLocation(moveV,moveH).isWhite != this.isWhite)){
                    Move m = new Move(this,moveV,moveH, false);
                    availableMoves.add(m);
                }
            }
        }
        
        return availableMoves.movesToArray();
    }
}
