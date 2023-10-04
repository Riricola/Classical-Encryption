import java.io.PrintWriter;

// add a citation of where i found the .repeat() method
public class VigenereCipher {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) { // checks if user entered enough command arguments
            System.err.println("Incorrect number of Command Line Arguments.");
            System.exit(2);
        } else {
            PrintWriter pen = new PrintWriter(System.out, true);
            String cypherName = args[0];
            String word = args[1];
            String key = args[2];

            if(key.equals("")){
                System.out.println(word);
                return;
            }

            String newKey = (keyStretcher(word, key));

            if ((cypherName.equals("encode")) || (cypherName.equals("decode"))) {
                cypher(word, cypherName, newKey);
            } else { // error message incase user doesn't input "encode" or "decode"
                System.err.println("Valid options are 'encode' or 'decode'.");
                System.exit(2);
            } // else


            pen.flush();
        } // else
    }// main

    /*
     * keyStretcher(String word, String key) pre: word and key must be strings entered by the user
     * on the Command line
     * 
     * post: returns the key fitting the length of the word
     */
    public static String keyStretcher(String word, String key) {
        int repeats = (word.length()) / (key.length());
        // sets the amount of times we want the key to repeat equal to the amount of times the key
        // can fit into the word's length
        String stretchedKey = key.repeat(repeats + 1);
        // repeats the key 'repeats' amount of times, plus an extra repeat so the new key is longer
        // than the word

        stretchedKey = stretchedKey.substring(0, (word.length()));
        // cuts the lengthy key so it's length is equal to the word we are encode/decoding

        return stretchedKey;
    }// keyStretcher


    /*
     * cypher(String str, String keyword) function
     * 
     * pre: string str must be the first argument user entered argument on the command line
     * 
     * post: uses the string keyword to perform the Caesar Cipher method of encryption or decryption
     * on string str
     */
    public static void cypher(String str, String cypherName, String key) throws Exception {
        int base = (int) 'a';
        char[] letters = str.toCharArray();
        // turns the string into an array of chracters

        for (int i = 0; i < str.length(); i++) {// iterates through each character in str
            char temp = letters[i];
            int newChar = (int) (temp - base);
            // saves the character into temp

            if (cypherName.equals("encode")) {
                // char newChar = (char) ((temp - base) + key);
                newChar = newChar + (key.charAt(i) - base);
                newChar = (newChar % 26);
            } else if (cypherName.equals("decode")) {
                newChar = newChar - (key.charAt(i) - base);
                // Sets the character to a 0-25 index, then adds the key "n"

                if (newChar < 0) { // checks if the encrypted character is negative
                    newChar = (newChar + 26);// performs the wrap around
                } // if
            }
            // Sets the character to a 0-25 index, then adds the key "key"

            // this perfors the 'wrap around' if necessary
            newChar = (newChar + base);
            // encrypts the char back to its appropriate char

            letters[i] = (char) newChar;
            // puts the newly encrypted char back into the letters array
        } // for

        String cypherMessage = new String(letters);

        // glues the letters together into a string and returns it
        System.out.println(cypherMessage);

    }// cypher

}// Vigenere Cipher
