package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String guess = "";
        int counter = 0;
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String[] hang = {"tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream"};
        boolean stillPlaying = true;

        while (stillPlaying) {
            System.out.println("Welcome to the game of Hangman!");
            char[] randomGuess = hang[rand.nextInt(hang.length)].toCharArray();//breaks down the words in array into single characters
            System.out.println("Word below");//To me to know the random word selected
            System.out.println(randomGuess);
            int numberOfGuesses = randomGuess.length; //How many times I want the player to guess the word
            char[] playerGuess = new char[numberOfGuesses];//creats an empty char array to save the user's input


            for (int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';// sets each field to an _
            }
            boolean correctGuess = false;

            while (!correctGuess && counter != numberOfGuesses) {//while the word isn't guessed, and player has not exceed the amount of tries(counter)
                System.out.print("Current guess: ");
                arrayPrint(playerGuess);//prints out current guess
                System.out.printf("You have %d tries left: ", numberOfGuesses - counter);
                System.out.println("Enter a single character or press q to quit");
                char kboard = input.nextLine().charAt(0);//app will only take the first character(index 0) of the user input
                counter++;

                if (kboard == 'q') {//if the user types q, game is over
                    stillPlaying = false;
                    correctGuess = true;

                } else {
                    for (int i = 0; i < randomGuess.length; i++) {
                        if (randomGuess[i] == kboard) {//if random word to guess is equal to input
                            playerGuess[i] = kboard;//replace the enmpty _ with the guessed letter
                        }
                    }

                    {
                        if (wordIsGuessed(playerGuess)) {
                            correctGuess = true;
                            System.out.println("Congrats! You guessed right!");
                        }
                    }
                }
            }
            System.out.println("Game Over");
        }
    }

    public static void arrayPrint(char[] array) {//method that will take char array and print it out
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean wordIsGuessed(char[] array) {//returns a t/f statement and begin a character array
        for (int k = 0; k < array.length; k++) {
            if (array[k] == '_') //we know the word is guessed when there are no underscores left in the array.
                return false;// If there is an underscore, that means the word is not guessed right
        }
        return true;//else, if there is no underscore left, guessed word is right
    }

}