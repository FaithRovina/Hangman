import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class HangmanGame {
    public static void main(String[] args){

        System.out.println("Welcome to Hangman!");
        //create a list of words to be used for the game
        String[] wordList = {
            "apple", "banana", "chocolate", "computer", "elephant",
            "butterfly", "vacation", "telephone", "library", "sunshine",
            "rainbow", "adventure", "fireworks", "guitar", "mountain",
            "dolphin", "universe", "dragon", "umbrella", "watermelon",
            "icecream", "zookeeper", "jazz", "oxygen", "xylophone",
            "quartz", "vortex", "keyboard", "hangman", "programming",
            "java", "python", "cucumber", "mango", "strawberry",
            "pineapple", "orange", "grape", "lemon", "cherry",
            "waterfall", "landscape", "penguin", "koala", "tiger",
            "lion", "cheetah", "giraffe", "zebra", "kangaroo",
            "octopus", "dinosaur", "helicopter", "rocket", "astronaut",
            "spaceship", "volcano", "earthquake", "whale", "narwhal",
            "october", "november", "december", "february", "april",
            "june", "september", "january", "may", "march",
            "sunday", "wednesday", "friday", "thursday", "tuesday",
            "saturday", "monday", "guitarist", "pianist", "violinist",
            "scientist", "engineer", "artist", "teacher", "student",
            "doctor", "musician", "writer", "athlete", "chef",
            "architect", "photographer", "journalist", "astronomer", "philosopher",
            "detective", "electrician", "mechanic", "gardener", "designer"
        };
        // create an instance of the Scanner class:
        Scanner keyboard= new Scanner(System.in);
        
        boolean continuePlaying = true;
        Random random = new Random();
        
        
        while(continuePlaying){

            //generate a random index within the range of the valid indices
            int randomIndex = random.nextInt(wordList.length);

            // we will use the random index to select an item from the wordList array:
            String randomWord = wordList[randomIndex];

            // get tthe user input:
            System.out.println("Guess the letters in the word below. ");
    
            // we will now display the selected word in asterisk to the user
        
            char[] guessedWord = new char[randomWord.length()];
            for (int i = 0; i < guessedWord.length; i++) {
             guessedWord[i] = '*';
            }

            // to make the game interesting, we will limit the number of attempts but also keep track of all the wrong guesses
            // the attempts are subtracted when one enters a wrong letter
            int attemptsLimit = 10;
            int failedAttempts = 0;
            int successfulAttempts = 0;
            
            //to keep track of wrong letters
            ArrayList<Character> wrongGuesses = new ArrayList<>();



            while (attemptsLimit > 0){
                System.out.print("Word: ");
                for (char c : guessedWord) {
                    System.out.print(c + " ");
                }
                System.out.println("\nAttempts left: " + attemptsLimit);
                System.out.print("Enter a letter: ");
                
                //take user guess and convert it to lower case
                char guess = Character.toLowerCase(keyboard.next().charAt(0));
                

                // checks if the entered letter is in the word and adds it if it exists, otherwise the number of attempst are deducted

                boolean found = false;
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        found = true;
                        successfulAttempts ++;
                    }
                }
                
                if (!found) {
                    System.out.println("Incorrect guess.");
                    attemptsLimit --;
                    failedAttempts ++;
                    wrongGuesses.add(guess);
                    
                    
                }
                System.out.println("The incorrect letters are:" + wrongGuesses);

                // the game ends when all the attempts are used up
                if (attemptsLimit == 0 ) {
                System.out.println("You're out of attempts. The word was: " + randomWord);
                }

                if (String.valueOf(guessedWord).equals(randomWord)) {
                    System.out.println("Congratulations! You guessed the word: " + randomWord);
                    break;
                }
                
            }

            // ensures that any leftover new line characters are consumed
            keyboard.nextLine();

            System.out.println("Your failed attempts are: " + failedAttempts);
            System.out.println("Your successful attempts are: " + failedAttempts);
            System.out.println("Your total attempts are:" + (successfulAttempts+failedAttempts));
            
            System.out.println();
            System.out.println("Do you want to play another round?");
            System.out.println("Enter yes/no:");

            String anotherRound = keyboard.nextLine();

            if(anotherRound.equalsIgnoreCase("yes")){
                continuePlaying = true;
                System.out.println();
            }else{
            continuePlaying = false;
            System.out.println("See you next time!");
            }
        }
        keyboard.close();            
        }
            }

            
            

        
