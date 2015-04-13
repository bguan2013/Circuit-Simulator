import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Comparator;


public class Heap <E extends Comparable<E>> implements PQ<E> {


	int size;
	ArrayList<E> h;
	Comparator<? super E> ordering;
	E tempRoot;


	public Heap(){

		h = new ArrayList<E>();
		size = 0;
		ordering = new NaturalComparator<E>();
		tempRoot = null;

	}

	public Heap(Comparator<? super E> o){

		ordering = o;
		h = new ArrayList<E>();
		size = 0;
		tempRoot = null;
	}


	public void add(E a){

		h.add(a);
		
		this.percolateUp(a, h.size() - 1);
		
		size = h.size();

	}

	//Only goes from the bottom to the top
	public void percolateUp(E up, int updex){

		int indexUp;
		int realIndex = updex; 
		

		if(realIndex == 0){

			return;
		}
		else{

			//On the right-side
			if(realIndex % 2 == 0){

				//priorities are the same
				if(ordering.compare(up, h.get((realIndex - 2) / 2)) == 0){


					return;

				}
				//
				else if(ordering.compare(up, h.get((realIndex - 2) / 2)) > 0){

					return;


				}
				else{

					indexUp = realIndex;
					
					h.set(realIndex, h.get((realIndex - 2) / 2));
					h.set((indexUp - 2) / 2, up);
					this.percolateUp(up, (realIndex-2)/2);
					//CHECK!!!!

				}

			}

			//On the left-side
			else{

				//priorities are the same
				if(ordering.compare(up, h.get((realIndex - 1) / 2)) == 0){


					return;

				}
				//
				else if(ordering.compare(up, h.get((realIndex - 1) / 2)) > 0){

					return;

				}
				//
				else{

					indexUp = realIndex;
					
					h.set(realIndex, h.get((realIndex - 1) / 2));
					h.set((indexUp - 1) / 2, up);
					this.percolateUp(up, (realIndex-1)/2);

				}



			}
		}

	}

	//Only goes from the top to the bottom
	public void percolateDown(E down, int downdex){

		int indexDown;
		int realIndex = downdex;

		if(h.size() == 1){

			return;
		}
		else{

			if((2*realIndex + 1 < (h.size() - 1)) && (2*realIndex + 2 < h.size() )) {


				//Comparing with the LEFT && the RIGHT
				if(ordering.compare(down, h.get(2*realIndex + 1)) == 0 && ordering.compare(down, h.get(2*realIndex + 2)) == 0){

					return;

				}
				else if(ordering.compare(down, h.get(2*realIndex + 1)) == 0 && ordering.compare(down, h.get(2*realIndex + 2)) > 0){

					//replace the right
					indexDown = realIndex;
					h.set(realIndex, h.get(2*realIndex + 2));
					h.set(2*indexDown + 2, down);
					this.percolateDown(down, 2*realIndex + 2);

				}
				else if(ordering.compare(down, h.get(2*realIndex + 1)) == 0 && ordering.compare(down, h.get(2*realIndex + 2)) < 0){

					return;

				}
				else if(ordering.compare(down, h.get(2*realIndex + 1)) > 0 && ordering.compare(down, h.get(2*realIndex + 2)) == 0){

					//replace the left
					indexDown = realIndex;
					h.set(realIndex, h.get(2*realIndex + 1));
					h.set(2*indexDown + 1, down);
					this.percolateDown(down, 2*realIndex + 1);

				}
				else if(ordering.compare(down, h.get(2*realIndex + 1)) > 0 && ordering.compare(down, h.get(2*realIndex + 2)) > 0){

					if(ordering.compare(h.get(2*realIndex + 1), h.get(2*realIndex + 2)) == 0 || ordering.compare(h.get(2*realIndex + 1), h.get(2*realIndex + 2)) < 0){

						//replace the left
						indexDown = realIndex;
						h.set(realIndex, h.get(2*realIndex + 1));
						h.set(2*indexDown + 1, down);

					}
					else{

						//replace the right	
						indexDown = realIndex;
						h.set(realIndex, h.get(2*realIndex + 2));
						h.set(2*indexDown + 2, down);
					}
					this.percolateDown(down, 2*realIndex + 2);
				}
				else if(ordering.compare(down, h.get(2*realIndex + 1)) > 0 && ordering.compare(down, h.get(2*realIndex + 2)) < 0){

					//replace left
					indexDown = realIndex;
					h.set(realIndex, h.get(2*realIndex + 1));
					h.set(2*indexDown + 1, down);
					this.percolateDown(down, 2*realIndex + 1);
				}
				else if(ordering.compare(down, h.get(2*realIndex + 1)) < 0 && ordering.compare(down, h.get(2*realIndex + 2)) == 0){

					return;

				}
				else if(ordering.compare(down, h.get(2*realIndex + 1)) < 0 && ordering.compare(down, h.get(2*realIndex + 2)) > 0){

					//replace right
					indexDown = realIndex;
					h.set(realIndex, h.get(2*realIndex + 2));
					h.set(2*indexDown + 2, down);
					this.percolateDown(down, 2*realIndex + 2);
				}

				else if(ordering.compare(down, h.get(2*realIndex + 1)) < 0 && ordering.compare(down, h.get(2*realIndex + 2)) < 0){

					return;

				}
				else{

					return;
				}
			}

			//Only has the left leaf
			else if((2*realIndex + 1 < h.size()) && 2*realIndex + 2 == h.size()){


				if(ordering.compare(down, h.get(2*realIndex + 1)) < 0 || ordering.compare(down, h.get(2*realIndex + 1)) == 0){

					return;

				}
				else{

					indexDown = realIndex;
					h.set(realIndex, h.get(2*realIndex + 1));
					h.set(2*indexDown + 1, down);

				}

			}

			//(h.get((realIndex + 1)*2) == null && h.get((realIndex + 2)*2) == null)
			//Has nothing
			else{

				return;

			}
		}

	}
	
	//Only removes the root due to a PQ "tree"
	public void remove(){

		h.set(0, h.get(h.size() - 1));
		h.remove(h.size() - 1);
		size = h.size();
		if(!h.isEmpty())
		this.percolateDown(h.get(0), 0);
		
	


	}
	public E peek(){

		if(this.isEmpty()){
			return null;
		}
		else{
		tempRoot = h.get(0);	
		return tempRoot;
		}
	}
	public E poll(){



		if(this.isEmpty()){
			return null;
		}
		else{
			tempRoot = h.get(0);
			this.remove();		
			return tempRoot;

		}


	}
	public int sizeOf(){

		return size;

	}
	public void clear(){

		size = 0;
		h = new ArrayList<E>();
	}

	public boolean isEmpty(){

		if(size == 0){
			return true;
		}
		else{
			return false;
		}

	}
	public void printHeap(){

		if(!this.isEmpty()){
		for(int i = 0; i < h.size(); i++){

				System.out.println(h.get(i));

			}
		}
		else{

			System.out.println("Heap is empty, can't print out elements.");

		}



	}

}