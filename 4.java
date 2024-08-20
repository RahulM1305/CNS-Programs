//DES
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class Main {

    public static SecretKey getFixedKey() {
        // Corrected the key to be a proper 8-byte key for DES
        byte[] keyBytes = "12345678".getBytes(); // Use an 8-byte key for DES
        return new SecretKeySpec(keyBytes, "DES");
    }

    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String ciphertext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8");
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            SecretKey key = getFixedKey();

            System.out.print("Enter the String: ");
            String plaintext = scanner.nextLine();

            String encryptedText = encrypt(plaintext, key);
            System.out.println("Encrypted Value: " + encryptedText);

            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Decrypted Value: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
