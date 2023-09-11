package queue.queue;
public class NotEmpty extends Status {

    public Object object;
    public NotEmpty(Object object) {    this.object = object; }

    public Object getObject() { return this.object; }
    public boolean isEmpty() { return false; }
    public Object take(Queue queue) { return queue.takeNotEmpty(); }
    public Object head(Queue queue) { return queue.headNotEmpty(); }
}