package engine.board;

import java.util.ArrayList;
import java.util.Random;

import model.Colour;
import engine.GameManager;

public class Board  implements  BoardManager{
	
	private final GameManager gameManager;
	private final ArrayList<Cell> track;
	private final ArrayList<SafeZone> safeZones;
	private int splitDistance;
	
	public Board(ArrayList<Colour> colourOrder, GameManager gameManager){
		this.gameManager = gameManager;
		this.track = new ArrayList<>();
		this.safeZones = new ArrayList<>();
		this.splitDistance=3;
		//4. Set the track with the correct type of cells whether BASE, Safe Zone ENTRY or NORMAL according
		//to what is mentioned in the game description
		//for loop 100 cells every 25 base , before the base by 2 is the safe zone entry.done
		//5. Change 8 random NORMAL track cells to be flagged as trap using the below assignTrapCell
		//method.
		// generate number from 0 to 100 then check if the cell is  a normal cell and 
		//not a trap (trap is false) set cell trap to true and increment counter by 1 (do this 8 times)
		for(int i=0; i<4 ; i++){
			safeZones.add(new SafeZone(colourOrder.get(i)));
		}
		
		
		
		for(int i=0;i<100;i++){
			
			if (i==25|| i==50 || i==75|| i==0){
				track.add(new Cell(CellType.BASE));
				
			}
			else if  (i==23|| i==48 || i==73|| i==98){
				track.add(new Cell(CellType.ENTRY));}
				
			else track.add(new Cell(CellType.NORMAL));
		}
		for(int i =0;i<8;i++){
			assignTrapCell();
		}
		
	}

	
	public int getSplitDistance() {
		
		return splitDistance;
	}
	
	private void assignTrapCell() {
		Random x = new Random();
		int i = x.nextInt(track.size());
		Cell cell = track.get(i);
		if(cell.getCellType()== CellType.NORMAL && !Cell.isTrap())
			cell.setTrap(true);
		else 
			assignTrapCell();
		
	}


	

	public ArrayList<Cell> getTrack() {
		return track;
	}


	public ArrayList<SafeZone> getSafeZones() {
		return safeZones;
	}


	public void setSplitDistance(int splitDistance) {
		this.splitDistance = splitDistance;
	} 
	
	
}
