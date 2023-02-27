import java.util.Scanner;

public class Hangman2 {

	private static final boolean testingMode = true;
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		
		int numberOfPlays = 0;
		
		
		do
		{
			String secretWord = RandomWord.newWord();
			
			System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
		
			
			String difficultyIn = keyboard.next();
			char difficulty = difficultyIn.charAt(0);
			int index;
			String blankWord = "";
		
						
			for (index = 0; secretWord.length() > index; index++)
			{
				blankWord += '-'; 
			}
			
			String duplicate = blankWord; 
			
			if (difficulty == 'e' || difficulty == 'E')
			{
				if (testingMode == true)
				{
					System.out.println("The secret word is: " + secretWord);
				}
				
				System.out.println("The word is: "  + blankWord);
				int attempts;
				
				
				
				for (attempts = 1; attempts > 0; attempts--)	
				{
					System.out.print("Please enter the letter you want to guess: ");
					String guessString = keyboard.next();
					
					char letterGuess = guessString.charAt(0);
					
					if (Character.isDigit(letterGuess))
					{
						System.out.println("Invalid Input - Try Again");
						System.out.println("Guesses remaining: " + attempts);
						attempts++;
						continue;
					}
					else
					{	
						if (guessString.equalsIgnoreCase("solve"))
						{
							System.out.print("Please solve the answer: ");
							String solveGuess = keyboard.next();
						
							if (solveGuess.equalsIgnoreCase(secretWord))
							{
								System.out.println("You Win!");
								System.out.println("You have guessed the word! Congratulations!");
								System.out.println("Would you like to play again? Yes(y) or No(n)");
								char playAgain = keyboard.next().charAt(0);
							
								if (playAgain == 'Y' || playAgain == 'y')
								{
									numberOfPlays++;	
									if (numberOfPlays >= 20)
									{
										System.out.println("You have exceeded the maximum number of rounds - Exiting");
										System.exit(0);
									}
									break;
								}
								else
								{
									System.exit(0);
								}
							
							}
							else
							{
								System.out.println("That is not the secret word.");
								attempts--;
								System.out.println("Guesses remaining: " + attempts);
								attempts++;
								continue;
							}
						
						}
						else
						{	
							System.out.println("Please enter the spaces	you want to check (separated by spaces): ");
							String guessIndex1 = keyboard.next();
							String guessIndex2 = keyboard.next();
							String guessIndex3 = keyboard.next();
							String guessIndex4 = keyboard.next();
					
							int stringIndex;
							boolean isItThere = false;
							
							
					
							char guess1 = guessIndex1.charAt(0);
							char guess2 = guessIndex2.charAt(0);
							char guess3 = guessIndex3.charAt(0);
							char guess4 = guessIndex4.charAt(0);
							
							
							if ((Character.isLetter(guess1))|| (Character.isLetter(guess2)) ||
									(Character.isLetter(guess3)) || (Character.isLetter(guess4)))
							{
								System.out.println("Invalid Input - Try Again");
								System.out.println("Guesses remaining: " + attempts);
								attempts++;
								continue;
							}
						

							else if ((Character.isDigit(guess1)) && (Character.isDigit(guess2) &&
									(Character.isDigit(guess3)) && Character.isDigit(guess4)))							
							{
								int guess1Int = Character.getNumericValue(guess1);
								int guess2Int = Character.getNumericValue(guess2);
								int guess3Int = Character.getNumericValue(guess3);
								int guess4Int = Character.getNumericValue(guess4);
								
								if  ((guess1Int > secretWord.length() - 1) || (guess2Int > secretWord.length() - 1) 
									|| (guess3Int > secretWord.length() - 1) || (guess4Int > secretWord.length() - 1))
								{
									System.out.println("Invalid Input - Try Again");
									System.out.println("Guesses remaining: " + attempts);
									attempts++;
									continue;
								}
								else
								{
									char answer1 = secretWord.charAt(guess1Int);
									char answer2 = secretWord.charAt(guess2Int);
									char answer3 = secretWord.charAt(guess3Int);
									char answer4 = secretWord.charAt(guess4Int);
													
																				
									//Loop for if the letter is there
									for (stringIndex = 0; secretWord.length() > stringIndex; stringIndex++)
									{
										if 	((answer1 == letterGuess) || (answer2 == letterGuess) || 
												(answer3 == letterGuess) || (answer4 == letterGuess))
										{
											isItThere = true;
										}
									}
							
									if (isItThere == true)
									{
										System.out.println("Your letter is in the word!");							
									}
									else
									{
										System.out.println("Your letter was not found in the spaces you provided");
										attempts--;
										System.out.println("Guesses remaining: " + attempts);
										attempts++;
										continue;
									}
							
									int blankIndex;
									blankWord = "";
							
									for (blankIndex = 0; secretWord.length() > blankIndex; blankIndex++)	
									{
										char tempChar = secretWord.charAt(blankIndex);
								
										if (tempChar == letterGuess)
										{
											blankWord += letterGuess;
										}
										else
										{
											blankWord += duplicate.charAt(blankIndex);
										}															
									}	
									duplicate = blankWord;
									if (blankWord.equalsIgnoreCase(secretWord))
									{
										System.out.println("You Win!");
										System.out.println("You have guessed the word! Congratulations!");
										System.out.println("Would you like to play again? Yes(y) or No(n)");
										char playAgain = keyboard.next().charAt(0);
								
										if (playAgain == 'Y' || playAgain == 'y')
										{
											numberOfPlays++;
											
											if (numberOfPlays >= 20)
											{
												System.out.println("You have exceeded the maximum number of rounds - Exiting");
												System.exit(0);
											}											
											break;
										}
										else
										{
											System.exit(0);
										}
									}
									else
									{
										System.out.print("The updated word is: ");
										System.out.println(blankWord);
										System.out.println("Guesses remaining: " + attempts);
										attempts++;
									}
								}
							}	
						}							
					}
				}			
				
		
				
				if (attempts == 0)
				{
					System.out.println("You failed to guess the word :(");
					System.out.println("Would you like to play again? Yes(y) or No(n)");
					char playAgain = keyboard.next().charAt(0);
					
					if (playAgain == 'Y' || playAgain == 'y')
					{
						numberOfPlays++;
						
						if (numberOfPlays >= 20)
						{
							System.out.println("You have exceeded the maximum number of rounds - Exiting");
							System.exit(0);
						}
						continue;
					}
					else
					{
						System.exit(0);
					}
				}
				
			}
			else if (difficulty == 'i' || difficulty == 'I')
			{
				if (testingMode == true)
				{
					System.out.println("The secret word is: " + secretWord);
				}
				
				System.out.println("The word is: "  + blankWord);
				int attempts;
				
				numberOfPlays++;
			}
			else if (difficulty == 'h' || difficulty == 'H')
			{
				if (testingMode == true)
				{
					System.out.println("The secret word is: " + secretWord);
				}
				
				System.out.println("The word is: "  + blankWord);
				int attempts;
				
				numberOfPlays++;
			}
			else
			{
				System.out.println("Plaese enter a valid difficulty");
			}			
		}
		while (numberOfPlays < 20);
		
		keyboard.close();
	}

}
