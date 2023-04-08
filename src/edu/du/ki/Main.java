package edu.du.ki;

import edu.du.dudraw.DUDraw;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Snake snake1 = new Snake();
		while(true) {
			snake1.update();
			DUDraw.show();
		}

	}

}
