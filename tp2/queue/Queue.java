package queue;

import java.util.ArrayList;

public class Queue {
	public static final String queueIsEmpty = "Queue is empty";
	private final ArrayList queue = new ArrayList <Status> ();
	public Queue() { this.queue.add(new Empty()); }
	public boolean isEmpty(){ return getStatus(this.queue.size()-1).isEmpty(); }
	private Status getStatus(int number) { return (Status) this.queue.get(number); }
	public Queue add(Object object){
		this.queue.add(new NotEmpty(object));
		return this;
	}
	public Object take(){ return getStatus(this.queue.size()-1).take(this); }
	public Object head(){ return getStatus(this.queue.size()-1).head(this); }
	public Object takeNotEmpty(){
		Object element = getStatus(1).getObject();
		this.queue.remove(1);
		return element;
	}
	public Object headNotEmpty(){ return getStatus(1).getObject(); }
	public int size(){ return this.queue.size()-1; }
}