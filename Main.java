import java.util.Scanner;


public class Main {

	


	public static void main(String [] args) {

		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		Scanner in4 = new Scanner(System.in);
		Scanner in5 = new Scanner(System.in);

		String input;
		int a;
		int b;

		int exit = 1;

		

		while(exit != 0){

		System.out.println("Please enter a kind of circuit you want to test: ");

		input = in.nextLine();	

		if(input.equalsIgnoreCase("SR")){

			System.out.println("Please enter the first input for the S input(assuming Q is initialized to 1): ");
			a = in1.nextInt();
			System.out.println("Please enter the second input for the R input(assuming Q is initialized to 1): ");
			b = in2.nextInt();


			if((a == 0 || a == 1)&&(b == 0 || b == 1)) {
				//SR filp flop
				if(a ==1 && b == 1){
					System.out.println("Input of S and R cannot be both 1s! Returning to main menu......");
				}
				else{	

					int exit2 = -1;
					CircuitSR sr = new CircuitSR();

					while(exit2 == -1){

						

						sr.simulate(a,b);

						System.out.println("Do you want to set to another state?(Please enter yes or anything else)");
						String input0 = in5.nextLine();

						
						if(input0.equalsIgnoreCase("yes")){
							System.out.println("Please enter another input for S: ");
							a = in3.nextInt();
							System.out.println("Please enter another input for R: ");
							b = in4.nextInt();
							if((a != 0 && a != 1) || (b != 0 && b != 1)){
								
								
									System.out.println("Not correct inputs. Returning to main menu......");
									exit2 = 0; 
								

							}
							else if((a == 1)&&(b == 1)){

								System.out.println("Not correct inputs. Returning to main menu......");
									exit2 = 0;
								
							}
						}
						
						else{
							exit2 = 0; 
						}

					}
				}
			}
			else{

				System.out.println("Your inputs should be either 0 or 1, returning to main menu......");

			}
		}

		else if(input.equalsIgnoreCase("Sequential")){

			System.out.println("Please enter the input for the sequential circuit not gate with another not gate: ");
			a = in1.nextInt();
			


			if(a == 0 || a == 1){
				//SR filp flop	
				CircuitSeq dff = new CircuitSeq(a);
			}
			else{

				System.out.println("Your inputs should be either 0 or 1, returning to main menu......");

			}
		}

		else if(input.equalsIgnoreCase("not")){


			System.out.println("Please enter an input for the NOT gate: ");
			a = in1.nextInt();
			
					

					if(a == 0 || a == 1){

					//For a not gate
					CircuitNot not = new CircuitNot(a);

					}
					else{

						System.out.println("Your input should be either 0 or 1, returning to main menu......");

					}
			
			

		}

		else if(input.equalsIgnoreCase("or")){


			System.out.println("Please enter the first input for the OR gate: ");
			a = in1.nextInt();
			System.out.println("Please enter the second input for the OR gate: ");
			b = in2.nextInt();

			
					

					if((a == 0 || a == 1)&&(b == 0 || b == 1)){

						//For a or gate
						CircuitOr or = new CircuitOr(a,b);
					

					}
					else{

						System.out.println("Your inputs should be either 0 or 1, returning to main menu......");

					}

			
			

		
		}

		else if(input.equalsIgnoreCase("and")){

			System.out.println("Please enter the first input for the AND gate: ");
			a = in1.nextInt();
			System.out.println("Please enter the second input for the AND gate: ");
			b = in2.nextInt();

			if((a == 0 || a == 1)&&(b == 0 || b == 1)){
				//For an and gate
				CircuitAnd and = new CircuitAnd(a,b);
			}
			else{

				System.out.println("Your inputs should be either 0 or 1, returning to main menu......");

			}
		}

		else if(input.equalsIgnoreCase("nand")){

			System.out.println("Please enter the first input for the NAND gate: ");
			a = in1.nextInt();
			System.out.println("Please enter the second input for the NAND gate: ");
			b = in2.nextInt();

			if((a == 0 || a == 1)&&(b == 0 || b == 1)){
				//For a nand gate
				CircuitNand nand = new CircuitNand(a,b);
			}
			else{

				System.out.println("Your inputs should be either 0 or 1, returning to main menu......");

			}
		}

		else if(input.equalsIgnoreCase("nor")){

			System.out.println("Please enter the first input for the NOR gate: ");
			a = in1.nextInt();
			System.out.println("Please enter the second input for the NOR gate: ");
			b = in2.nextInt();

			if((a == 0 || a == 1)&&(b == 0 || b == 1)){
				//For a nor gate
				CircuitNor nor = new CircuitNor(a,b);
			}
			else{

				System.out.println("Your inputs should be either 0 or 1, returning to main menu......");

			}
		}

		else if(input.equalsIgnoreCase("special")){

			System.out.println("Please enter the first input for the SPECIALLY DESIGNED gate: ");
			a = in1.nextInt();
			

			if((a == 0 || a == 1)){
				//For the not & and gate test
				CircuitSpecial s = new CircuitSpecial(a); 
			}

			else{

				System.out.println("Your inputs should be either 0 or 1, returning to main menu......");

			}

		}

		else if(input.equalsIgnoreCase("exit")){

			exit = 0;

		}

		else{

			System.out.println("Please enter a correct command! (Ex: SR, sequential, not, or, and, nand, nor, special or exit.)");
		}


	}

	System.out.println("Thanks for using my simulator!");

    }
}