package edu.du.ki;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 2;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int x, int y) {
        Node newNode = new Node(x, y, this.head, this.head.getNext());

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrev(newNode);
        }

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(int x, int y ) {
        Node newNode = new Node(x, y, this.head, this.head.getNext());

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }

        tail = newNode;
        size++;
    }

    public int[] removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }

        Node removedNode = head;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }

        removedNode.setNext(null);
        size--;
        return removedNode.getData();
    }

    public int[] removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }

        Node removedNode = tail;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        removedNode.setPrev(null);
        size--;
        return removedNode.getData();
    }

    public int[] peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }

        return head.getData();
    }

    public int[] peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }

        return tail.getData();
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    
    public String toString() {
		String result = "[ ";
		Node current = head.getNext();
		while(current != tail) {
			result = result + current.toString() + " ";
			current = current.getNext();
			
		}
		result += " ]";
		return result;
	}

	public void setHead(Node head) {
		// TODO Auto-generated method stub
		this.head = head;
		
	}
	
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public Node getHead() {
		return this.head;
	}
	public Node getTail() {
		return this.tail;
	}
}