import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        // loop through menu until quit selected
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n\n-----------Vigenere Cipher-----------");
            System.out.println("Please choose one of the following options:");
            System.out.println("1. Encrypt Text");
            System.out.println("2. Decrypt Text");
            System.out.println("3. Quit");

            int input = scan.nextInt();

            if (input == 1) {
                Encrypt();
            } else if (input == 2) {
                Decrypt();
            } else if (input == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Please enter a valid choice");
            }
        } // end while
    }// end main()

    public static void Encrypt() {
        Scanner scan = new Scanner(System.in);
        System.out.println("You have entered Encrypt!");
        System.out.println("Enter plaintext to be encrypted:");
        String plaintext = scan.nextLine().toUpperCase();
        System.out.println("Enter the the key string which will be used to encrypt:");
        String key = scan.nextLine().toUpperCase();
        String answer = "";

        for (int i = 0, j = 0; i < plaintext.length(); i++) {
            // capturing the letter in plain text string
            char letter = plaintext.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                // (char) will let us parse the result into a char
                // Bellow is the algorithm I used to achieve the encrypting
                // First we do the multiplication of 2 * 'A' 65
                // Then, we add the letter value with the key value and subtract both
                // We found the modulo of the value we just got and 26
                // Add it to 'A' (value)
                // This is our encrypted letter
                answer += (char) ((letter + key.charAt(j) - 2 * 'A') % 26 + 'A');
                // This will allow us to iterate through the key elements one by one
                j = ++j % key.length();
            } else {
                // Else if the char is not a upper case letter just add it to the message
                answer = answer + letter;
            }
        }

        System.out.println(plaintext + " encrypted using key of " + key + " = " + answer);

    }// end encrypt()

    public static void Decrypt() {
        Scanner scan = new Scanner(System.in);
        System.out.println("You have entered Decrypt!");
        System.out.println("Enter text to be decrypted:");
        String text = scan.nextLine().toUpperCase();
        System.out.println("Enter the the key string which will be used to decrypt:");
        String key = scan.nextLine().toUpperCase();
        String answer = "";

        //For loop to iterate through encrypted text
        for (int i = 0, j = 0; i < text.length(); i++) 
        {
            //capturing the letter in the text
            char letter = text.charAt(i);
            if (letter >= 'A' && letter <= 'Z')
            {
                //(char) will let us parse the result into a char
                //Bellow is the algorithm I used to achieve the decrypting
                //Firstly, we subtract the two values of letter and key at j position
                //We subtract it from 26 sum of the alphabet
                //Perfom the modulo operation 26
                //Add the result to the value of 'A'
            	answer += (char)(((letter - key.charAt(j) + 26) % 26) + 'A');
                //This will allow us to iterate through the key elements one by one
            	j = ++j % key.length();
            }
            else
            {
                //Else if the char is not a upper case letter just add it to the message
            	answer = answer + letter;
            }
        }

        System.out.println(text + " decrypted using key of " + key + " = \n\n" + answer);
    }
}// end VigenereCipher