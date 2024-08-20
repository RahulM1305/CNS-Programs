import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
import java.security.Key;
public class BlowFish {
	public static void main(String[] args) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
		keyGenerator.init(128);
		Key secretKey = keyGenerator.generateKey();
		Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
		cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] iv = cipherOut.getIV();
		if (iv != null) {
			System.out.println("Initialization Vector of the Cipher: " + encoder.encodeToString(iv));
			FileInputStream fin = null;
			FileOutputStream fout = null;
			CipherOutputStream cout = null;
			try {
				fin = new FileInputStream("inputFile.txt");
				fout = new FileOutputStream("outputFile.txt");
				cout = new CipherOutputStream(fout, cipherOut);
				int input;
				while ((input = fin.read()) != -1) {
					cout.write(input);
				}
			} finally {
				if (fin != null) {
					fin.close();
				}
				if (cout != null) {
					cout.close();
				}
			}
		}
	}
}
