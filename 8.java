import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;
import java.util.Random;
import java.util.Scanner;
public class RSA {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter a Prime number: ");
		BigInteger p = sc.nextBigInteger(); // Input first prime number
		System.out.print("Enter another prime number: ");
		BigInteger q = sc.nextBigInteger(); // Input second prime number
		BigInteger n = p.multiply(q); // Calculate n = p * q
		BigInteger n2 = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // Calculate (p-1) * (q-1)
		BigInteger e = generateE(n2); // Generate public key exponent e
		BigInteger d = e.modInverse(n2); // Calculate private key exponent d using modular inverse
		System.out.println("Encryption keys are: " + e + ", " + n);
		System.out.println("Decryption keys are: " + d + ", " + n);
	}
	public static BigInteger generateE(BigInteger fiofn) {
		int y;
		int GCD;
		BigInteger e;
		BigInteger gcd;
		Random x = new Random();
		do {
			y = x.nextInt(fiofn.intValue() - 1);
			String z = Integer.toString(y);
			e = new BigInteger(z);
			gcd = fiofn.gcd(e);
			GCD = gcd.intValue();
		} while (y <= 2 || GCD != 1);
		return e;
	}
}
