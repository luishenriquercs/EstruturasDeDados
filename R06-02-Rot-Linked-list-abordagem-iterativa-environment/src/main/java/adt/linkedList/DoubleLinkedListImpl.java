package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		setLast(new DoubleLinkedListNode<>());
	}
	
	@Override
	public void insertFirst(T element) {
		if(element != null){
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			if(this.isEmpty()){
				this.head = node;
				this.last = node;
			}else{
				node.next = this.head;
				((DoubleLinkedListNode<T>) head).previous = node;
				this.head = node;
			}
			this.size++;
		}
	}

	@Override
	public void insert(T element) {
		if(element != null){
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			if(isEmpty()){
				this.head = node;
			}else{
				node.previous = last;
				last.next = node;
			}
			last = node;
			this.size++;
		}
	}
	
	@Override
	public T search(T element) {
		T result = null;
		if(element != null  && !isEmpty()){
			DoubleLinkedListNode<T> nodeAux = (DoubleLinkedListNode<T>) this.head;
			while(!nodeAux.isNIL()){
				if(nodeAux.getData().equals(element)){
					result = nodeAux.getData();
					break;
				}
				nodeAux = (DoubleLinkedListNode<T>) nodeAux.getNext();
			}
		}
		return result; 
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			this.head = this.head.next;
			((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<>();
			if(this.head == null){
				head.next = new DoubleLinkedListNode<>();
				last = (DoubleLinkedListNode<T>) this.head;
			}
			this.size--;
		}
	}
	
	@Override
	public void remove(T element) {
		if(element != null && !isEmpty()){
			if(this.head.getData().equals(element)){
				removeFirst();
			}
			else if (this.last.getData().equals(element)){
				removeLast();
			}
			else{
				DoubleLinkedListNode<T> nodeAux = (DoubleLinkedListNode<T>) this.head;
				
				while(!nodeAux.isNIL() && !nodeAux.getData().equals(element)){
					nodeAux = (DoubleLinkedListNode<T>) nodeAux.getNext();
				}
				if(!nodeAux.isNIL()){
					nodeAux.previous.next = nodeAux.getNext();
					((DoubleLinkedListNode<T>) nodeAux.next).previous =  nodeAux.previous;
				}
				this.size--;
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			this.last = this.last.previous;
			this.last.next = new DoubleLinkedListNode<>();
			if(this.last.previous == null || this.last.previous.isNIL()){
				this.last.previous = new DoubleLinkedListNode<>();
				this.head = last;
			}
			this.size--;
		}
	}
	
	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = this.head;
		
	    for (int i = 0; i < array.length; i++) {
	    	array[i] = aux.getData();
	        aux = aux.next;
	    }
	    return array;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public DoubleLinkedListNode<T> getLast() {
		return this.last;
	}
	
	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}