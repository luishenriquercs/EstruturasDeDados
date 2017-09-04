package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;
	private int size;

	public CircularQueue(int size) {
		this.array = (T[]) new Object[size];
		this.head = -1;
		this.tail = -1;
		this.elements = 0;
		this.size = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		if (isFull()) {
			throw new QueueOverflowException();
		}
		
		if(isEmpty()) { // se o array estiver vazio, head e tail representam o primeiro elemento
			this.head = 0;
			this.tail = 0;
			array[tail] = element;
			elements++;
		}
		else {
			tail = (this.tail + 1) % this.size; // o ultimo elemento passa a ser o adicionado
			array[tail] = element;
			elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T elemento = array[head];
		
		if (elements == 1) { // se o array tiver apenas um elemento, head e tail voltam ao estado inicial
			this.head = -1;
			this.tail = -1;
			elements--;
		}
		else {
			this.head = ((this.head + 1) % this.size); // o proximo elemento passa a ser o primeiro elemento
			elements--;
		}
		
		return elemento;
	}

	@Override
	public T head() {
		
		if (isEmpty()) {
			throw new RuntimeException("Is empty");
		}
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		return (this.head == -1 && this.tail == -1);
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.size == this.head);
	}

}
