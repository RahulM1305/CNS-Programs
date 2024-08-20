import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;
public class BlowFishCipher {
	public static void main(String[] args) throws Exception {
// Create a key generator based upon the Blowfish cipher
		KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
// Generate a secret key
		SecretKey secretkey = keygenerator.generateKey();
// Create a cipher based on the Blowfish cipher
		Cipher cipher = Cipher.getInstance("Blowfish");
// Initialize cipher to with secret key
		cipher.init(Cipher.ENCRYPT_MODE, secretkey);
// Get the text to encrypt from the console
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input your message: ");
		String inputText = scanner.nextLine();
		scanner.close();
// Encrypt message
		byte[] encrypted = cipher.doFinal(inputText.getBytes());
// Re-initialize the cipher to be in decrypt mode
		cipher.init(Cipher.DECRYPT_MODE, secretkey);
// Decrypt message
		byte[] decrypted = cipher.doFinal(encrypted);
// and display the results
		System.out.println("\nEncrypted text: " + new String(encrypted) + "\n" + "\nDecrypted text: " + new
		                   String(decrypted));
	}
}
