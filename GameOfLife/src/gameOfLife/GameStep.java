package gameOfLife;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameStep { //Builder for GameBoard
  private final Set<Cell> cells;
  private final Map<Cell, Integer> neighbours = new HashMap<>();
  private final Set<Cell> newCells = new HashSet<>();

  private GameStep(Set<Cell> liveCells) {
    cells = liveCells;
  }

  private void incrementForPosition(int row, int col) {
    Cell c = new Cell(row, col);
    int newValue = neighbours.containsKey(c) ? (neighbours.get(c) + 1) : 1;
    neighbours.put(c, newValue);
  }

  private void updateNeighbours(Cell c) {
    for (int row = -1; row <= 1; ++row)
      for (int col = -1; col <= 1; ++col)
        if ((row != 0) || (col != 0))
          incrementForPosition(c.row() + row, c.col() + col);
  }

  private void addToNewCells(Cell c, int liveNeighbours) {
    if (GameRules.isCellAlive(liveNeighbours, cells.contains(c)))
      newCells.add(c);
  }

  private GameBoard nextStep() {
    cells.forEach(this::updateNeighbours);
    for (var en : neighbours.entrySet())
      addToNewCells(en.getKey(), en.getValue());
    return new GameBoard(newCells);
  }

  public static GameBoard next(GameBoard g) {
    return new GameStep(g.getLive()).nextStep();
  }
}
