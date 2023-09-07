import java.io.PrintWriter;

public class VigenereCipher{
    public static void main(String[] args) throws Exception{
        PrintWriter pen = new PrintWriter(System.out,true);
        String variable = "helloworld";
        String key = "cap";
        pen.printf(makeKey(variable, key) + "\n");
        pen.flush();
    }

    public static String makeKey(String word, String key){
        char[] keyStretch = new char[word.length()];
        //empty char array that is as long as the length of the word
        //char[] key = key.toCharArray();
        //here we turn the key into a char array that can be iterated thru

        //here we make key fit the length of word
        for(int i=0; i < word.length(); i++){
            for(int j = 0; j < 3; j++){
            keyStretch[i] = key.charAt(j);
            }
        }
    }//makeKey
}