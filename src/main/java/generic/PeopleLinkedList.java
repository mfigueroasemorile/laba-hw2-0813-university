package generic;

import model.Student;

public class PeopleLinkedList<T> {
    People<T> head;

    public void remove(int index) {

        if (index == 0) {
            head = head.getNext();
            return;
        }

        People<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.getNext() == null) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
            current = current.getNext();
        }

        People<T> nodeToRemove = current.getNext();
        if (nodeToRemove != null) {
            current.setNext(nodeToRemove.getNext());
        }
    }

    public void add(int index, T element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        People<T> newPerson = new People<>(element);

        if (index == 0) {
            newPerson.setNext(head);
            head = newPerson;
            return;
        }

        People<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.getNext() == null) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
            current = current.getNext();
        }

        newPerson.setNext(current.getNext());
        current.setNext(newPerson);
    }

    public void set(int index, T element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can't be negative.");
        }

        People<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Head element is null.");
            }
            current = current.getNext();
        }

        if (current != null) {
            current.setPeopleData(element);
        }
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can't be negative.");
        }

        People<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Head element is null.");
            }
            current = current.getNext();
        }

        if (current != null) {
            return current.getPeopleData();
        } else {
            throw new IndexOutOfBoundsException("Current element lost.");
        }
    }

    public boolean remove(T objectToDelete) {
        if (head == null) {
            return false;
        }

        if (head.getPeopleData().equals(objectToDelete)) {
            head = head.getNext();
            return true;
        }

        People<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getPeopleData().equals(objectToDelete)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void clear() {
        head = null;
    }

    public void displayList(PeopleLinkedList list){
        int index = 0;
        People<Student> current = list.head;

        while (current != null) {
            System.out.println(index + ": " + current.getPeopleData().getFirstName());
            current = current.getNext();
            index++;
        }
        System.out.println("\n");
    }

}
