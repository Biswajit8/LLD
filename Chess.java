import java.util.HashMap;
import java.util.Map;

public class Chess {

}

abstract class Piece {
    Position currentPosition;
    Board currentBoard; // get current Board from the Piece
    private Color color;

    public void move(Position destination) {
        if(isValid(destination)) { // isValid() tells us what type of Piece it is
            currentPosition=destination;
        }

        Piece destinationPiece= currentBoard.get(destination);
        if (destinationPiece != null && !destinationPiece.getColor().equals(color)) {
            // it is a capture
        }
    }
    boolean isValid(Position end) {
        Board temp=currentBoard;
        temp.makeMove(this,end); // make move & go to end position
        if(kingInCheck(temp,color)) { // pass the current Board & check if the current King is in check
            return false;
        }
        else {
            Piece destinationPiece= currentBoard.get(end);
            if(destinationPiece!=null &&
                destinationPiece.getColor().equals(color)) { // since we cant capture our own piece
                return false;
            }
            return isValidMove();
        }
    }

    abstract boolean isValidMove();

    boolean kingInCheck(Board board,Color color) {
        return false;
    }

    abstract void getAllPossibleMoves();

    public Color getColor() {
        return color;
    }
}

enum Color {
    WHITE, BLACK
}

class Board {
    Map<Position,Piece> pieces=new HashMap<>();
    Cell[][] cells=new Cell[8][8];
    public void makeMove(Piece piece,Position destination) { // take a piece & move it to a destination
        pieces.remove(piece.currentPosition); // remove the piece from current position
        pieces.put(destination,piece); // add the piece to next position
    }

    public void setPiece(int row,int col,Piece piece) {
        // add validations
        cells[row][row].setPiece(piece);
    }

    public Cell getCell(int row,int col) { // if the client wants to set the piece himself, but we don't want a cell to be manipulated outside
        return cells[row][row];
    }

    public Piece get(Position destination) {
        return pieces.get(destination);
    }
}

class Cell {
    Color color;

    public void setPiece(Piece piece) {
    }
}

class Position {

}

class Pawn {
    public void enpassant() {

    }

    public void promotion() {

    }
}

class King {
    public void castle() {
        //
    }
}

class Queen {

}

class Knight {

}

class Bishop {

}

class Rook {

}