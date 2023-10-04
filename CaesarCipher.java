import java.io.PrintWriter;

/*    CaesarCipher
*    takes in a word to be encoded/decoded, and a keyword specifying whether the user wants 
*    to perform an encryption or decryption. Results are printed for using the numbers
*    0-25 to encrypt/decrypt the word.
*/
public class CaesarCipher {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) { // checks if user entered enough command arguments
            System.err.println("Incorrect number of Command Line Arguments.");
            System.exit(2);
        } else {
            String word = args[1];
            String cypherName = args[0];
            // saves the user-inputted string

            if ((cypherName.equals("encode")) || cypherName.equals("decode")) {
                cypher(word, cypherName);
                // performs either encode/decode depending on the inputted word
            } else {
                System.err.println("Invalid option. Pleae type 'encode' or 'decode'.");
                System.exit(2);
            } // else
        } // else
    }// main

    /*
     * cypher(String str, String keyword) function
     * 
     * pre: string str must be the first argument user entered argument on the command line
     * 
     * post: uses the string keyword to perform the Caesar Cipher method of encryption or decryption
     * on string str
     */
    public static void cypher(String str, String cypherName) throws Exception {
        int base = (int) 'a';
        int key = 0;

        while (key != 26) {
            char[] letters = str.toCharArray();
            // turns the string into an array of chracters

            for (int i = 0; i < str.length(); i++) {// iterates through each character in str
                char temp = letters[i];
                int newChar = (int) (temp - base);
                // saves the character into temp

                if (cypherName.equals("encode")) {
                    // char newChar = (char) ((temp - base) + key);
                    newChar = newChar + key;
                    newChar = (newChar % 26);
                } else if (cypherName.equals("decode")) {
                    newChar = newChar - key;
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
            key++;
            // glues the letters together into a string and returns it
            System.out.println("key = " + key + " : " + cypherMessage);
        }
    }// cypher

}// Ceasar Cipher
