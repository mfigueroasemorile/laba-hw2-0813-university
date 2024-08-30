package generic;

public class People<T>{
    private T peopleData;
    private People<T> next;

    public T getPeopleData() {
        return peopleData;
    }

    public void setPeopleData(T peopleData) {
        this.peopleData = peopleData;
    }

    public People<T> getNext() {
        return next;
    }

    public void setNext(People<T> next) {
        this.next = next;
    }

    People(T d) {
        this.peopleData = d ;
        this.next = null;
    }

}
