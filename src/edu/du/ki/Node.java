package edu.du.ki;



public class Node {
    

	private int x;
    private int y;
    private Node prev;
    private Node next;

    public Node(int x , int y, Node prev, Node next) {
        this.x = x;
        this.y = y;
        this.prev = prev;
        this.next = next;
    }

    public int[] getData() {
    	int[] data = new int[2];
    	data[0] = x;
    	data[1] = y;
        return data;
    }

    public void setData(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public String toString() {
    	return "" + this.x + ", " + this.y;
    }
    public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}