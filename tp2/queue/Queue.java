package queue.queue;

public abstract class Queue {
	public Object head;
	public Queue tail;
	public int size;
	public static final String queueIsEmpty = "Queue is empty";

	public abstract boolean isEmpty();
	public abstract Queue add(Object object);
	public abstract Object take();
	public abstract Object head();
	public abstract int size();
}