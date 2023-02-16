
package NB81;

public class ArrayQueueFixed<E>{
	private int front, rear, size, maxSize;
	private E[] data;

	public ArrayQueueFixed(int initialSize){
		size = 0;
		front = 0;
		maxSize = initialSize;
		rear = maxSize - 1;
		data = (E[]) new Object[maxSize];
	}

	public boolean offer(E element){
		if(size==maxSize)
			reallocate();
		rear = (rear + 1) % maxSize;
		data[rear] = element;
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
			front = (front + 1) % maxSize;
			return element;
		}	
	}

	@SuppressWarnings("unchecked")
	private void reallocate() {
		int newMax = 2 * maxSize;
		E[] newData = (E[]) new Object[newMax];
		int j = front;
		for (int i = 0; i < size; i++) {
			newData[i] = data[j];
			j = (j + 1) % maxSize;
		}
		front = 0;
		rear = size - 1;
		maxSize = newMax;
		data = newData;
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