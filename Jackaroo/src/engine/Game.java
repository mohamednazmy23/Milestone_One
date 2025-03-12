package engine;

import model.player.*;
import model.Colour;
import model.card.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import model.card.Deck;
import engine.board.Board;
import engine.board.BoardManager;

public class Game implements GameManager {
    private final Board board;
    private final ArrayList<Player> players;
    private final ArrayList<Card> firePit;
    private int currentPlayerIndex;
    private int turn;

    public Game(String playerName) throws IOException {
       
        ArrayList<Colour> colourOrder = new ArrayList<>();
       
        colourOrder.add(Colour.RED);
        colourOrder.add(Colour.GREEN);
        colourOrder.add(Colour.BLUE);
        colourOrder.add(Colour.YELLOW);
        Collections.shuffle(colourOrder); 
        
      board = new Board(colourOrder, this); 

        
        Deck.loadCardPool(this.board, this);

        
        players = new ArrayList<>();
        players.add(new Player(playerName, colourOrder.get(0)));

       
        players.add(new CPU("CPU 1", colourOrder.get(1), board));
        players.add(new CPU("CPU 2", colourOrder.get(2), board));
        players.add(new CPU("CPU 3", colourOrder.get(3), board));

        
        for (Player player : players) {
            player.getHand().addAll(Deck.drawCards());
        }

        
        currentPlayerIndex = 0;
        turn = 0;
       firePit = new ArrayList<>();
    }

	

	
   
	public Board getBoard() {
		return board;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<Card> getFirePit() {
		return firePit;
	}
    

   
}