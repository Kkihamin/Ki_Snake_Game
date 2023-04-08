package edu.du.ki;
import java.util.Random;

import edu.du.dudraw.DUDraw;
public class Snake {
	public static final int up = 10;
	public static final int left = 12;
	public static final int down = 14;
	public static final int right = 16;
	private int directions = right;
	private DoublyLinkedList SNAKELIST;
	private int headX = 25;
	private int headY = 25;
	private int tailX = 24;
	private int tailY = 25;
	private int foodX = 50;
	private int foodY = 50;
	
	public Snake() {
		startGame();
	}
	
	public void startGame() {
		SNAKELIST = new DoublyLinkedList();
		SNAKELIST.setHead(new Node( headX, headY, null, null ));
		SNAKELIST.setTail(new Node(tailX, tailY, SNAKELIST.getHead(), null ));
		SNAKELIST.getHead().setNext(SNAKELIST.getTail());
		SNAKELIST.getTail().setPrev(SNAKELIST.getHead());
		DUDraw.setCanvasSize(800, 800);
		DUDraw.setScale(0,100);
		DUDraw.enableDoubleBuffering();
	}
	
	public void update() {
		DUDraw.clear();
		currentPosition();
		currentDirection();
		eatFood();
		determineWin();
		draw();
		DUDraw.pause(60);
	}
	
	public void currentPosition() {
		Node currentNode = SNAKELIST.getTail();
		if(directions == right) {
			System.out.println("right");
			for(int i = 0; i < SNAKELIST.size(); i++) {
				if(i == SNAKELIST.size() - 1) {
					currentNode.setX(currentNode.getX() + 1);	
				}else {
					currentNode.setX(currentNode.getPrev().getX());
					currentNode.setY(currentNode.getPrev().getY());
				}
				currentNode = currentNode.getPrev();
			}
		}else if(directions == up) {
			System.out.println("up");
			for(int i = 0; i < SNAKELIST.size(); i++) {
				if(i == SNAKELIST.size() - 1) {
					currentNode.setY(currentNode.getY() + 1);
				}else {
					currentNode.setX(currentNode.getPrev().getX());
					currentNode.setY(currentNode.getPrev().getY());
				}
				currentNode = currentNode.getPrev();
			}
			
		}else if(directions == down) {
			System.out.println("down");
			for(int i = 0; i < SNAKELIST.size(); i++) {
				if(i == SNAKELIST.size() - 1) {
					currentNode.setY(currentNode.getY() - 1);	
				}else {
					currentNode.setX(currentNode.getPrev().getX());
					currentNode.setY(currentNode.getPrev().getY());
				}
				currentNode = currentNode.getPrev();
			}
			
		}else {
			System.out.println("left");
			for(int i = 0; i < SNAKELIST.size(); i++) {
				if(i == SNAKELIST.size() - 1) {
					currentNode.setX(currentNode.getX() - 1);	
				}else {
					currentNode.setX(currentNode.getPrev().getX());
					currentNode.setY(currentNode.getPrev().getY());
				}
				currentNode = currentNode.getPrev();
			}
			
		}
	}
	
	public void currentDirection() {
		if(DUDraw.isKeyPressed(68)) {
			directions = right;
		}
		if(DUDraw.isKeyPressed(87)) {
			directions = up;
		}
		if(DUDraw.isKeyPressed(83)) {
			directions = down;
		}
		if(DUDraw.isKeyPressed(65)) {
			directions = left;
		}
		
	}
	public void moveFood() {
		Random random = new Random();
		foodX = random.nextInt(100);
		foodY = random.nextInt(100);
	}
	public void draw() {
		DUDraw.text(50.0, 90.0, "" + (SNAKELIST.size() - 2));
		System.out.println(SNAKELIST.getHead().getNext().getX());
		Node currentNode = SNAKELIST.getTail();
		for(int i = 0; i < SNAKELIST.size(); i++) {
			DUDraw.filledCircle(currentNode.getX(), currentNode.getY(), 0.5);
			currentNode = currentNode.getPrev();
		}
		System.out.println("Food positions: " + foodX + " " + foodY);
		DUDraw.filledCircle(foodX, foodY, 0.5);
		
	}
	
	public void eatFood() {
	 if(SNAKELIST.getHead().getX() == foodX && SNAKELIST.getHead().getY() == foodY) {
		SNAKELIST.addFirst(SNAKELIST.getHead().getX(), SNAKELIST.getHead().getY() );
		if(directions == right) {
			SNAKELIST.getHead().setX(SNAKELIST.getHead().getX() + 1);
		}else if(directions == up) {
			SNAKELIST.getHead().setY(SNAKELIST.getHead().getY() + 1);
		}else if(directions == down) {
			SNAKELIST.getHead().setY(SNAKELIST.getHead().getY() - 1);
		}else if(directions == left) {
			SNAKELIST.getHead().setX(SNAKELIST.getHead().getX() - 1);
		}
		moveFood();
	 }
	}
	
	public void determineWin() {
		if(SNAKELIST.getHead().getX() > 100 || SNAKELIST.getHead().getX() < 0) {
			DUDraw.pause(500);
			startGame();
		}
		if(SNAKELIST.getHead().getY() > 100 || SNAKELIST.getHead().getY() < 0) {
			DUDraw.pause(500);
			startGame();
		}
		Node currentNode = SNAKELIST.getTail();
		for(int i = 0; i < SNAKELIST.size(); i++) {
			if(currentNode != SNAKELIST.getHead() && ((SNAKELIST.getHead().getX() == currentNode.getX()) && (SNAKELIST.getHead().getY() == currentNode.getY()) )) {
				DUDraw.pause(500);
				startGame();
			}
			
			currentNode = currentNode.getPrev();
		}
		
	}
	
	
	
}
