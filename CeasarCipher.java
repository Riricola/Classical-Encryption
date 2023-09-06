//encode and decode work in theory, but the 'n' doesnt wrap around like its supposed to
//have the function take from the command line

import java.io.PrintWriter;

public class CeasarCipher{
    public static void main(String[] args) throws Exception{
        PrintWriter pen = new PrintWriter(System.out,true);
        //PrintWriter pen2 = new PrintWriter(System.error,true);

        
        //if(args[0].equals("encode") || args[0].equals("decode")){
        //int base = 97;
        String variable = "helloworld";
        String variable2 = "dahhksknhz";

        pen.printf(variable + "\n");
        pen.printf(encode(variable, 1) + "\n");
        pen.printf(decode(variable2, 2) + "\n");
        pen.flush();
        }
        /*
        else{
            pen2.print("Incorrect number of parameters.");
            System.err();
            system.err.println()
            System.exit();
            
        }*/     
        
//main should take in a string from the terminal

    public static String encode(String word, int n) throws Exception{
        int base = 97;
        // a - base = 0 ; z - base = 25
        // 
     
    // then result + base

        char[] letters = word.toCharArray();
        //turns the string into an array of chracters

        for(int i = 0; i < word.length(); i++){
            char temp = letters[i];
            //saves the character into temp

            char newChar = (char) (temp - base);
            newChar = (char) (temp + n);
            //might need (char)
            //does the math
            if(newChar > 25){
                newChar = (char)((newChar % 25) - 1);
            }   

            newChar = (char) (newChar + base);
            //encrypts the char
            letters[i] = newChar;
            //puts the newly encrypted char back into the letters array
        }//for
        String encodedMess = new String(letters);
        return encodedMess;
    }//encode

    public static String decode(String word, int n) throws Exception{
        char[] letters = word.toCharArray();

        for(int i = 0; i < word.length(); i++){
            char newChar = (char) (word.charAt(i) - n);
            letters[i] = newChar;

        }
        String decodedMess = new String(letters);
        return decodedMess;
    }//decode

}


