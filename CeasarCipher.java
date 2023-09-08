import java.io.PrintWriter;

public class CeasarCipher{
    public static void main(String[] args) throws Exception{
        if(args.length != 2){ //checks if user entered enough command arguments
            System.err.println("Incorrect number of Command Line Arguments.");
            System.exit(2);
        } else{
            PrintWriter pen = new PrintWriter(System.out,true);
            String word = args[1]; 
            
            if(args[0].equals("encode")){
                int encodeKey = 0;
                while(encodeKey != 26){
                    pen.println("n = " + encodeKey + ": " + (encode(word, encodeKey)));
                    encodeKey++;
                }//while
            } else if (args[0].equals("decode")){
                int decodeKey = 0;
                while(decodeKey != 26){
                    pen.println("n = " + decodeKey + ": " + (decode(word, decodeKey)));
                    decodeKey++;
                }//while
            } else{ //error message incase user doesn't input "encode" or "decode"
                System.err.println("Valid options are 'encode' or 'decode'.");
                System.exit(2);
            }//else
            
            pen.flush();
        }//else    
}//main

/*  encode(String str, int n) function

    pre: string str must be the first argument user entered argument on the command line

    post: uses int n to perform the Ceasar Cipher method of encryption on string str
*/
    public static String encode(String str, int n) throws Exception{
        int base = 97;
        char[] letters = str.toCharArray();
        //turns the string into an array of chracters

        for(int i = 0; i < str.length(); i++){//iterates through each character in str
            char temp = letters[i];
            //saves the character into temp

            char newChar = (char) ((temp - base) + n);
            //Sets the character to a 0-25 index, then adds the key "n"
            newChar = (char)(newChar % 26);
            //this perfors the 'wrap around' if necessary
            newChar = (char) (newChar + base);
            //encrypts the char back to its appropriate char

            letters[i] = newChar;
            //puts the newly encrypted char back into the letters array
        }//for

        String encodedMess = new String(letters);
        //glues the letters together into a string and returns it
        return encodedMess;
    }//encode

/*  decode(String str, int n) function

    pre: string str must be the first argument user entered argument on the command line

    post: uses int n to perform the Ceasar Cipher method of decryption on string str
*/    

    public static String decode(String str, int n) throws Exception{
        int base = 97;
        char[] letters = str.toCharArray();
        //turns the string into an array of chracters

        for(int i = 0; i < str.length(); i++){
            char temp = letters[i];
            //saves the character into temp

            int newChar = (int) ((temp - base) - n);
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

}//Ceasar Cipher