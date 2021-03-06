package wooteco.chess.domain.strategy.initialize;

import wooteco.chess.domain.piece.Piece;
import wooteco.chess.domain.piece.PieceType;
import wooteco.chess.domain.piece.Team;
import wooteco.chess.domain.position.Position;
import wooteco.chess.domain.position.Positions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class BishopInitializer implements InitializeStrategy {
    @Override
    public Map<Position, Piece> initialize() {
        Map<Position, Piece> pieces = new HashMap<>();
        pieces.put(Positions.of("c8"), new Piece(PieceType.BISHOP, Team.BLACK));
        pieces.put(Positions.of("c1"), new Piece(PieceType.BISHOP, Team.WHITE));
        pieces.put(Positions.of("f8"), new Piece(PieceType.BISHOP, Team.BLACK));
        pieces.put(Positions.of("f1"), new Piece(PieceType.BISHOP, Team.WHITE));

        return Collections.unmodifiableMap(pieces);
    }
}