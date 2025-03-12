
package engine.board;

import java.util.ArrayList;
import java.util.List;

import model.Colour;

public class SafeZone {
	
		private  final Colour colour ;
		private final List<Cell> cells;


	public SafeZone(Colour colour ) {
			this.colour = colour;
			this.cells = new ArrayList<>();
			for(int i = 0 ;i <4;i++) {
				cells.add(new Cell(CellType.SAFE));
			}
		}


	public Colour getColour() {
		return colour;
	}


	public List<Cell> getCell() {
		return cells;
	}

			
		}

