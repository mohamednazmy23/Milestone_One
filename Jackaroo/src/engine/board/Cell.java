package engine.board;

import model.player.Marble;

public class Cell {
	private Marble marble ;
	private CellType cellType ;
	private  boolean trap ;
	

public Cell(CellType celltype) {
	this.cellType= celltype ;
	this.marble= null;
	this.trap= false;
	
	}


public Marble getMarble() {
	return marble;
}


public void setMarble(Marble marble) {
	this.marble = marble;
}


public CellType getCellType() {
	return cellType;
}


public void setCellType(CellType cellType) {
	this.cellType = cellType;
}


public static   boolean isTrap() {
	return false;
}


public void setTrap(boolean trap) {
	this.trap = trap;
}
}
