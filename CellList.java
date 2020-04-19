// -----------------------------------------------------
// Assignment 4
// Question: Part 2 (LinkedList)
// Written by: Eli Samuel (40122277) and David Roper (40131739)
// -----------------------------------------------------

/**
* Names
* @author Eli Samuel 40122277
* @author David Roper 40131739
* Comp249
* Assignment 4
* Due Date: April 19th 2020
*/

/*
* This the the CellList class a LinkedList with inner class CellNode, it a variables head and size while the
* inner Cellnode has variables phone and next. each class have getters/setters appropriate constructors as well
* as deep copy and clone methods. CellList has various LinkedList type methods such as show(), insertAtIndex, etc.
*/

import java.util.NoSuchElementException;

public class CellList {

    protected class CellNode {
        private CellPhone phone;
        private CellNode next;

        /**
        * default contructor
        */
        public CellNode() {
            phone = null;
            next = null;
        }

        /**
        * @param phone a cellphone
        * @param next a cellnode
        */
        private CellNode(CellPhone phone, CellNode next) {
            this.phone = phone;
            this.next = next;
        }

        /**
        * @param c a cellnode
        */
        public CellNode(CellNode c) {
            if (c.next == null) return;
            phone = new CellPhone(c.phone, c.phone.getSerialNum());
            next = c.next.clone();
        }

        /**
        * a cellnode clone method
        * @return a Cellnode
        */
        public CellNode clone() {
            return new CellNode(this);
        }

        /**
        * Returns value of phone
        * @return phone a CellPhone
        */
        public CellPhone getPhone() {
            return phone;
        }

        /**
        * Sets new value of phone
        * @param phone a CellPhone
        */
        public void setPhone(CellPhone phone) {
            this.phone = phone;
        }

        /**
        * Returns value of next
        * @return next a CellNode
        */
        public CellNode getNext() {
            return next;
        }

        /**
        * Sets new value of next
        * @param next a CellNode
        */
        public void setNext(CellNode next) {
            this.next = next;
        }
    }

    private CellNode head;
    private int size;

    /**
    * Default empty CellList constructor
    */
    public CellList() {
        head = new CellNode();
        size = 0;
    }

    /**
    * Default CellList constructor
    * @param head a CellNode variable
    * @param size and integer variable
    */
    public CellList(CellNode head, int size) {
        this.head = head;
        this.size = size;
    }

    /**
    * @param c a celllist
    */
    public CellList(CellList c) {
        head = new CellNode(c.head);
        size = c.size;
    }

    /**
    * Clone method
    * @return CellList
    */
    public CellList clone() {
        return new CellList(this);
    }

    /**
    * @param c a Cellphone
    */
    public void addToStart(CellPhone c) {
        head = new CellNode(c, head);
        size++;
    }

    /**
    * @param c Cellphone
    * @param i integer
    */
    public void insertAtIndex(CellPhone c, int i) {
        if (i > size || size < 0) throw new NoSuchElementException("Error: Invalid index " + i);


        CellNode newNode = new CellNode(c, null);
        CellNode curr = head;
        CellNode prev = head;

        System.out.println("\nInserting new node with value " + c + " at index # " + i + ".");
        // Handle the special case when insertion on head
        if (i == 0) {
            head = new CellNode(c, head);
            size++;
        }
        else {
            for (int n = 0; n < i; n++) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = newNode;
            newNode.next = curr;

            size++;
        }
    }

    /**
    * @param i an integer
    */
    public void deleteFromIndex(int i) {
        if (i >= size) throw new NoSuchElementException("Error: Invalid index " + i);

        // Handle the special case when list has only one node
        if (size == 1) {
            System.out.println("\nDeleting the only node of the list at index # " + 0 + ".");
            head = null;
            size--;
            return;
        }

        // Handle the special cases when deletion on head
        if (i == 0) {
            System.out.println("\nDeleting node with value " + head.phone + " from index # " + i + ".");
            head = head.next;
            size--;
        }
        // Deletion anywhere else, including tail
        else {
            CellNode curr = head;
            CellNode prev = head;

            for (int n = 0; n < i; n++) {
                prev = curr;
                curr = curr.next;
            }
            System.out.println("\nDeleting node with value " + curr.phone + " from index # " + i + ".");
            prev.next = curr.next;

            size--;
        }
    }

    /**
    * deletefromstart deletes head
    */
    public void deleteFromStart() {
        head = head.next;
        size--;
    }

    /**
    * @param c Cellphone
    * @param i integer
    */
    public void replaceAtIndex(CellPhone c, int i) {
        if (i >= size) return;

        CellNode curr = head;

        for (int n = 0; n<i; n++) {
            curr = curr.next;
        }

        System.out.println("Replacing value at index # " + i + " from " + curr.phone + " to " + c + ". \n");

        curr.phone = c;
    }

    /*
    * Originally, this causes a privacy leak as you return a reference to the node, if the user changes
    * anything in the phone, it changes it in the cell list, which is not wanted. To fix this, we returned
    * a new node (with a different reference)
    */
    /**
    * @param serialNum a long
    * @return null or clone of phone
    */
    public CellNode find(long serialNum) {
        int iterations = 1;
        CellNode curr = head;
        while (curr.phone != null) {
            if (curr.phone.getSerialNum() == serialNum) {
                System.out.println("Performed " + iterations + " iteration" + (iterations == 1 ? "." : "s."));
                return curr.clone();
            }
            else {
                curr = curr.next;
                iterations++;
            }
        }
        System.out.println("Performed " + (iterations-1) + " iteration" + (iterations == 1 ? "." : "s."));
        return null;
    }

    /**
    * @param serialNum a long
    * @return a boolean
    */
    public boolean contains(long serialNum) {
        CellNode curr = head;
        while (curr.phone != null) {
            if (curr.phone.getSerialNum() == serialNum) return true;
            else curr = curr.next;
        }
        return false;
    }

    /**
    * equals method for list
    * @return a boolean value
    */
    public boolean equals(Object o) {
        if (o == null) return false;
        else if (o.getClass()!=this.getClass()) return false;
        else{
            CellList cList = (CellList) o;
            if (cList.size != this.size) return false; //this may fail
            else {
                CellNode pos = head;
                CellNode otherPos = cList.head;
                while (pos.next != null) {
                    if (!(pos.phone.equals(otherPos.phone))) return false;
                    pos = pos.next;
                    otherPos = otherPos.next;
                }
                return true;
            }
        }
    }

    /**
    *  show method prints out celllist
    */
    public void show() {
        if (size == 0) {
            System.out.println("There is nothing to display; list is empty.");
            return;
        }

        System.out.println("The current size of the list is " + size + ". Here are the contents of the list:");

        CellNode curr = head;
        while (curr.next != null) {
            System.out.print(curr.phone + " --> \n");
            curr = curr.next;
        }
        System.out.println("null");

    }
}
