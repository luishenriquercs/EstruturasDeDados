package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int size;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
		this.size = size;
	}

	@Override
	public T head() { // o head sempre será o elemento de indice 0
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) == this.size);
	}

	private void shiftLeft() { // coloca cada elemento para uma casa anterior
		
		if (isEmpty()) {
			throw new RuntimeException("Is empty");
		}
		
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		if (isFull()) {
			throw new QueueOverflowException();
		}
		
		if (isEmpty()) {
			this.tail = 0;
			array[tail] = element;
		}
		else {
			this.tail++;
			array[tail] = element; // adiciona o elemento na ultima posicao
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T element = array[0];
		
		if (this.tail == 0) { // se o array tiver apenas um elemento, tail volta ao estado inicial
			this.tail = -1;
		}
		else { 
			shiftLeft(); // reajuste nas posicoes dos elementos
		}
		
		return element;
	}

}
