# Classical-Encryption
Maria Rodriguez
Mini Project 1

In this project, I created a Caesar Cipher that encodes or decodes a string by taking every character, adding the
number n to that character for encryption, and subtracting the number n to that character for decryption. 
Vigenere Cipher performs encryption and decryption by using the letters in a keyword as the characters used
to perform the encryption/decryption math.

*---------------------------
| Changes made for MP1 Redo|
*---------------------------
- Combined encode and decode to one 'cypher' function in both CaesarCipher and ViginereCipher
- in CaesarCipher, rather than have 2 while loops to perform either encode or decode 25 times, the cypher
   function will print out the results 25 times.
- ViginereCipher now encode/decodes a string with an empty key ""

I have two java files, Ceasar Cipher and Vigenere Cipher, both performing their respective cipher. To run Ceasar 
Cipher on the command line, type "java" + the name of the file + "encode"/"decode" + a string you'd like to encrypt. 
To run the Vigenere Cipher on the command line, type "java" + the name of the file + "encode"/"decode" + a string 
you'd like to encrypt + the key you'd like to use.

Citations:
  * .charAt(), .toCharArray(), and .length() were methods adopted from Rebelsky.
  * the .repeat() method in Vigenere.java was adopted from Mozilla Developer
  *     https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/repeat
  * the .substring() method in Vigenere.java was adopted from GeeksforGeeks
  *     https://www.geeksforgeeks.org/substring-in-java/
