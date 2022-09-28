import java.util.*;

/**
 * Demonstrates the CaesarCipher class
 *
 * @author gcschmit
 * @version 21 September 2018
 */
public class CaesarCipherDemo
{
    public static void main(String[] args)
    {
        /*
         * A Scanner object parses primitive types and Strings from a stream 
         *      Stream - A Stream is a sequence of characters from a file, String, terminal, network connection. 
         *      
         *      Parsing is separating a sequence of characters into tokens based on delimiters. 
         *      
         *          A Token is a meaningful sequence of characters (e.g., word).
         *      
         *          Delimiters are characters that separate tokens, by default delimiters are white space (space, tab, newline)      
         *          
         * When we create a Scanner object, we have to specify the inpiut stream 
         * (e.g., Ststem.in which is the terminal input)
         */
  
        
        /*
         *  1. Prompt the user for what we want them to input. 
         *  2. Use print, not println; so that the cursor is at the end of the 
         *  prompt and not on a new line. 
         *  3. Leave a space after the prompt
         */
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the text you want to encrypt: ");
        String text = s.nextLine();
        text = text.toUpperCase();
        
        System.out.print("Enter a keyphrase: ");
        
        /*
         * The next method returns the nect token in the stream as a String.
         */
        
        
        
        String keyphrase = s.next();
        keyphrase = keyphrase.toUpperCase().trim();
        
        System.out.print("Enter the number of seconds to test a guessed keyphrase: ");
        
        /*
         * The nextInt method attempts to convert the next token in the stream to an int 
         *  and returns the value. If the next token cannot be converted, an exception is generated.
         *  
         *  The nextDouble method behaves in the same way for doubles
         */
        
        
        
        

    
    
    }
    
}