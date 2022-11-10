package com.company;


public class DoublyLinkedList <T extends Comparable<T>> {

    protected Node head;
    protected Node tail;

    int numNode = 0;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public Node append(Album album) {

        //create a new node
        Node toAppend = new Node(album);

        //check if list is empty
        if (head == null) {
            head = toAppend;
            tail = toAppend;
        }

        //if list length is one or more than one
        else {
            toAppend.previous = tail;
            tail.next = toAppend;
            tail = tail.next;
        }

        numNode += 1;
        //return node
        return toAppend;
    }


    public Node delete(int location) throws IllegalArgumentException{
        Node toDelete = new Node(null);
        if(location >= numNode || location <0){
            throw new IllegalArgumentException("location is out of boundary");
        }
        else if (numNode == 1&& location ==0){
            toDelete = this.head;
            this.head = null;
            this.tail = null;
        }

        else if(numNode>1 &&location == 0){
            toDelete = this.head;
            this.head = this.head.next;
            this.head.previous = null;
        }
        else{
            int count = 0;
            Node pointer = this.head;
            while (count <location-1){
                pointer = pointer.next;
                count++;
            }
            toDelete = pointer.next;
            pointer.next = pointer.next.next;
            pointer.next.previous = pointer;
        }
        numNode--;
        return toDelete;
    }


    public int getIndex(Album album) {
    Node pointer = this.head;
    int count = 0;
    while(pointer != null){
        if(pointer.album.getID() == album.getID())
    }

    }


    public Node insert(int location, Album album) throws IllegalArgumentException{


    }


    public Node shuffle() {


    }


    public DoublyLinkedList<Album> partition(Album album) {


    }


    @Override
    public String toString() {

        // get a current pointer
        Node toPrint = this.head;

        // get a string builder
        StringBuilder stringBuilder = new StringBuilder();

        // loop through all the nodes
        while (toPrint != null) {

            // append the content of the string to the builder
            stringBuilder.append(toPrint.album.numberOfSongs);
            stringBuilder.append(" -> ");

            // advance the pointer
            toPrint = toPrint.next;
        }

        // append null
        stringBuilder.append("NULL");

        // return the result
        return stringBuilder.toString();
    }
}
