package queue.queue;

import java.util.ArrayList;

public class Queue {
	public static final String queueIsEmpty = "Queue is empty";
	private ArrayList objects = new ArrayList();
	private ArrayList state = new ArrayList <Status> ();

	public Queue() { this.state.add(new Empty()); }
	public boolean isEmpty(){ return getStatus().isEmpty(); }
	private Status getStatus() { return (Status) this.state.get(this.state.size()-1); }

	public Queue add(Object object){
		this.objects.add(object);
		this.state.add(new NotEmpty());
		return this;
	}
	public Object take(){ return getStatus().take(this); }

	public Object head(){ return getStatus().head(this); }
	public Object takeNotEmpty(){
		Object element = this.objects.get(0);
		this.objects.remove(0);
		this.state.remove(this.state.size()-1);
		return element;
	}

	public Object headNotEmpty(){ return this.objects.get(0); }
	public int size(){ return this.objects.size(); }
}