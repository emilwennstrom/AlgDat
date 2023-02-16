
package NB81;

import java.util.Arrays;

public class ArrayQueue<E>{
	private int front, rear, size, maxSize;
	private E[] data;

	public ArrayQueue(int initialSize){
		size = 0;
		front = 0;
		maxSize = initialSize;
		rear = 0;
		data = (E[]) new Object[maxSize];
	}

	public boolean offer(E element){
		if(size==maxSize)
			reallocate();
		data[rear] = element;
        rear = rear+1%maxSize;
		size++;
		return true;
	}

	public E peek(){
		if(size==0) return null;
		return data[front];
	}

	public E poll(){
		if(size==0){
			return null;
		}else{
			size--;
			E element = data[front];
			front =front+1%maxSize;
			return element;
		}	
	}

	private void reallocate() {
		maxSize*=2;
		data= Arrays.copyOf(data,maxSize);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		for (E element : data) {
			builder.append("Index: ").append(i);
			builder.append(" [").append(element).append("] ");
			i++;
			if (i % 10 == 0) {
				builder.append("\n");
			}
		}
		builder.append("\nMaxSize: ").append(maxSize).append(", Actual Size: ").append(size);
		builder.append("\nFront: ").append(front).append(", Rear: ").append(rear).append("\n");

		return builder.toString();
	}



}