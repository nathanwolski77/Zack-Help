package cecs274;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//import org.graalvm.compiler.word.Word;

//import jdk.internal.jshell.tool.StopDetectingInputStream;

/**
 * TODO: Description of class, in this case since it has main(), a description
 * of the program.
 * 
 * @author FirstName LastName Email
 * @author FirstName LastName Email
 */
public class DebateWordCloud {

   // TODO: Declare constants, instance or class variables
   private static ArrayList<String> stopWords;
   private static String speaker;

   // TODO: define main()
   public static void main(String[] args) throws FileNotFoundException {
      
      speaker = args[1];
      File stopWordsFile = new File(args[2]);
      stopWords = new ArrayList<String>();
      stopWords = getStopWords(stopWordsFile);
      File debateFile = new File(args[0]);
      readDebateFile(debateFile, speaker, stopWords);
      
   }

   // TODO: define at least three other methods
   public static ArrayList<String> getStopWords(File file) throws FileNotFoundException{
      ArrayList<String> stopWordsList = new ArrayList<String>();
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
         String line = scanner.nextLine();
         stopWordsList.add(line);
      }
      scanner.close();
      return stopWordsList;
   }

   public static void readDebateFile(File file, String speaker, ArrayList<String> list) throws FileNotFoundException {
      /*
         
      */
      ArrayList<WordFrequency> frequentWordList = new ArrayList<WordFrequency>();
      Scanner scanner = new Scanner(file);
      Boolean trackWords = false;
      String editedLine = "";
      while(scanner.hasNextLine()) {
         String line = scanner.nextLine();
         // Need to create array here to get the definite size of array (cant use split on array list)
         String[] colonSplitArray = line.split(":");
         if(colonSplitArray.length > 0 && colonSplitArray[0].equals(speaker)) {
            // Speaker we are looking for start tracking words
            trackWords = true;
         }
         // if the first word left of colon all uppercase is in fact uppercase then it is another speaker
         else if (colonSplitArray.length > 0 && colonSplitArray[0].toUpperCase().equals(colonSplitArray[0])) {
            // different speaker stop tracking words
            trackWords = false;
         }
         else {
            // normal colon on line so ignore
         }
         if(trackWords == true) {
            // Removes punctuation
            editedLine = line.replaceAll("[^\\s\\w]", "");
            // Remove speaker
            editedLine = editedLine.replaceAll(speaker, "");
            // Split the new line with no speaker and punc by space
            String[] lineArray = editedLine.split(" ");
            // Iterate through this array
            for(int i = 0; i < lineArray.length; i++) {
               String currentWord = lineArray[i];
               //same word as currentWord just in object format
               WordFrequency wwf = new WordFrequency(lineArray[i]);
               // If the word is already in our frequewent word list increment it
               if(frequentWordList.contains(wwf)) {
                  // We already created the word
                  //Integer index = frequentWordList.indexOf(wwf);
                  // Increment that word's frequence
                  wwf.incrementFrequency();
               }
               // We need to create the word
               else {
                  WordFrequency newWord = new WordFrequency(currentWord, 1);
                  // append it to the list
                  frequentWordList.add(newWord);

               }
            }
         }

      }
      // Check if code is right
      for(int i = 0; i < frequentWordList.size() -1; i++) {
         // should print out word object types
         System.out.println(frequentWordList.get(i));
      }
      scanner.close();
   }
}

