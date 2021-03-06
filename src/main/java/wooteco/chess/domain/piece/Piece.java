package wooteco.chess.domain.piece;

import wooteco.chess.domain.board.Board;
import wooteco.chess.domain.position.Position;

import java.util.Objects;

public class Piece {
    private final PieceType pieceType;
    private final Team team;

    public Piece(final PieceType pieceType, final Team team) {
        this.pieceType = pieceType;
        this.team = team;
    }

    public String toSymbol() {
        return this.team.symbolize(this.pieceType.getSymbol());
    }

    public boolean movable(Position source, Position target, Board board) {
        return this.pieceType.movable(source, target, board);
    }

    public boolean isEnemy(Piece targetPiece) {
        return isEnemy(targetPiece.getTeam());
    }

    public boolean isEnemy(Team team) {
        return !this.team.isSameTeamWith(team);
    }

    public boolean isWhiteKing() {
        return this.pieceType.isKing() && this.team.isWhite();
    }

    public boolean isBlackKing() {
        return this.pieceType.isKing() && !this.team.isWhite();
    }

    public boolean isPawn() {
        return this.pieceType.isPawn();
    }

    public Team getTeam() {
        return this.team;
    }

    public double getScore() {
        return this.pieceType.getScore();
    }

    @Override
    public String toString() {
        return pieceType.toString() + "_" + team.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return pieceType == piece.pieceType &&
                team == piece.team;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType, team);
    }
}
