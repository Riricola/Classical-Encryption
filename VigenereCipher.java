import java.io.PrintWriter;
//add a citation of where i found the .repeat() method
public class VigenereCipher{
    public static void main(String[] args) throws Exception{
        if(args.length != 3){ //checks if user entered enough command arguments
            System.err.println("Incorrect number of Command Line Arguments.");
            System.exit(2);
        } else{
            PrintWriter pen = new PrintWriter(System.out,true);
            String word = args[1];
            String key = args[2];
            String newKey = (keyStretcher(word,key));
            
            if(args[0].equals("encode")){ //checks for whether the code should perform an encode or decode
                pen.println(encode(word, newKey));   
            } else if (args[0].equals("decode")){
                pen.println(decode(word, newKey));
            } else{ //error message incase user doesn't input "encode" or "decode"
            System.err.println("Valid options are 'encode' or 'decode'.");
            System.exit(2);
            }//else          
            
            pen.flush();
        }//else   
}//main

/*  keyStretcher(String word, String key)
 * pre: word and key must be strings entered by the user on the Command line
 */
    public static String keyStretcher(String word, String key){
        int repeats = (word.length()) / (key.length());
        //sets the amount of times we want the key to repeat equal to the amount of times the key
        //can fit into the word's length
        String stretchedKey = key.repeat(repeats + 1);
        //repeats the key 'repeats' amount of times, plus an extra repeat so the new key is longer than the word

        stretchedKey = stretchedKey.substring(0, (word.length()));
        //cuts the lengthy key so it's length is equal to the word we are encode/decoding

        return stretchedKey;
    }//keyStretcher

 /*  encode(String word, String n) function

    pre: string word must be the first argument user entered argument on the command line
         the key must have been 'stretched' using the keyStretcher() function

    post: uses String key to perform the Vigenere Cipher method of encryption on string word
*/   
    public static String encode(String word, String key){
        //key must be the stretched key


        int base = 97;
        char[] letters = word.toCharArray();
        //turns the string into an array of characters

        for(int i = 0; i < word.length(); i++){//iterates through each character in str
            char temp = letters[i];
            //saves the character into temp

            int newChar = (int) ((temp - base) + (key.charAt(i) - base));
            //performs the character addition
            //Note: before 'a' + 'c', both the 'a' and 'c' have to be converted to the 0-25 index

            newChar = (char) (newChar % 26);
            //this performs the 'wrap around' if necessary
            newChar = (char) (newChar + base);
            //encrypts the char back to its appropriate char

            letters[i] = (char)newChar;
            //puts the newly encrypted char back into the letters array
        }//for

        String encodedMessage = new String(letters);
        //glues the letters together into a string and returns it
        return encodedMessage;
    }//encode
    
/*  decode(String word, String key) function

    pre: string word must be the first argument user entered argument on the command line
         the key must have been 'stretched' using the keyStretcher() function

    post: uses String key to perform the Vigenere Cipher method of decryption on string word
*/      
    public static String decode(String word, String key) throws Exception{
        int base = 97;
        char[] letters = word.toCharArray();
        //turns the string into an array of chracters

        for(int i = 0; i < word.length(); i++){
            char temp = letters[i];
            //saves the character into temp

            int newChar = (int) ((temp - base) - (key.charAt(i) - base));
            //Sets the character to a 0-25 index, then adds the key "n"

            if(newChar < 0){ //checks if the encrypted character is negative
                newChar = (newChar + 26);//performs the wrap around
            }//if

            newChar = (char) (newChar + base);
            //encrypts the char back to its appropriate char 
            letters[i] = (char)newChar;
            //puts the newly encrypted char back into the letters array
        }//for

        String decodedMess = new String(letters);
        //glues the letters together into a string and returns it
        return decodedMess;
    }//decode

}//Vigenere Cipher