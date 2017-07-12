package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

   protected SingleLinkedListNode<T> head;
   protected int size;

   public SingleLinkedListImpl() {
      this.head = new SingleLinkedListNode<T>();
      this.size = 0;
   }

   @Override
   public boolean isEmpty() {
      return this.size == 0;
   }

   @Override
   public int size() {
      return this.size;
   }

   @Override
   public T search(T element) {

      SingleLinkedListNode<T> aux = head;

      while (!aux.isNIL() && !aux.data.equals(element)) {
         aux = aux.next;
      }

      return aux.data;

   }

   @Override
   public void insert(T element) {

      SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());

      if (isEmpty()) {
         this.head = newNode;
      } else {
         SingleLinkedListNode<T> aux = this.head;

         while (!aux.next.isNIL()) {
            aux = aux.next;
         }
         aux.next = newNode;
      }
      this.size++;
   }

   @Override
   public void remove(T element) {

      if (!isEmpty()) {

         if (this.head.data.equals(element)) {
            this.head = this.head.next;
            this.size--;
         } else {
            SingleLinkedListNode<T> prev = null;
            SingleLinkedListNode<T> aux = this.head;

            while (!aux.isNIL() && !aux.data.equals(element)) {
               prev = aux;
               aux = aux.next;
            }

            prev.next = aux.next;
            this.size--;
         }
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

   public SingleLinkedListNode<T> getHead() {
      return head;
   }

   public void setHead(SingleLinkedListNode<T> head) {
      this.head = head;
   }

}
