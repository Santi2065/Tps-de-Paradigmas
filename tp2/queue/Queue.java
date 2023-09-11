package queue.queue;

import java.util.ArrayList;

public class Queue {
	public static final String queueIsEmpty = "Queue is empty";

	private ArrayList queue = new ArrayList();
	private ArrayList estado = new ArrayList <AbstractQueue> ();
	private int size;

	public Queue() {
		this.estado.add(new EmptyQueue());
		this.size = 0;
	}
	public boolean isEmpty(){
		AbstractQueue element = (AbstractQueue) this.estado.get(this.size);
		return element.isEmpty();
	}
	public Queue add(Object object){
		this.queue.add(object);
		this.estado.add(new NotEmptyQueue());
		this.size++;
		return this;
	}
	public Object take(){
		AbstractQueue element = (AbstractQueue) this.estado.get(this.size);
		return element.take(this);
	}

	public Object head(){
		AbstractQueue element = (AbstractQueue) this.estado.get(this.size);
		return element.head(this);
	}

	public Object takeNotEmpty(){
		Object element = this.queue.get(0);
		this.queue.remove(0);
		this.estado.remove(this.size);
		this.size--;
		return element;
	}

	public Object headNotEmpty(){
		Object element = this.queue.get(0);
		return element;
	}
	public int size(){
		return this.size;
	}
}