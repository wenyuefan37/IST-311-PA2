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


    }


    @Test
    void testDelete() {


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
            //when the insert position is out of bounce
            dl.insert(5,a1);
        }
        


    @Test
    void testShuffle() {

    }


    @Test
    void testPartition() {



    }

    @Test
    void testtoString() {


    }

}