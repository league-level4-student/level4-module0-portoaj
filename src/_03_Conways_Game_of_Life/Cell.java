package _03_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Graphics;

public class Cell implements Drawable{
	public boolean isAlive = false;
	
	private int x;
	private int y;

	private int cellSize;
	
	
	public Cell(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.cellSize = size;
	}
	
	//11. Complete tue liveOrDie method
	//    It sets isAlive to true or false based on the neighbors and 
	//the rules of the game
	/*
	 * 1. Any live cell with fewer than two live nieghbours dies, as if caused by underpopulation.
	 * 2. Any live cell with two or three live neighbours lives on to the next generation.
	 * 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
	 * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 * (source: Wikipedia)
	 * */
	public void liveOrDie(int numNeighbors) {
		if(numNeighbors < 2 && isAlive)
			isAlive = false;
		else if(numNeighbors > 3 && isAlive)
			isAlive = false;
		else if(numNeighbors == 3 && !isAlive)
			isAlive = true;
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	//12. Complete the draw method.
	//    It draws a colored square if cell is alive
	//    draws empty square if cell is dead
	@Override
	public void draw(Graphics g) {
		if(isAlive)
			g.setColor(new Color(100,50,50));
		else
			g.setColor(new Color(255,255,255));
			
		g.fillRect(x, y, cellSize, cellSize);
			
		
		
		
		
	}
}
