package queue.queue;
public class Empty extends Status {
    public boolean isEmpty() { return true; }
    public Object take(Queue queue) { throw new Error(Queue.queueIsEmpty); }
    public Object head(Queue queue) { throw new Error(Queue.queueIsEmpty); }
}