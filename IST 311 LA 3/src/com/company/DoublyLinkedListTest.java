package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void testAppend() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        assertNull(dll.head);
        assertNull(dll.tail);

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        assertEquals(1, dll.append(a1).album.numberOfSongs);

        Album a2 = new Album(2, artistNames, "album 2", 2);
        assertEquals(2, dll.append(a2).album.numberOfSongs);

        Album a3 = new Album(3, artistNames, "album 3", 3);
        assertEquals(3, dll.append(a3).album.numberOfSongs);

        assertEquals(1, dll.head.album.numberOfSongs);

        assertEquals("1 -> 2 -> 3 -> NULL", dll.toString());

    }


    @Test
    void testGetIndex() {
            DoublyLinkedList dl = new DoublyLinkedList();
            ArrayList<String> list = new ArrayList<>();
            list.add("Mona");
            list.add("Mona Fan");
            Album a1 = new Album(1,list,"a",1);
            Album a2 = new Album(2,list,"b",3);
            Album a3 = new Album(3,list,"c",6);
            Album a4 = new Album(4,list,"d",7);
            dl.append(a1);
            dl.append(a2);
            dl.append(a3);
            assertEquals(0,dl.getIndex(a1));
            //when the node is not in the list
            assertEquals(-1,dl.getIndex(a4));
        }


    @Test
    void testDelete(){
            DoublyLinkedList dl = new DoublyLinkedList();
            ArrayList<String> list = new ArrayList<>();
            list.add("mona");
            list.add("mona Fan");
            Album a1 = new Album(1,list,"a",1);
            Album a2 = new Album(2,list,"b",3);
            Album a3 = new Album(3,list,"c",6);
            Album a4 = new Album(4,list,"d",7);
            //delete when the list only contains one node
            dl.append(a1);
            assertEquals(a1,dl.delete(0).album);
            //delete head
            dl.append(a1);
            dl.append(a2);
            dl.append(a3);
            dl.append(a4);
            assertEquals(a1,dl.delete(0).album);
            //delete tail
            assertEquals(a4,dl.delete(2).album);
            //delete middle
            dl.append(a4);
            assertEquals(a3,dl.delete(1).album);
    }


    @Test
    void testInsert() {
            DoublyLinkedList dl = new DoublyLinkedList();
            ArrayList<String> list = new ArrayList<>();
            list.add("haha");
            list.add("sjoidj sss");
            Album a1 = new Album(1,list,"a",1);
            Album a2 = new Album(2,list,"b",3);
            Album a3 = new Album(3,list,"c",6);
            Album a4 = new Album(4,list,"d",7);
            //insert when the list is empty
            assertEquals(a1,dl.insert(0,a1).album);
            System.out.println(dl.toString());
            //insert at head
            assertEquals(a2,dl.insert(0,a2).album);
            System.out.println(dl.toString());
            //insert at tail
            assertEquals(a3,dl.insert(2,a3).album);
            System.out.println(dl.toString());
            //insert at middle
            assertEquals(a4,dl.insert(1,a4).album);
            System.out.println(dl.toString());

        }



    @Test
    void testShuffle() {
            DoublyLinkedList dl = new DoublyLinkedList();
            DoublyLinkedList dl2 = new DoublyLinkedList();
            ArrayList<String> list = new ArrayList<>();
            list.add("Mona");
            list.add("Mona Fan");
            Album a1 = new Album(1,list,"a",1);
            Album a2 = new Album(2,list,"b",3);
            Album a3 = new Album(3,list,"c",6);
            Album a4 = new Album(4,list,"d",7);
            //when the number of node is odd
            dl.append(a1);
            dl.append(a2);
            dl.append(a3);
            dl.append(a4);
            Node pointer = dl.shuffle();

            while(pointer.next != null){
                System.out.println(pointer.album);
                pointer = pointer.next;
            }
            System.out.println(pointer.album);

            System.out.println(dl.toString());
            //assertEquals(a2,dl.shuffle().);
            System.out.println(dl.shuffle());

            //when the number of node is even
            dl.append(a1);
            dl.append(a2);
            dl.append(a3);
            dl.append(a4);
        }


    @Test
    void testPartition() {
            DoublyLinkedList dl = new DoublyLinkedList();
            DoublyLinkedList dl2 = new DoublyLinkedList();
            ArrayList<String> list = new ArrayList<>();
            list.add("Mona");
            list.add("MOna Fan");
            Album a1 = new Album(1,list,"a",1);
            Album a2 = new Album(2,list,"b",3);
            Album a3 = new Album(3,list,"c",6);
            Album a4 = new Album(4,list,"d",7);
            dl.append(a1);
            dl.append(a2);
            dl.append(a3);
            dl.append(a4);
            dl2.append(a2);
            dl2.append(a3);
            dl2.append(a4);
            Node n1 = new Node(a2);
            assertEquals(dl2.toString(),dl.partition(n1).toString());
            System.out.println(dl2);
        }


}