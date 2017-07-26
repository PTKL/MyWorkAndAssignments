//package Enigma;
/**
 * 
 * 
 * @author Jacob Howell
 */
import java.util.*;
import java.io.*;

public class Enigma3 {
	private static char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };
	private static int n;
	private static int[] keys = new int[26];
	private static int encryptionKey;
	private static int cog1 = 2;
	private static int cog2 = 2;
	private static int cog3 = 2;
	private static String plainText;
	private static String cipherText;
	private static char[] plainTextChars;
	private static char[] cipherTextChars;
	private static Scanner kbd = new Scanner(System.in);
	private static int[] numRepPlainText;

	public static void cogRotation() {
		cog1--;
		if (cog1 < 0) {
			cog1 = 2;
			cog2--;
		} else if (cog2 < 0) {
			cog2 = 2;
			cog3--;
		} else if (cog3 < 0) {
			cog3 = 2;
		}
	}

	public void keyAssignment() {
		keys[0] = alphabet[n + 3];
		keys[1] = alphabet[n * 2];
		keys[2] = alphabet[n - 4];
		keys[3] = alphabet[n + 8];
		keys[4] = alphabet[n - 6];
		keys[5] = alphabet[n * 5];
		keys[6] = alphabet[n - 3];
		keys[7] = alphabet[n + 1];
		keys[8] = alphabet[n * 5];
		keys[9] = alphabet[n + 15];
		keys[10] = alphabet[n - 7];
		keys[11] = alphabet[n + 9];
		keys[12] = alphabet[n - 8];
		keys[13] = alphabet[n * 8];
		keys[14] = alphabet[n * 4];
		keys[15] = alphabet[n * 3];
		keys[16] = alphabet[n + 4];
		keys[17] = alphabet[n - 2];
		keys[18] = alphabet[n + 5];
		keys[19] = alphabet[n + 2];
		keys[20] = alphabet[n - 5];
		keys[21] = alphabet[n + 13];
		keys[22] = alphabet[n - 20];
		keys[23] = alphabet[n * 9];
		keys[24] = alphabet[n - 18];
		keys[25] = alphabet[n + 15];
		keys[26] = alphabet[n * 6];
	}

	public static void encryptionKeys() {
		if (cog1 == 2 && cog2 == 2 && cog3 == 2) {
			encryptionKey = keys[0];
		} else if (cog1 == 1 && cog2 == 2 && cog3 == 2) {
			encryptionKey = keys[1];
		} else if (cog1 == 0 && cog2 == 2 && cog3 == 2) {
			encryptionKey = keys[2];
		} else if (cog1 == 2 && cog2 == 1 && cog3 == 2) {
			encryptionKey = keys[3];
		} else if (cog1 == 1 && cog2 == 1 && cog3 == 2) {
			encryptionKey = keys[4];
		} else if (cog1 == 0 && cog2 == 1 && cog3 == 2) {
			encryptionKey = keys[5];
		} else if (cog1 == 2 && cog2 == 0 && cog3 == 2) {
			encryptionKey = keys[6];
		} else if (cog1 == 1 && cog2 == 0 && cog3 == 2) {
			encryptionKey = keys[7];
		} else if (cog1 == 0 && cog2 == 0 && cog3 == 2) {
			encryptionKey = keys[8];
		} else if (cog1 == 2 && cog2 == 2 && cog3 == 1) {
			encryptionKey = keys[9];
		} else if (cog1 == 1 && cog2 == 2 && cog3 == 1) {
			encryptionKey = keys[10];
		} else if (cog1 == 0 && cog2 == 2 && cog3 == 1) {
			encryptionKey = keys[11];
		} else if (cog1 == 2 && cog2 == 1 && cog3 == 1) {
			encryptionKey = keys[12];
		} else if (cog1 == 1 && cog2 == 1 && cog3 == 1) {
			encryptionKey = keys[13];
		} else if (cog1 == 0 && cog2 == 1 && cog3 == 1) {
			encryptionKey = keys[14];
		} else if (cog1 == 2 && cog2 == 0 && cog3 == 1) {
			encryptionKey = keys[15];
		} else if (cog1 == 1 && cog2 == 0 && cog3 == 1) {
			encryptionKey = keys[16];
		} else if (cog1 == 0 && cog2 == 0 && cog3 == 1) {
			encryptionKey = keys[17];
		} else if (cog1 == 2 && cog2 == 2 && cog3 == 0) {
			encryptionKey = keys[18];
		} else if (cog1 == 1 && cog2 == 2 && cog3 == 0) {
			encryptionKey = keys[19];
		} else if (cog1 == 0 && cog2 == 2 && cog3 == 0) {
			encryptionKey = keys[20];
		} else if (cog1 == 2 && cog2 == 1 && cog3 == 0) {
			encryptionKey = keys[21];
		} else if (cog1 == 1 && cog2 == 1 && cog3 == 0) {
			encryptionKey = keys[22];
		} else if (cog1 == 0 && cog2 == 1 && cog3 == 0) {
			encryptionKey = keys[23];
		} else if (cog1 == 2 && cog2 == 0 && cog3 == 0) {
			encryptionKey = keys[24];
		} else if (cog1 == 1 && cog2 == 0 && cog3 == 0) {
			encryptionKey = keys[25];
		} else if (cog1 == 0 && cog2 == 0 && cog3 == 0) {
			encryptionKey = keys[26];
		}
	}

	public static void textToNumber(char[] plaintext) {
		numRepPlainText = new int[plaintext.length];
		for (int j = 0; j < plaintext.length; j++) {
			for (int k = 0; k < alphabet.length; k++) {
				if (plaintext[j] == alphabet[k]) {
					for (int u = 0; u < numRepPlainText.length; u++) {
						numRepPlainText[u] = k;
					}
				}
			}
		}
	}

	public static void numberToText(int[] a) {
		cipherTextChars = new char[plainTextChars.length];
		for (int i = 0; i < a.length; i++) {
			for (int k = 0; k < alphabet.length; k++) {
				if (a[i] == alphabet[k]) {
					for (int j = 0; j < cipherTextChars.length; j++) {
						cipherTextChars[j] = alphabet[i];
					}
				}
			}
		}
	}

	public static void textEncrypt(char[] PlainTextChars) {
		// if (kbd.nextLine() == null)
		// {
		// System.out.println("No plaintext entered");
		// }
		// else
		// {
		//plainText = kbd.nextLine().toLowerCase();
		plainTextChars = new char[PlainTextChars.length];
		plainTextChars = PlainTextChars;
		textToNumber(plainTextChars);
		for (int i = 0; i < numRepPlainText.length; i++) {
			n = numRepPlainText[i];
			if (encryptionKey > 25 || encryptionKey < 0) {
				encryptionKey = 0;
			}
			encryptionKeys();
			for (int u = 0; u < numRepPlainText.length; u++) {
				numRepPlainText[u] = encryptionKey;
			}
			// numberToText(encryptionKey);
			cogRotation();
		}
		numberToText(numRepPlainText);
		// cipherText = cipherTextChars.toString();
		// }
	}

	public static void main(String[] args) {
		System.out.println("Enter plaintext: ");
		plainText = kbd.nextLine().toLowerCase();
		char[] charTextArray = plainText.toCharArray();
		System.out.println(charTextArray[2]);
		textEncrypt(charTextArray);
		// System.out.println(cipherText);
		System.out.println(java.util.Arrays.toString(cipherTextChars));
	}
}