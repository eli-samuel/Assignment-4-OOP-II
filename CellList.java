import java.util.NoSuchElementException;

public class CellList {

    private class CellNode {
        private CellPhone phone;
        private CellNode next;

        public CellNode() {
            phone = null;
            next = null;
        }

        // do we have to do this.phone = new Phone(phone) amd same for next?
        public CellNode(CellPhone phone, CellNode next) {
            this.phone = phone;
            this.next = next;
        }

        public CellNode(CellNode c) {
            phone = new CellPhone(c.phone);
            next = new CellNode(c.next);
        }

        public CellNode clone() {
            return new CellNode(this);
        }

        /**
        * Returns value of phone
        * @return
        */
        public CellPhone getPhone() {
            return phone;
        }

        /**
        * Sets new value of phone
        * @param
        */
        public void setPhone(CellPhone phone) {
            this.phone = phone;
        }

        /**
        * Returns value of next
        * @return
        */
        public CellNode getNext() {
            return next;
        }

        /**
        * Sets new value of next
        * @param
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
    */
    public CellList(CellNode head, int size) {
        this.head = head;
        this.size = size;
    }

    public CellList(CellList c) {
        head = c.head;
        size = c.size;
    }

    public void addToStart(CellPhone c) {
        head = new CellNode(c, head);
        size++;
    }

    public void insertAtIndex(CellPhone c, int i) throws NoSuchElementException {
        if (i >= size) throw new NoSuchElementException();

        CellNode newNode = new CellNode(c, null);
        CellNode curr = head;
        CellNode prev = head;

        for (int n = 0; n<=i; n++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = newNode;
        newNode.next = curr;

        size++;
    }

    public void deleteFromIndex(int i) throws NoSuchElementException {
        if (i >= size) throw new NoSuchElementException();

        CellNode curr = head;
        CellNode prev = head;

        for (int n = 0; n<=i; n++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

        size--;
    }

    public void deleteFromStart() {
        head = new CellNode(head.next.phone, head.next);
        size--;
    }

    public void replaceAtIndex(CellPhone c, int i) {
        if (i >= size) return;

        CellNode newNode = new CellNode(c, null);
        CellNode curr = head;

        for (int n = 0; n<=i; n++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr = newNode;
    }

    public CellNode find(long serialNum) {
        CellNode curr = head;
        while (curr != null) {
            if (curr.phone.getSerialNum() == serialNum) return curr;
            else curr = curr.next;
        }
        return null;
    }

    public boolean contains(long serialNum) {
        CellNode curr = head;
        while (curr != null) {
            if (curr.phone.getSerialNum() == serialNum) return true;
            else curr = curr.next;
        }
        return false;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        else if (o.getClass()!=this.getClass()) return false;
        else{
            CellList cList = (CellList) o;
            if (cList.size != this.size) return false; //this may fail
            else {
                CellNode pos = head;
                CellNode otherPos = cList.head;
                while (pos != null) {
                    if (!(pos.phone.equals(otherPos.phone))) return false;
                    pos = pos.next;
                    otherPos = otherPos.next;
                }
                return true;
            }
        }
    }

    public void show() {
        CellNode curr = head;
        while (curr.next != null) {
            System.out.print(curr.phone + " --> \n");
            curr = curr.next;
        }
        System.out.println("null");

    }
}