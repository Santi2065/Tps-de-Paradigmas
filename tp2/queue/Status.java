package queue.queue;
public abstract class Status {
    public abstract boolean isEmpty();
    public abstract Object take(Queue queue);
    public abstract Object head(Queue queue);
}