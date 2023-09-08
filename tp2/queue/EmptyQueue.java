package queue.queue;

public class EmptyQueue extends Queue {
    public EmptyQueue() {
        this.tail = this;
        this.state = this;
        this.tail.tailState = this;
    }
    public boolean isEmpty() {
        return true;
    }

    public Queue add(Object object) {
        return new NotEmptyQueue(object, this);
    }

    public Object take() {
        throw new Error(Queue.queueIsEmpty);
    }

    public Object head() {
        throw new Error(Queue.queueIsEmpty);
    }

    public int size() {
        return 0;
    }
}
