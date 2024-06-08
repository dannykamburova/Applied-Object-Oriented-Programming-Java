// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.
package problem1;
public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order
      
      // print all 52 Cards in the order in which they are dealt
//      for ( int i = 0; i < 13; i++ )
//      {
//         // deal and print 4 Cards
//         System.out.printf( "%-20s%-20s%-20s%-20s\n",
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
//      } // end for
      Card[] leftHand = myDeckOfCards.dealHand();
      Card[] rightHand = myDeckOfCards.dealHand();

      System.out.printf("%-20s%-20s\n", "Left hand:", "Right hand: ");
      for(int i = 0; i< leftHand.length; i++) {
         System.out.printf("%-20s%-20s\n", leftHand[i], rightHand[i]);
      }

      int leftHandStrength = myDeckOfCards.hasStrength(leftHand);
      int rightHandStrength = myDeckOfCards.hasStrength(rightHand);
      System.out.println();
      System.out.println("Hand values:");
      System.out.printf("%-20s%-20s\n" , resultText(leftHandStrength), resultText(rightHandStrength));

      System.out.println();
      if(leftHandStrength > rightHandStrength) {
         System.out.println("Result: left hand is better");
      }else if(leftHandStrength < rightHandStrength) {
         System.out.println("Result: right hand is better");
      }else{
         System.out.println("Result: left an right hands are with equal strength");
      }
   } // end main

   public static String resultText(int handStrength) {
      switch (handStrength) {
         case 7 -> {
            return "Four of a kind";
         }
         case 6 -> {
            return "Full house";
         }
         case 5 -> {
            return "Flush";
         }
         case 4 -> {
            return "Straight";
         }
         case 3 -> {
            return "Three of a kind";
         }
         case 2 -> {
            return "Two pairs";
         }
         case 1 -> {
            return "One pair";
         }
         default -> {
            return "none";
         }
      }
   }
} // end class DeckOfCardsTest

