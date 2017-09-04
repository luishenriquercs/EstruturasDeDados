package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;
	private int size;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
		this.size = size;
	}

	@Override
	public T top() {
		
		if(isEmpty()) {
			throw new RuntimeException("Is empty");
		}
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return (this.top == -1);
	}

	@Override
	public boolean isFull() {
		return ((this.top + 1) == this.size);
	}

	@Override
	public void push(T element) throws StackOverflowException {
		
		if (isFull()) {
			throw new StackOverflowException();
		}
		
		if (isEmpty()) {
			top++;
			array[top] = element;
		}
		else {
			top++;
			array[top] = element; // adiciona o elemento na ultima posicao
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		
		T element = array[top];
		
		top--; // o topo passa a ser o elemento anterior
		
		return element;
	}

}
