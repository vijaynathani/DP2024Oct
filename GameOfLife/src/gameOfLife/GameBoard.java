package gameOfLife;
import java.util.Collections;
import java.util.Set;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;

public class GameBoard { //Flyweight
    private final Set<Cell> live;
    public static final String LIVE = "X", DEAD = " ";
    public GameBoard(Set<Cell> live) {
        this.live = Collections.unmodifiableSet(live);
    }
    private String printRow(int row, int minCol, int maxCol) {
        return IntStream.rangeClosed(minCol, maxCol)
                .mapToObj(j -> live.contains(new Cell(row, j)) ? LIVE : DEAD)
                .collect(joining());
    }
    @Override
    public String toString() {
        var minCol = BoardSize.getMinCol(live);
        var maxCol = BoardSize.getMaxCol(live);
        return IntStream.rangeClosed(BoardSize.getMinRow(live), BoardSize.getMaxRow(live))
                    .mapToObj(i -> printRow(i, minCol, maxCol))
                    .collect(joining("\n"));
    }
    Set<Cell> getLive() {
        return live;
    }
}
