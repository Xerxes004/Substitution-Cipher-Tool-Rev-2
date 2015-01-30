/**
 * Title:     Decipherer Description: Uses calibrated arrays of substitution
 * cipher data to map a calibration file to a cipher file. Displays the output.
 * 
 * Copyright: Copyright (c) 2015, Wesley Kelly, Cedarville University
 * Company:   N/A
 *
 * @author:   Wesley Kelly, James Von Eiff
 * @version 1.0
 */

package SubstitutionCipherTool;

public class Decipherer {
  
    //String to hold the mapped cipher
    private String currentGuess;
    //String to hold the unmapped cipher
    private String originalCipher;
    //This holds the frequencies of the ciphertext
    private char[] cipherFreq;
    //This holds the calibrated frequencies
    private char[] calibFreq;

    
    //Empty constructor
    public Decipherer() {
        currentGuess = "";
        originalCipher = "";
        cipherFreq = new char[26];
        calibFreq = new char[26];
    }
    
    public void decipherCipher(CalibrationFileParser cali, CipherFileParser ciph) {
        currentGuess = "";
        originalCipher = ciph.getRawCiphertext();
        for(int i = 0; i < 26; i++){
            cipherFreq[i] = ciph.getCipherAlphabet()[i];
        }
        
        for(int i = 0; i < 26; i++){
            calibFreq[i] = cali.getCalibrationAlphabet()[i];
        }    
        for(int i = 0; i < originalCipher.length(); i++) {
            char letter = originalCipher.charAt(i);
            if(Character.isWhitespace(letter)) {
                    currentGuess += " ";
            } else {
                for(int j = 0; j < 26; j++) {
                    if(letter == cipherFreq[j]) {
                        currentGuess += calibFreq[j];
                    }
                }

            }
        }
        
    }
    
    public String getCurrentGuess() {
        
       return currentGuess;
    }
}
