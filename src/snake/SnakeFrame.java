package snake;

import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

class SnakeFrame extends JFrame {
	private static final long serialVersionUID = -2542001418764869760L;
	public ArrayList<ArrayList<DataOfSquare>> grid;
	public int width = 20;
	public int height = 20;

	public SnakeFrame() {

		// Creates the arraylist that'll contain the threads
		grid = new ArrayList<ArrayList<DataOfSquare>>();
		ArrayList<DataOfSquare> data;

		// Creates Threads and its data and adds it to the arrayList
		for (int i = 0; i < width; i++) {
			data = new ArrayList<DataOfSquare>();
			for (int j = 0; j < height; j++) {
				DataOfSquare c = new DataOfSquare(2);
				data.add(c);
			}
			grid.add(data);
		}

		// Setting up the layout of the panel
		getContentPane().setLayout(new GridLayout(20, 20, 0, 0));

		// Start & pauses all threads, then adds every square of each thread to
		// the panel
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				getContentPane().add(grid.get(i).get(j).square);
			}
		}

		// initial position of the snake
		Tuple position = new Tuple(10, 10);
		// passing this value to the controller
		ThreadsController c = new ThreadsController(position, grid, width, height);
		// Let's start the game now..
		c.start();

		// Links the window to the keyboardlistener.
		this.addKeyListener((KeyListener) new KeyboardListener());

		// To do : handle multiplayers .. The above works, test it and see what
		// happens

		// Tuple position2 = new Tuple(13,13);
		// ControlleurThreads c2 = new ControlleurThreads(position2);
		// c2.start();

	}
}
