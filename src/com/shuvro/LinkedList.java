package com.shuvro;

// Singly Linked List Implementation
public class LinkedList {

    Node head; // head of list

    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // **************INSERTION**************

    public static LinkedList insert(LinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        /*
        * If the Linked List is empty,
        * then make the new node as head
        * */

        if (list.head == null) {
            list.head = new_node;
        } else {
            /*
            * Else traverse till the last node
            * and insert the new_node there
            * */
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            /*
            * Insert the new_node at last node
            * */
            last.next = new_node;
        }

        return list;
    }

    // **************TRAVERSAL**************

    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
        System.out.println("\n");
    }

    // **************DELETION BY KEY**************

    public static LinkedList deleteByKey(LinkedList list, int key) {

        // Store head node
        Node currNode = list.head, prev = null;

        /*
        * If head node itself holds the key to be deleted
        * */

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            System.out.println(key + " found and deleted");
            return list;
        }

        /*
        * If the key is somewhere other than at head
        * */
        while (currNode != null && currNode.data != key) {
            /*
            * If currNode does not hold key
            * continue to next node
            * */
            prev = currNode;
            currNode = currNode.next;
        }

        /*
        * If the key was present, it should be at currNode
        * Therefore the currNode shall not be null
        * */
        if (currNode != null) {

            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        /*
        * If the key is not present
        * */
        if (currNode == null) {
            System.out.println(key + " not found");
        }
        return list;
    }

    // **************DELETION OF ALL KEY GREATER THAN A GIVEN KEY**************

    public static LinkedList removeAllBasedOnInputValue(LinkedList list, int key) {

        Node currNode = list.head;

        // Traverse through the LinkedList
        while (currNode != null) {

            if (currNode.data > key) {
                deleteByKey(list, currNode.data);
            }
            // Go to next node
            currNode = currNode.next;
        }

        return list;
    }

    // **************DELETION OF TAIL**************
    public static LinkedList removeTail(LinkedList list) {
        Node currNode = list.head;

        while (currNode.next.next != null) {
            // Go to next node
            currNode = currNode.next;
        }
        currNode.next = null;
        return list;
    }


    // **************MAIN METHOD**************

    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        //
        // ******INSERTION******
        //

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        list = insert(list, 9);
        list = insert(list, 10);

        // Print the LinkedList
        printList(list);


        //
        // ******DELETION OF ALL GREATER VALUE THEN THE GIVEN KEY******
        //
        removeAllBasedOnInputValue(list, 2);

        // Print the LinkedList
        printList(list);

        //
        // ******REMOVE THE TAIL******
        //
        removeTail(list);

        // Print the LinkedList
        printList(list);

    }
}
