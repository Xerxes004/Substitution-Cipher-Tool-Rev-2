/**
 * Title      : File Parser
 * Description: An input .txt "calibration" file is input to the system, and
 *              its letter frequencies are analyzed and made available to the
 *              user.
 * Copyright  : Copyright (c) 2015, Wesley Kelly, Cedarville University
 * Company    : N/A
 * @author    : Wesley Kelly
 * @version 1.0
 */

package SubstitutionCipherTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    /*
     * 1. Get input file
     * 2. Scan file for letters, throw out all others
     * 3. Store letter frequencies as relative frequency 
     * 4. Sort letters and frequencies by frequency
     *      -- output to console to verify
     * 5. Display 
     * 6. Allow user to get full arrays?
     */

public class FileParser {

    public FileParser() {
        calibrationFile = null;
        cipherFile = null;
        
        calibrationValues = new double[26];
        cipherValues = new double[26];
        
        for (int i = 0; i < 26; i++) {
            calibrationValues[i] = 0.0;
            cipherValues[i] = 0.0;
        }
        
        calibrationAlphabet = new char[26];
        cipherAlphabet = new char[26];
        
        calibrationData = "";
        ciphertextData = "";
        rawCipherText = "";
        
        hasCalibratedBefore = false;
    }
    
        //File used to calibrate (regular text)
    private File calibrationFile;
        //File to be deciphered (substitution-cipher text)
    private File cipherFile;
        //Array where the relative frequencies are stored for the cal file
    private double[] calibrationValues;
        //Array where the relative frequencies are stored for the cipher file
    private double[] cipherValues;
        //Arrays where the ordered alphabets are stored (ordered by rel freq)
    private char[] calibrationAlphabet;
    private char[] cipherAlphabet;
        //Data that will be displayed on screen
    private String calibrationData;
    private String ciphertextData;
    private String rawCipherText;
    
    private boolean hasCalibratedBefore;
    
    public void setCalibrationFile (File newCalibrationFile) {
        calibrationFile = newCalibrationFile;
    }
    
    public File getCalibrationFile () {
        return calibrationFile;
    }
    
    public void setCipherFile (File newCipherFile) {
        cipherFile = newCipherFile;
    }
    
    public File getCipherFile () {
        return cipherFile;
    }
    
    private void setCalibrationData (String calData) {
        calibrationData = calData;
    }
    
    public String getCalibrationData () {
        return calibrationData;
    }
    
    private void setCiphertextData (String cipherData) {
        ciphertextData = cipherData;
    }
    
    public String getCiphertextData () {
        return ciphertextData;
    }
    
    public String getRawCiphertext() {
        return rawCipherText;
    }
    
    public boolean hasCalibratedBefore() {
        return hasCalibratedBefore;
    }
    
    public boolean parseAndCalibrateCalFile () {
        boolean finishedSuccessfully = false;
        if (calibrationFile != null) {
            try {
                Scanner line = new Scanner(calibrationFile);
                    //count total characters for relative freq division
                int countTotalChars = 0;
                
                while (line.hasNext()) {
                    String nextLine = line.next();
                    for (int i = 0; i < nextLine.length(); i++) {
                        if (Character.isLetter(nextLine.charAt(i))) {
                            countTotalChars++;
                            calibrationValues[Character.toUpperCase(nextLine.charAt(i)) - 'A']++;
                        }
                    }
                }
                String calTextFieldAppend = new String();
                String nbsp = System.getProperty("line.separator");
                
                sortyByRelativeFrequency();
                
                calTextFieldAppend = "";
                
                for (int i = 0; i < 26; i++) {
                    calibrationValues[i] = calibrationValues[i] / countTotalChars;
                    calTextFieldAppend += (calibrationAlphabet[i] + ": " + String.format("%.4f",calibrationValues[i]) + nbsp);
                }
                
                setCalibrationData(calTextFieldAppend);
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found: " + ex.getMessage());
            }
            finishedSuccessfully = true;
        }
        
        return finishedSuccessfully;
    }
    
    public boolean parseAndCalibrateCipherFile () {
        boolean finishedSuccessfully = false;
        if (cipherFile != null) {
            try {
                Scanner line = new Scanner(cipherFile);
                    //count total characters for relative freq division
                int countTotalChars = 0;
                
                rawCipherText = "";
                while (line.hasNext()) {
                    String nextLine = line.next();
                    for (int i = 0; i < nextLine.length(); i++) {
                        if (Character.isLetter(nextLine.charAt(i))) {
                            countTotalChars++;
                            rawCipherText += nextLine.charAt(i);
                            cipherValues[Character.toUpperCase(nextLine.charAt(i)) - 'A']++;
                        }
                    }
                }
                
                String ciphertextFieldAppend = new String();
                String nbsp = System.getProperty("line.separator");
                
                sortyByRelativeFrequency();
                
                ciphertextFieldAppend = "";
                
                for (int i = 0; i < 26; i++) {
                    cipherValues[i] = cipherValues[i] / countTotalChars;
                    ciphertextFieldAppend += (cipherAlphabet[i] + ": " + String.format("%.4f",cipherValues[i]) + nbsp);
                }
                
                setCiphertextData(ciphertextFieldAppend);
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found: " + ex.getMessage());
            }
            hasCalibratedBefore = true;
            finishedSuccessfully = true;
        }
        return finishedSuccessfully;
    }
    
    private void initAlphabets() {
        for (int i = 0; i < 26; i++) {
            calibrationAlphabet[i] = (char)('A' + i);
            cipherAlphabet[i] = (char)('A' + i);
        }
    }
    
    private void sortyByRelativeFrequency() {
        double tempDoub;
        char tempChar;
        
        initAlphabets();
        
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (calibrationValues[j] > calibrationValues[i]) {
                    
                    tempDoub = calibrationValues[i];
                    calibrationValues[i] = calibrationValues[j];
                    calibrationValues[j] = tempDoub;
                    
                    tempChar = calibrationAlphabet[i];
                    calibrationAlphabet[i] = calibrationAlphabet[j];
                    calibrationAlphabet[j] = tempChar;
                }
            }
        }
        
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (cipherValues[j] > cipherValues[i]) {
                    
                    tempDoub = cipherValues[i];
                    cipherValues[i] = cipherValues[j];
                    cipherValues[j] = tempDoub;
                    
                    tempChar = cipherAlphabet[i];
                    cipherAlphabet[i] = cipherAlphabet[j];
                    cipherAlphabet[j] = tempChar;
                }
            }
        }
    }
}