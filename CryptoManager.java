package src;
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	//check each string character to see if the statements are within the ASCII bound: Roath
	public static boolean stringInBounds (String plainText) {
		//makes string an array
		char[] str=new char[plainText.length()];
		for(int y=0; y<str.length; y++){
			str[y]=plainText.charAt(y);
		}
		
		//checks if string is in bound
		for(int x=0; x<str.length; x++) {
			if(str[x]<LOWER_BOUND || str[x]> UPPER_BOUND)
				return false;
		}
		
		//returns boolean value after validation
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	
	//translates a plain text into a caesar encryption using an int key: Roath
	public static String encryptCaesar(String plainText, int key) {
		//declare arrays used
		char[] str=new char[plainText.length()];
		char[] newChar=new char[plainText.length()];
		
		//translates plain text into an array
		for(int y=0; y<str.length; y++){
			str[y]=plainText.charAt(y);
		}
		
		//translates the arrays into the new caesar array
		for(int x=0; x<str.length; x++) {
			if((str[x]+key)>=LOWER_BOUND && (str[x]+key)<= UPPER_BOUND)
				newChar[x]=(char) (str[x]+key);
			else {
				while((str[x]+key)<LOWER_BOUND || (str[x]+key)>UPPER_BOUND)
					newChar[x]=(char) (str[x]-RANGE);
			}
		}
		
		//translates the caesar array into a string to be returned
		String newStr=new String(newChar);
		return newStr;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	//translates plain text into a bellaso string: Roath
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//declares variables used
		int range = plainText.length();
		char[] newStr=new char[range];
		int value=0;
		  
		//extends the bellaso string to match the plain text length
		for (int x = 0; ; x++) { 
		        if (range == x) 
		            x = 0; 
		        if (bellasoStr.length() == plainText.length()) 
		            break; 
		        bellasoStr+=(bellasoStr.charAt(x)); 
		    }  
		  
		//translates the plain text into a bellaso array
		for (int y = 0; y < plainText.length(); y++) 
		    { 
		    	if((plainText.charAt(y)+bellasoStr.charAt(y))>=LOWER_BOUND && (plainText.charAt(y)+bellasoStr.charAt(y))<= UPPER_BOUND)
		    		newStr[y]=(char) (plainText.charAt(y) + bellasoStr.charAt(y)); 
		    	else {
		    		newStr[y]=(char) ((plainText.charAt(y) + bellasoStr.charAt(y))-RANGE);
		    		while(newStr[y]<LOWER_BOUND || newStr[y]> UPPER_BOUND) 
		    			newStr[y]-=RANGE;
		    	}
		    } 
		 
		//translates the bellaso array into a string and returns it
		String encrypted=new String(newStr);
		return encrypted; 
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	//translates the caesar string into a plain text string: Roath
	public static String decryptCaesar(String encryptedText, int key) {
		//declares arrays
		char[] str=new char[encryptedText.length()];
		char[] newStr=new char[encryptedText.length()];
		
		//translate encrypted text into an array
		for(int x=0; x<encryptedText.length(); x++) {
			str[x]=encryptedText.charAt(x);
		}
		
		//translates the array into a plain text array
		for(int y=0; y<encryptedText.length(); y++) {
			if((str[y]-key)>=LOWER_BOUND && (str[y]-key)<= UPPER_BOUND)
				newStr[y]=(char) (str[y]-key);
			else {
				while((str[y]+key)<LOWER_BOUND || (str[y]+key)>UPPER_BOUND)
					newStr[y]=(char) (str[y]+RANGE);
			}
		}
		
		//translates the text array into a string to be returned
		String newDecrypted=new String(newStr);
		return newDecrypted;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	
	//translates the bellaso string into a plain text string: Roath
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//declares variables
		int range = encryptedText.length();
		char[] newStr=new char[range];
		
		//lengthens the bellaso string to match the encrypted text length
		for (int x = 0; ; x++) { 
		        if (range == x) 
		            x = 0; 
		        if (bellasoStr.length() == encryptedText.length()) 
		            break; 
		        bellasoStr+=(bellasoStr.charAt(x)); 
		    }  
		
		//translates the encrypted string into a plain text array
		for (int y = 0; y < encryptedText.length(); y++) 
		    { 
		    	if((encryptedText.charAt(y)-bellasoStr.charAt(y))>=LOWER_BOUND && (encryptedText.charAt(y)-bellasoStr.charAt(y))<= UPPER_BOUND)
		    		newStr[y]=(char) (encryptedText.charAt(y) - bellasoStr.charAt(y)); 
		    	else	{
		    		newStr[y]=(char) ((encryptedText.charAt(y) - bellasoStr.charAt(y))+RANGE);
		    		while(newStr[y]<LOWER_BOUND || newStr[y]> UPPER_BOUND) 
		    			newStr[y]+=RANGE;
		    		
		    	}
		    }
		 
		//translates the plain text array into a string that is returned
		String encrypted=new String(newStr);
		return encrypted; 
	}
}

