import java.util.Scanner;
import java.lang.Integer;
import java.util.Random;

public class testHeap {
	
	




		/*public void test1(){
		//Test 1 for adding one root
		
		

		for(int i = 0, i < h.h.size(), i++){
		System.out.println(h.h.get(i).toString());
		}
		System.out.println(h.poll().toString());
		}
		public void test2(){
		//Test 2 for adding many elements


		}	
		public void test3(){
		//Test 3 for poll() with only the root

		}
		public void test4(){
		//Test 4 for poll() with a left leaf at the bottom
		}
		public void test5(){	
		//test 5 for poll() with a right leaf at the bottom
		}
*/
		
		public static void main(String args[]){

			Random rand = new Random();

			int  n; 
			
			int exit = -1;
			Heap<Integer> heap  = new Heap<Integer>();	
			Scanner test = new Scanner(System.in);
			
			while(exit == -1){
				
						
				System.out.println("Please enter a test command(add, poll, size, clear, exit): "); 
				String s = test.nextLine();


			if(s.equalsIgnoreCase("add")){

				System.out.println("Please enter a number to test or type -1 to let us generate a random number(from 0 to 99): ");
				Scanner test2 = new Scanner(System.in);
				int number = test2.nextInt();

				if(number == -1){

					n = rand.nextInt();
				}
				else{

					n = number;
				}
				heap.add(n);
				heap.printHeap();

			}
			else if(s.equalsIgnoreCase("poll")){

				heap.poll();
				heap.printHeap();
			}	
			else if(s.equalsIgnoreCase("size")){

				System.out.println("The size of the heap is " + heap.sizeOf() + ".");

			}
			else if(s.equalsIgnoreCase("exit")){

				exit = 0;

				System.out.println("Thanks for testing!");
				

			}
			else if(s.equalsIgnoreCase("clear")){

				heap.clear();
				System.out.println("Heap has been cleared.");
				heap.printHeap();
			}
			else{

				System.out.println("Please enter a correct command!");

			}
			
			

		}



	}

}