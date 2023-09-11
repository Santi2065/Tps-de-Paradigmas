package queue.queue;
public class NotEmpty extends Status {
    public boolean isEmpty() { return false; }
    public Object take(Queue queue) { return queue.takeNotEmpty(); }
    public Object head(Queue queue) { return queue.headNotEmpty(); }
}