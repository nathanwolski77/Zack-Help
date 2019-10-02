package cecs274;



public class WordFrequency implements Comparable<WordFrequency>  {
   // TODO: instance variables
   //private ArrayList<String> word;
   private String word;
   private Integer frequency;

   

   // TODO: constructors
   
   public WordFrequency(String word) throws IllegalArgumentException {
      if(word == null || word == "" || word == " ") {
         throw new IllegalArgumentException();
      }
      this.word = word;

   }
   public WordFrequency(String word, Integer frequency) throws IllegalArgumentException{
      if(word == null || word == "" || word == " " || frequency < 0) {
         throw new IllegalArgumentException();
      }
      this.word = word;
      this.frequency = frequency;

   }
    

   // TODO: methods
   public String getWord() {
      return this.word;
   }
   public Integer getFrequency() {
      return this.frequency;
   }
   public void incrementFrequency() {
      frequency+=1;
   }
   public String toString() {
      return this.word + " : " + this.frequency;
   }
   // @Override
   // public boolean equals(Object obj) {
   //    if(obj == this.word) {
   //       return true;
   //    }
   //    else {
   //       return false;
   //    }
   // }
   @Override
   public int compareTo(WordFrequency word) {
      return this.word.compareTo(word.word);
   }
}
