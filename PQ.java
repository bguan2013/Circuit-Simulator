



public interface PQ<E> {


	void add(E a);
	void percolateUp(E up, int realIndex);
	void percolateDown(E down, int realIndex2);
	void remove();

	//Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	E peek();

	//Retrieves and removes the head of this queue, or returns null if this queue is empty.
	E poll();

	int sizeOf();
	void clear();
	boolean isEmpty();


}