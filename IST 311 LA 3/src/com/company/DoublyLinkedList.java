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
                if(pointer.album.getID() == album.getID() &&
                        pointer.album.getTitle().equals(album.getTitle()) &&
                        pointer.album.getNumSong() == album.getNumSong() &&
                        pointer.album.getName().equals(album.getName())){
                    return count;
                }else{
                    pointer = pointer.next;
                    count++;
                }
            }
            //return -1 if it isn't in the list
            return -1;
    }


    public Node insert(int location, Album album) throws IllegalArgumentException{
            Node node = new Node(album);
                if (location > numNode || location < 0) {
                    throw new IllegalArgumentException("Location is out of the bounds of the list\n");
                }
                // add to the end of the list
                else if (location == numNode) {
                    append(album);
                } else {
                    // nothing in the list, start the list
                    if (location == 0 && numNode == 0) {
                        this.head = node;
                        this.tail = node;
                        numNode++;
                    }
                    // add node to the head of the list
                    else if (location == 0 && numNode != 0) {
                        this.head.previous = node;
                        node.next = this.head;
                        this.head = node;
                        numNode++;
                    }
                    // add to the middle of the list
                    else if (location < numNode && numNode != 0) {
                        int count = 1;
                        Node pre_node = this.head;
                        Node after_node = this.head.next;
                        while (count < location) {
                            pre_node = after_node;
                            after_node = after_node.next;
                        }
                        pre_node.next = node;
                        pre_node.next.previous = pre_node;
                        pre_node.next.next = after_node;
                        pre_node.next.next.previous = node;
                        numNode++;
                    }
                }
            //return the inserted node
            return node;
        }




    public Node shuffle() {
        DoublyLinkedList oddList = new DoublyLinkedList();
        DoublyLinkedList evenList = new DoublyLinkedList();
        Node pointer = new Node(null);
        pointer = this.head;
        int count = 0;
        while(pointer != null){
            if(count%2 == 0){
                evenList.append(pointer.album);
            }
            else{
                oddList.append(pointer.album);
            }
            count++;
            pointer = pointer.next;
        }
        Node pointer1 = new Node(null);
        Node pointer2 = new Node(null);
        pointer1 = oddList.head;
        pointer2 = evenList.head;
        DoublyLinkedList result = new DoublyLinkedList();
        while(pointer1 != null){
            result.append(pointer1.album);
            result.append(pointer2.album);
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        if(pointer2 != null){
            result.append(pointer2.album);
        }
        //Return the head of a shuffled list
        return result.head;
    }



    public DoublyLinkedList<Album> partition(Node album) {
        

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
