package uk.ac.warwick.dcs.chess;

import java.util.ArrayList;
import java.util.Random;
import uk.ac.warwick.dcs.chess.piece.ChessPiece;
import uk.ac.warwick.dcs.chess.structures.stockfish.StockfishClient;
import uk.ac.warwick.dcs.chess.structures.stockfish.engine.enums.Option;
import uk.ac.warwick.dcs.chess.structures.stockfish.engine.enums.Variant;
import uk.ac.warwick.dcs.chess.structures.stockfish.exceptions.StockfishInitException;

public class OurPlayer implements Player {
    private boolean isWhite;
    StockfishClient client;

    Random rng = new Random(Chess.randomSeed);

    int moveNum;
    ArrayList<Double> myRandomList;

    public String getPlayerName() {
        return "Group11";
    }

    public OurPlayer(boolean isWhite) {
        this.isWhite = isWhite;
        moveNum = 0;
        myRandomList = new ArrayList<Double>();
        try {
            client = new StockfishClient.Builder()
                    .setPath("src/main/java/uk/ac/warwick/dcs/chess/structures/stockfish/engines/").setInstances(4)
                    .setOption(Option.Threads, 4) // Number of threads that Stockfish will use
                    .setOption(Option.Skill_Level, 20) // Stockfish skill level 0-20
                    .setVariant(Variant.BMI2) // Stockfish Variant
                    .build();
        } catch (StockfishInitException e) {
            e.printStackTrace();
        }
    }

    public void createRandomList() {
        int numDoublesToGenerate = 4;
        while (myRandomList.size() < (moveNum + numDoublesToGenerate)) {
            double[] newNumbers = rng.doubles(numDoublesToGenerate).toArray();
            for (int i = 0; i < numDoublesToGenerate; i++) {
                myRandomList.add(newNumbers[i]);
            }
        }
    }

    @Override
    public ChessPiece[] getActivePieces() {
        Board board = Chess.getBoard();
        ChessPiece[] myPieces = new ChessPiece[16];
        int p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece cp = board.pieceAtLocation(i, j);
                if (cp != null && cp.isWhite() == isWhite) {
                    myPieces[p] = cp;
                    p++;
                }
            }
        }
        return myPieces;
    }

    @Override
    public boolean getIsWhite() {
        return isWhite;
    }

    @Override
    public Move getMove(int moveNum) {
        this.moveNum = moveNum;
        Board board = Chess.getBoard();
        return null;
    }
}
