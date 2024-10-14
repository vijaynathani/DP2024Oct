package gameOfLife;

import java.util.Set;

public class BoardSize { //Pure functions
  public static int getMinRow(Set<Cell> cells) {
    return cells.stream().mapToInt(Cell::row).min()
        .orElse(Integer.MAX_VALUE);
  }

  public static int getMaxRow(Set<Cell> cells) {
    return cells.stream().mapToInt(Cell::row).max()
        .orElse(Integer.MIN_VALUE);
  }

  public static int getMinCol(Set<Cell> cells) {
    return cells.stream().mapToInt(Cell::col).min()
        .orElse(Integer.MAX_VALUE);
  }

  public static int getMaxCol(Set<Cell> cells) {
    return cells.stream().mapToInt(Cell::col).max()
        .orElse(Integer.MIN_VALUE);
  }
}
