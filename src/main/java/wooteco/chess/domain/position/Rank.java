package wooteco.chess.domain.position;

import java.util.Arrays;

public enum Rank {
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1);

    private static final String NUMBER = "^[0-9]$";

    private final int symbol;

    Rank(int symbol) {
        this.symbol = symbol;
    }

    public static Rank of(String rank) {
        if (rank.matches(NUMBER)) {
            return of(Integer.parseInt(rank));
        }
        return valueOf(rank);
    }

    public static Rank of(int rank) {
        return Arrays.stream(values())
                .filter(f -> f.symbol == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 y 좌표값을 입력하였습니다."));
    }

    public int getSymbol() {
        return this.symbol;
    }

    public int calculateGap(Rank rank) {
        return this.symbol - rank.symbol;
    }
}
