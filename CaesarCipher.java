import java.util.Scanner;

/**
 * This class encrypts strings with a keyphrase version of the classic
 *      Caesar Cipher.
 *      (as described in The Code Book by Simon Singh)
 *
 * @author gcschmit
 * @version 21 September 2018
 */
public class CaesarCipher
{
    /*
     * static: same value for the variable for all objects in the class.
     *      This is like class attributes in Python. 
     *      Static class variables can be accessed directly through the class
     *              (e.g., CaesarCipher.ALPHABET, Math.PI, Color.RED).
     */
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String keyphrase;

    public CaesarCipher(String initialKeyphrase){
        //prepare the keyphrase by removing duplicate letters
        this.compressKeyphrase(initialKeyphrase);
    }

    /**
     * Returns a string that describes the average time to crack the cipher, 
     *        in several formats, based on the specified number of seconds oer guess.
     * 
     * @param secPerGuess the number of seconds to evaluate each attempt 
     * @return a string that describes the average time to crack the cipher
     *      
     */
    public String getComplexityDescription(int secPerGuess){
        /*
         * Instead of using a "magic number" (e.g., 3.14159), use constants defined by us or the Java Standard Library. For example, in the Math class is defined: 
         *      public static final double PI = 3.1415926535; 
         * Declare a constant with the final keyword. 
         *      By conventionm constants are in all caps with underscores. 
         */
        final int SECONDS_FOR_EVERY_MINUTE = 60;
        final int MINUTES_FOR_EVERY_HOUR = 60;
        final int HOURS_FOR_EVERY_DAY= 24;
        final int DAYS_FOR_EVERY_YEAR = 365;
        //one method in a class can invoke another method in the same class
        //      we invoke the method on "this"
        long totalSeconds = this.calculateAverageTimeToCrack(secPerGuess);

        /*
         *Use integer division to caluclate how many whole minutes are in the specified number of seconds. 
         *      
         *Integer division (like // operator in Python) discards the remainder (truncates - cuts off e.g., 3.999 truncate ---> 3)
         *
         *Java does integer division when both operands are integer types:
         *      floating-point division when one or both operands are floating - point types
         *      
         * For example:
         * 
         *      3/4  => 0       (3 and 4 are int literals)
         *      3.0/4 => 0.75   (3.0 is a double literal) 
         *      
         */
        long wholeMinutes = totalSeconds / SECONDS_FOR_EVERY_MINUTE; 

        /*
         * Use the modulo operator to calucalate how many seconds are leftover. 
         * 
         * The mod operator (%) returns the remainder of the divisipm operation. 
         * 
         * It can be very useful when paired with integer division. 
         * 
         * For example: 
         *      7%2 => 1
         *      11%3 =>2
         *      6%2 => 0
         *      4%11 => 4
         *      
         * % 2 is usually used to test odd/even (odd => 1; even => 0)     
         */

        long leftOverSeconds = totalSeconds % SECONDS_FOR_EVERY_MINUTE;

        long wholeHours = wholeMinutes / MINUTES_FOR_EVERY_HOUR;
        long leftoverMinutes = wholeMinutes % MINUTES_FOR_EVERY_HOUR;

        long wholeDays = wholeHours / HOURS_FOR_EVERY_DAY;
        long leftoverHours = wholeHours % HOURS_FOR_EVERY_DAY;

        long wholeYears = wholeDays / DAYS_FOR_EVERY_YEAR;
        long leftoverDays = wholeDays % DAYS_FOR_EVERY_YEAR;

        /*
         * A conversion is when a data value is converted from one type to another. 
         *      (e.g., int to double, double to int, int to long
         *      
         * Widening: perserves information (e.g., into a double, int to a long)
         * Narrowing: lossy(may lose data): (e.g., double(5.32) to an int(5)
         * 
         * Java only automatically performs wedening conversions. 
         */
        double yearAsDecimal = totalSeconds;

        /*
         * Arithmetic Promotion 
         * 
         * If the two operands are of different types, Java attempts to promot one
         *      of the operands (widening conversion) and then performs the operation.
         *      
         *      In this case, both SECONDS_FOR_EVERY_MINUTE and MINUTES_FOR_EVERY_HOURE are ints;
         *          so, Java doesn't preform any promotion, and instread performs the multiplication and returns the result as an int. Only after 
         *          all three multiplications does Java promote the int vakye of the resulting product to a kibf and then assigns it to SECONDS_FOR_EVERY_YEAR
         *      
         *      
         *      This promotion may be too late! If the multiplication overflows an int, 
         *          the wrong value will be promoted to a long and stored. 
         *      
         */

        final long SECONDS_FOR_EVERY_YEAR = SECONDS_FOR_EVERY_MINUTE * MINUTES_FOR_EVERY_HOUR * HOURS_FOR_EVERY_DAY * HOURS_FOR_EVERY_DAY; 

        String desc = "Average time to crack: " + wholeYears + " years, " + leftoverDays +
            " days, " + leftoverHours + " hours, " + leftoverMinutes + " minutes, " +
            leftOverSeconds + " seconds\n";

        yearAsDecimal = yearAsDecimal / SECONDS_FOR_EVERY_YEAR;
        desc+="or " + yearAsDecimal + " years\n";

        /*
         * To force a conversion, use the cast operator, 
         *      A cast is the "I know what I'm doing" conversion.
         *      
         * (int)84.986 ==> truncates to an int with a value of 84
         * (int)(3.6+0.5) ==> truncating 4.1 to an int with a value of 4
         * 
         * If we want to round a double to the nearest integer, one aproach is to add 0.5
         *  and then case the result to an integer, which truncates the decimal portion.
         *  
         * The following divides yearsADecimal by 10,then round the resulting long 
         *  to an int. 
         */
        int decades = (int) ((yearAsDecimal / 10)+0.5);
        desc += "or about "+decades + " decades\n";

        //If we try to change the value, a compiler error will be generated 
        //SECONDS_FOR_EVERY_MINUTE = 30;
        return desc;
    }

    /**
     * Compress the specified key0phrase by removing all duplicate letters.
     * 
     * @param initKeyphrase the keyphrase to compress
     */
    private void compressKeyphrase(String initKeyphrase){
        this.keyphrase = "";

        /*
         * length
         *      returns the number of characters in the string
         */
        int keyphraseLength = initKeyphrase.length();

        for(int i = 0; i<keyphraseLength; i++){
            /*
             * substring
             *      returns part of the string starting at the first specified index 
             *          up to, but not including, the second specified index
             * 
             * initKeyphrase:
             *C A E S A R
             *0 1 2 3 4 5       <= indicies
             *
             *length: 6
             */
            /*
             * substring
             *      If only one index is specified, returns part of the string start at the 
             *          specified index through the end of the string  
             *          
             *      substring does not support negative indicies:
             *              Foe example, instead of -2, we would specify
             *                  initKeyphrase.length() -2 
             * 
             *  initKeyphrase:
             *      C A E S A R
             *      0 1 2 3 4 5       <= indicies
             *
             *      length: 6     
             */
            String letter = initKeyphrase.substring(i, i+1);

            String restOfKeyphrase = initKeyphrase.substring(i + 1);
            /*
             * indexOf 
             *      returns the index of the start of the first occurrence of the specified string. 
             *      if not found, returns -1
             *      
             * restOfKeyphrase:
             *  A E S A R
             *  0 1 2 3 4 
             *  
             *  length: 5
             *  
             *  
             *  For example, restOfKeyphrase("SA") => returns 2
             */
            int index = restOfKeyphrase.indexOf(letter);

            /*
             * String concatenation
             *      + is the string concatenation operator 
             *          concatenates the second String operand to the end of the first
             *              String operand and returns a reference to a new String
             *          if one or both operands are a String type, + is the string 
             *              concatenation operator (operands are converted to String
             *              objects); otherwise, + is the addition operator
             *              
             * int x = 7;
             * String xAsString = "" + x;       //xAsString ==> "7"
             */

            if (index == -1)  //if the letter is not a duplicate
            {
                this.keyphrase = this.keyphrase + letter;
                // same as: this.keyphrase += letter;

            }

        }
    }

    /**
     * Encrypts the specified text using the specified keyphrase using a
     *      keyphrase-enhanced Caesar Cipher.
     *      
     *  @param  text        the text to encrypt
     *  @param  keyphrase   the keyphrase with which to encrypt the specified text
     *  @return             the encrypted text
     */
    public String encrypt(String text)
    {
        String encryptedText = "";

        /*
         * The keyphrase, after removing any repeated letters is used as the beginning of the
         *      jumbled cipher alphabet. The remainder of the cipher alphabet is merely the
         *      remaining letters of the alphabet, in their correct order, starting where the
         *      keyphrase ends.
         */
        String cipherAlphabet = this.keyphrase;
        for(int i = 0; i < CaesarCipher.ALPHABET.length(); i++)
        {
            char letter = CaesarCipher.ALPHABET.charAt(i);
            if(this.keyphrase.indexOf(letter) == -1)
            {
                cipherAlphabet += letter;
            }
        }

        /*
         * For each letter in the text that is a letter, find the corresponding letter
         *      at the same position in the cipher alphabet as its replacement.
         */
        for(int i = 0; i < text.length(); i++)
        {
            char letter = text.charAt(i);

            // if the letter is between A and Z
            if(letter >= 'A' && letter <= 'Z')
            {
                // 65 is the ASCII value of 'A'
                int cipherIndex = letter - 65;
                encryptedText += cipherAlphabet.charAt(cipherIndex);
            }
            else    // don't substitute the letter; just use it as is
            {
                encryptedText += letter;
            }
        }

        return encryptedText;
    }

    /*
     *  This method is private and, therefore, can only be invoked from within this class.
     *      For example, the getComplexityDescription method invokes this method.
     */

    /**
     * Calculates the average time to crack the cipher, based on the
     *      specified length of the keyphrase and seconds to evaluate
     *      each attempt, using a brute force approach. This calculation
     *      assumes that the cracker knows the length of the keyphrase.
     *      If the length is not know, it will take substantially longer
     *      to crack the cipher. Regardless, this calculation is only
     *      for a brute force approach; other techniques (e.g., frequency
     *      analysis) can crack the cipher extremely quickly.
     *      
     *  @param  secPerGuess     the number of seconds to evaluate each attempt
     *  @return                 the average number of seconds to crack the cipher
     */
    private long calculateAverageTimeToCrack(int secPerGuess)
    {
        final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
        int lettersRemaining = NUMBER_OF_LETTERS_IN_ALPHABET;
        int keyphraseLength = this.keyphrase.length();
        long combinations = 1;

        /*
         * Calculate the number of combintations for the specified keyphrase length.
         *  For example, if the keyphrase is six characters long:
         *      26 * 25 * 24 * 23 * 22 * 21
         *      would be the number of combinations of cipher alphabets for keyphrases
         *      that are six characters long.
         */
        for(int i = 0; i < keyphraseLength; i++)
        {
            combinations *= lettersRemaining;
            lettersRemaining -= 1;
        }

        long worstCaseTimeToCrack = combinations * secPerGuess;

        // average time is half the worst time since the best time is cracking the
        //  cipher on the first attempt
        return worstCaseTimeToCrack/2;
    }

    /*
     * This method is static and, therefore, is independant of the state of a 
     *      CaesarCipher object.
     * As a result this method may be invoked on a class instead of a variable 
     *      That references an object. 
     *      
     *      CaesarCipher.generateKeyphrase(7);
     *      
     * In addition, this method cannot access any instance variables or invoke 
     *      any non-static methods (there is no "This")
     *      
     */
    /**
     * Generates a pseudorandom keyphrase of the specified length in characters
     * 
     * @param length the number of characters in the keyphrase
     * @return a pseudorandom keyphrase of the specified length 
     */

    public static String generateKeyphrase(int length){
        String keyphrase = "";
        for(int i = 0; i<length;i++){
            /*
             * The Math.random static method returns a double [0.0 ... 1.0)
             * 
             * Often we use the following algorithim to to generate random integers from 
             *      [min ... max]:
             *      
             *      int n = (int)((Math.random() * (man-min+1))+min);
             *      
             * For example: generate a random int [0 ... 25]
             * 
             * A B C D E F G H I J K L M N O P Q R S T U V X Y Z
             * 0 1 2 3 4 5 6 7 8 9 ...                         25 <== indicies
             * 
             */
            int letterIndex = (int)(Math.random()*26);
            keyphrase += CaesarCipher.ALPHABET.substring(letterIndex, letterIndex + 1);
        }
        return keyphrase;
        
        
    }
}
