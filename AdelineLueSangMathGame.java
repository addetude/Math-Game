import arc.*;

public class AdelineLueSangMathGame{
	public static void main(String[] args){
		Console con = new Console();
		
		//declare variables
		String strStart;
		String strResponse;
		int intnum1;
		int intnum2;
		int intnum;
		int intCounter;
		int intCount;
		int intOppor;
		int intAns;
		int intResponse;
		int intScore;
		int intTotalScore;
		double dblPrecent;
		int intlvl;
		
		//let these variables equal 0 until redefined in the loop
		intnum = 0;
		intScore = 0;
		intTotalScore = 0;
		
		//introduction + intstructions
		con.println("Welcome to Addi’s Math Training Game! ");
		con.println("");
		con.println("-------------------------------------------------------------------------------------------------------------");
		con.println("");
		con.println("     This game will generate random addition and subtraction equations."); 
		con.println("  The object of a game is to answer as many questions correctly as possible.");
		con.println("   Every 16 questions, the questions will increase in difficulty by making");
		con.println("    the minimum and maximum value the numbers can be generated as higher. ");
		con.println("");
		con.println("   For a hint, type '-101', but please note any questions requiring a hint");
		con.println("       can not count as correct, however can be counted as incorrect.");
		con.println("");
		con.println("			       Good luck :) ");
		con.println("");
		con.println("-------------------------------------------------------------------------------------------------------------- ");
		con.println("");
		
		con.println("Type start to begin: ");
		strStart = con.readLine () ;
		con.println("");
		
		//if statment uses the string 'start' to initialize the game
		if(strStart.equalsIgnoreCase("start")){
			
			//game will run for 10 rounds of 16 questions
			//loop is used to increase difficulty each round
			for(intCounter = 1; intCounter <= 10; intCounter++){
				
				//intlvl makes the range Math.random can generate from
					//based on intCounter variable
				intlvl = (int) (Math.pow(10, intCounter - 1));
				
				//tell user the max and min values that can be generated
				con.println("LEVEL "+intCounter);
				con.println("");
				con.println("Max value: "+intlvl*10);
				con.println("Min value: "+intlvl);
				con.println("");
				
				//loops 16 times for each question (same difficulty)
				for(intCount = 1; intCount <= 16; intCount++){
					
						//generates a random number within its range
							//range dependant on intlvl
						intnum2 = (int)(Math.random()*((10*intlvl)-intlvl))+intlvl;
						
						//intnum1 must be equal or less than intnum2 (set minimum to intnum2)
							//subtraction equations will never be negative
						intnum1 = (int)(Math.random()*((10*intlvl)-intnum2))+intnum2;
					
					//Use numbers to represent +/- in Math.Random
						//1 = +; 0 = -
					intOppor = (int)(Math.random()*(2-0))+0;
					if (intOppor == 1){
						intAns = intnum1 + intnum2;
						con.println(intnum1+" + "+intnum2);
						intResponse = con.readInt () ;
						
						//use if statments to dictate response
							//correct answer will have different response than incorrect
							//hint (-101) will tell the user whether it is more or less than a reference number
						if(intResponse == -101){
							if(intAns >= intlvl*10){
								con.println("");
								con.println("The answer is more than or equal to "+intlvl*10);
							}else{
								con.println("");
								con.println("The answer is less than "+intlvl*10);
							}
							
							//same incorrect/correct (else if and else) steps will be inserted into this if statment
								//this is so the user knows if they are correct or not
								//Also, if they are incorrect, one will be added to intTotalScore
								
								//intResponse is users guess after the hint
							intResponse = con.readInt () ;
						
							if(intResponse == intAns){
								con.println("");
								con.println("Correct");
								//user does not get +1 intScore for correct
							}else{
								con.println("");
								con.println("Incorrect");
								con.println("Correct Answer: "+intAns);
								con.println("");
								//user can get incorrect by adding one to the intTotalScore
								intTotalScore = intTotalScore + 1;
							}
	
						}else if(intResponse == intAns){
							con.println("");
							con.println("Correct");
							
							//One will be added to intScore for correct answers
							//One will be added to intTotalScore regardless
								//(Counts total questions asked)
							intScore = intScore + 1;
							intTotalScore = intTotalScore + 1;
						}else{
							con.println("");
							con.println("Incorrect");
							con.println("Correct Answer: "+intAns);
							con.println("");
							intScore = intScore;
							intTotalScore = intTotalScore + 1;
						}
	
					//repeat steps for subtraction
					}else{
							
						intAns = intnum1 - intnum2;
						con.println(intnum1+" - "+intnum2);
						intResponse = con.readInt () ;
						con.println("");
						
						//reference number is reduced to make hint more useful in subtraction
						if(intResponse == -101){
							if(intAns >= intlvl*5){
								con.println("");
								con.println("The answer is more than or equal to "+intlvl*5);
							}else{
								con.println("");
								con.println("The answer is less than "+intlvl*5);
							}
							intResponse = con.readInt () ;
							
							if(intResponse == intAns){
								con.println("");
								con.println("Correct");
							}else{
							con.println("");
							con.println("Incorrect");
							con.println("Correct Answer: "+intAns);
							con.println("");
							intTotalScore = intTotalScore + 1;
							}
					
						}else if(intResponse == intAns){
							con.println("");
							con.println("Correct");
							intScore = intScore + 1;
							intTotalScore = intTotalScore + 1;
						}else{
							con.println("");
							con.println("Incorrect");
							con.println("Correct Answer: "+intAns);
							con.println("");
							intTotalScore = intTotalScore + 1;
							}
					}
					//Printed at the end of each question
						//Calculate precentage based on intScore and intTotalScore
					dblPrecent = intScore*100.0/intTotalScore;
						//Round precentage to one decimal place
					dblPrecent = Math.round(dblPrecent*(Math.pow(10.0,1)))/(Math.pow(10.0, 1));
					con.println("Score: "+intScore+"/"+intTotalScore+" | "+dblPrecent+"%");					
					con.println("----------------------------------------------------------------------------------------");
					con.println("");
					con.sleep(100);
					}
				
					
					//will print after each round (16 questions)
					con.println("Time for a little more difficulty...");
					
					}
						
			
			
		}
		}
	}
		
		
		


