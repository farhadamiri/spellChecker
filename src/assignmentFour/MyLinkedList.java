package assignmentFour;

;

public class MyLinkedList<E> {

    private Node<E> head, tail;
   static int compare = 0;
    int size = 0;
    public Object[] add;

    /**
     * Create a default list
     */
    public MyLinkedList() {
    }

    /**
     * Create a list from an array of objects
     */
    public MyLinkedList(E[] objects) {

    }

    /**
     * Return the head element in the list
     */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    /**
     * Return the last element in the list
     */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    /**
     * Add an element to the beginning of the list
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // the new node is the only node in list
        {
            tail = head;
        }

    }

    /**
     * Add an element to the end of the list
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        } else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }
        size++; // Increase size
    }

    /**
     * Add a new element at the specified index in this list The index of the
     * head element is 0
     */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }

    }

    /**
     * Remove the head node and return the object that is contained in the
     * removed node.
     */
    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    /**
     * Remove the last node and return the object that is contained in the
     * removed node.
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    /**
     * Remove the element at the specified position in this list. Return the
     * element that was removed from the list.
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public boolean contains(E e) {

        Node<E> temp = head;
        compare = 0;
        while (temp != null) {
            compare++;
            if (temp.element.equals(e)) {
                return true;
            }
            temp = temp.next;

        }
        return false;

    }

    public int getCompare (){
        return compare;
    }
    /**
     * Returns the element at specified index of this list, returns null if
     * index is invalid.
     */
    public E get(int index) {

        if (index >= 0 && index < size) {
            int counter = 0;
            Node temp = head;
            while (counter < index) {
                temp = temp.next;
                counter++;
            }
            return (E) temp.element;
        } else {
            return null;
        }
    }

    /**
     * Returns the index of the first matching element in this linked list,
     * return ­-1 if no match.
     */
    public int indexOf(E e) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (e.equals(temp.element)) {
                return index;
            }
            index++;
            temp = temp.next;

        }
        return index;
    }

    /**
     * Returns the index of the last matching element in this list, returns ­-1
     * if no match.
     */
    public int lastIndexOf(E e) {
        int index = -1;

        Node temp = head;
        while (temp != null) {
            if (e.equals(temp.element)) {

            }
            index++;
            temp = temp.next;

        }
        return index;
    }

    /**
     * Replaces the element at specified index in this linked list with the
     * specified element. Returns the old element at specified index, otherwise
     * returns null if index is invalid.
     */
    public E set(int index, E e) {
        Node<E> temp = head;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            E old = temp.element;
            temp.element = e;
            return old;
        } else {
            return null;
        }
    }

    /**
     * Override toString() to return elements in the list
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = tail = null;
    }

    /**
     * methods for lab 8 should be implemented here
     */
    private static class Node<E> {

        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}

/*
 */
