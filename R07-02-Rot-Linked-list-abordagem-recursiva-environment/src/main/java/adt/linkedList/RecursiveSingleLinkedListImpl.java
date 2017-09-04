package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		else {
			if (this.next == null) {
				return 1;
			}
			else {
				return 1 + this.next.size(); // soma a quantidade de valores atraves da recursao
			}
		}
	}

	@Override
	public T search(T element) {
		if (isEmpty() || element == null) {
			return null;
		}
		else {
			if (this.data.equals(element)) { // se o valor for o procurado, retorna o valor
				return this.data;
			}
			if (this.next != null) {
				return this.next.search(element); // se o valor nao for o procurado, manda o proximo procurar o valor
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (this.data == null) {
			this.data = element;
		}
		else {
			if (this.next == null) {
				this.next = new RecursiveSingleLinkedListImpl<T>(element, null); // se o proximo for null, adiciona no proximo
			}
			else {
				this.next.insert(element); // se o proximo nao for null, manda o proximo adicionar o novo valor
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() || element != null) {
			if(this.data.equals(element)) { // se o valor foi encontrado, a recursao atualiza os valores
				if (this.next != null) {
					this.setData(this.next.getData());
					this.setNext(this.next.getNext());
				}
				else {
					this.setData(null); // se o proximo for null, o valor do atual passa a ser null
				}
			}
			else {
				this.next.remove(element); // se o valor nao foi encontrado, manda o proximo remover
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		
		if (!isEmpty()) {
			auxToArray(array, 0);
		}
		return array;
	}
	
	private void auxToArray(T[] array, int indiceArray) {
		
		if (this.next != null) { // verifica se o proximo nó pode receber um valor
			array[indiceArray] = this.data;
			indiceArray++;
			this.next.auxToArray(array, indiceArray);
		}
		else {
			if (this.data != null) { // muda o valor do no atual
				array[indiceArray] = this.data;
			}
		}


	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
