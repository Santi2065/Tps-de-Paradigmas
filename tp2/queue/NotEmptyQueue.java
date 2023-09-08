package queue.queue;
public class NotEmptyQueue extends Queue{
    public NotEmptyQueue(Object head, Queue tail) {
        this.head = head;
        this.tail = tail;
        this.size = tail.size() + 1;
    }
    public boolean isEmpty() {
        return false;
    }
    public NotEmptyQueue add(Object object) {
        return new NotEmptyQueue(object, this);
    }
    //take() makes the queue, the tail
    public Object take() {
        this.tail = this.tail.tail;
        this.size--;
        return this.head;
    }
    public Object head() {
        return this.head;
    }
    public int size() {
        return this.size;
    }
}
