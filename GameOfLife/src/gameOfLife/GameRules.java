package gameOfLife;
public class GameRules { //Pure functions
    public static boolean isCellAlive(int neighbourCount,
            boolean oldCellLive) {
        return (neighbourCount == 3)
                || ((neighbourCount == 2) && oldCellLive);
    }
}
