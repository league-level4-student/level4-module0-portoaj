package _04_Maze_Maker;

import java.util.ArrayList;

import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		Random rand = new Random();
		
		
		//5. call selectNextPath method with the randomly selected cell
		 selectNextPath(maze.getCell(rand.nextInt(w), rand.nextInt(h)));
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.setBeenVisited(true);
		//B. check for unvisited neighbors using the cell
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		for(int i = -1; i < 2; i++)
		{
			for(int j = -1; j < 2; j++)
			{
				if(i + currentCell.getX()< 0 || j + currentCell.getY()< 0 || i + currentCell.getY() >= width || j + currentCell.getY() >= height || (i == 0 && j == 0))
					continue;
				if(maze.getCell(currentCell.getX() + i, currentCell.getY() + j).hasBeenVisited() == false)
					neighbors.add(maze.getCell(currentCell.getX() + i, currentCell.getY() + j));
			}
		}
		//C. if has unvisited neighbors,
			//C1. select one at random.
			
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells

			//C4. make the new cell the current cell and mark it as visited
		
			//C5. call the selectNextPath method with the current cell
			
		if(neighbors.size() > 0)
		{
			Random rand = new Random();
			Cell neighbor = neighbors.get(rand.nextInt(neighbors.size()));
			uncheckedCells.push(neighbor);
			if(neighbor.getX() > currentCell.getX())
			{
				currentCell.setEastWall(false);
				neighbor.setWestWall(false);
			}
			if(neighbor.getX() < currentCell.getX())
			{
				currentCell.setWestWall(false);
				neighbor.setEastWall(false);
			}
			if(neighbor.getY() < currentCell.getY())
			{
				currentCell.setSouthWall(false);
				neighbor.setNorthWall(false);
			}
			if(neighbor.getY() > currentCell.getX())
			{
				currentCell.setNorthWall(false);
				neighbor.setSouthWall(false);
			}
			neighbor.setBeenVisited(true);
			currentCell = neighbor;
			selectNextPath(currentCell);
		}
		//D. if all neighbors are visited
		if(neighbors.size() == 0)
		{
			if(uncheckedCells.size() != 0)
			{
				currentCell = uncheckedCells.pop();
				selectNextPath(currentCell);
			}
		}
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX() > c2.getX())
		{
			c2.setEastWall(false);
			c1.setWestWall(false);
		}
		if(c1.getX() < c2.getX())
		{
			c2.setWestWall(false);
			c1.setEastWall(false);
		}
		if(c1.getY() < c2.getY())
		{
			c2.setSouthWall(false);
			c1.setNorthWall(false);
		}
		if(c1.getY() > c2.getX())
		{
			c2.setNorthWall(false);
			c1.setSouthWall(false);
		}
		return;
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();
		for(int i = -1; i < 2; i++)
		{
			for(int j = -1; j < 2; j++)
			{
				if(i + c.getX()< 0 || j + c.getY()< 0 || i + c.getY() >= width || j + c.getY() >= height || (i == 0 && j == 0))
					continue;
				if(maze.getCell(c.getX() + i, c.getY() + j).hasBeenVisited() == false)
					unvisitedNeighbors.add(maze.getCell(c.getX() + i, c.getY() + j));
			}
		}
		
		return unvisitedNeighbors;
	}
}
