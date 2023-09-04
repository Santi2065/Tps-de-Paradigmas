package queue.queue;

import java.util.ArrayList;
public class Queue {
	private ArrayList<Object> queue = new ArrayList<>();
  public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	public Queue add(Object object) {
		this.queue.add(object);
		return this;
	}

	public Object take() {
	  try {
		  Object toBeDeletedValue = this.queue.get(0);
		  this.queue.remove(0);
		  return toBeDeletedValue;
	  }catch (RuntimeException e) {
			  throw new Error("Queue is empty");
	  }}

	public Object head(){
	  try{
    return this.queue.get(0);
	}catch (RuntimeException e) {
		throw new Error("Queue is empty");
	}}

	public int size() {
		return this.queue.size();
	}
}
