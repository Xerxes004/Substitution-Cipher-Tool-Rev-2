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
    
    /**
     * Sets the calibration file (non-cipher text)
     * @param newCalibrationFile the non-cipher file to be used as calibration
     */
    public void setCalibrationFile (File newCalibrationFile) {
        calibrationFile = newCalibrationFile;
    }
    /**
     * Gets the calibration file (non-cipher text)
     * @return the non-cipher file used as calibration
     */
    public File getCalibrationFile () {
        return calibrationFile;
    }
    /**
     * Sets the cipher file (substitution cipher-text)
     * @param newCipherFile the cipher-text file to be deciphered
     */
    public void setCipherFile (File newCipherFile) {
        cipherFile = newCipherFile;
    }
    /**
     * Gets the cipher file (substitution cipher-text)
     * @return the cipher-text file
     */
    public File getCipherFile () {
        return cipherFile;
    }
    /**
     * Sets the calibration data
     * @param calData data from the Calibration File
     */
    private void setCalibrationData (String calData) {
        calibrationData = calData;
    }
    /**
     * Gets the parsed data of the calibration file
     * @return data from the Calibration file
     */
    public String getCalibrationData () {
        return calibrationData;
    }
    /**
     * Sets the ciphertext data
     * @param cipherData 
     */
    private void setCiphertextData (String cipherData) {
        ciphertextData = cipherData;
    }
    /**
     * Gets the calibrated ciphertext data
     * @return calibrated ciphertext data
     */
    public String getCiphertextCalibrationData () {
        return ciphertextData;
    }
    /**
     * Gets the raw ciphertext input
     * @return the raw ciphertext input
     */
    public String getRawCiphertext() {
        return rawCipherText;
    }
    /**
     * Parses, calibrates, sorts, and stores the calibration (plain-text) file. 
     * @return whether or not the calibration was successful
     */
    public boolean parseAndCalibratePlaintextFile() {
        
        boolean finishedSuccessfully = false;
            //if a file is selected
        if (calibrationFile != null) {
            try {
                    //make a new scanner with the calibration file selected
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
                
                String newLine = System.getProperty("line.separator");
                    //sort the arrays
                sortAllArraysByRelFreq();
                
                String calTextFieldAppend = "";
                    
                for (int i = 0; i < 26; i++) {
                        //store relative frequencies rather than counts
                    calibrationValues[i] = calibrationValues[i] / countTotalChars;
                        //parse calibration data
                    calTextFieldAppend += (calibrationAlphabet[i] + ": " + String.format("%.4f",calibrationValues[i]) + newLine);
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
    /**
     * Parses, calibrates, sorts, and stores the cipher (substitution cipher-text) file. 
     * @return whether or not the calibration was successful
     */
    public boolean parseAndCalibrateCipherFile () {
        
        boolean finishedSuccessfully = false;
            //if a file is selected
        if (cipherFile != null) {
            try {
                Scanner line = new Scanner(cipherFile);
                    //count total characters for relative freq division
                int countTotalChars = 0;
                
                rawCipherText = "";
                while (line.hasNext()) {
                    String nextLine = line.nextLine();
                    for (int i = 0; i < nextLine.length(); i++) {
                        if (Character.isLetter(nextLine.charAt(i))) {
                            countTotalChars++;
                            rawCipherText += nextLine.charAt(i);
                            cipherValues[Character.toUpperCase(nextLine.charAt(i)) - 'A']++;
                        }
                        if (Character.isWhitespace(nextLine.charAt(i))) {
                            rawCipherText += ' ';
                        }
                    }
                }
                
                String newLine = System.getProperty("line.separator");
                    //Sort the arrays
                sortAllArraysByRelFreq();
                
                String ciphertextFieldAppend = "";
                    
                for (int i = 0; i < 26; i++) {
                        //store relative frequencies rather than counts
                    cipherValues[i] = cipherValues[i] / countTotalChars;
                        //parse cipher calibration data
                    ciphertextFieldAppend += (cipherAlphabet[i] + ": " + String.format("%.4f",cipherValues[i]) + newLine);
                }
                
                setCiphertextData(ciphertextFieldAppend);
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found: " + ex.getMessage());
            }
            finishedSuccessfully = true;
        }
        return finishedSuccessfully;
    }
    /**
     * Resets both alphabets
     */
    private void initAlphabets() {
        for (int i = 0; i < 26; i++) {
            calibrationAlphabet[i] = (char)('A' + i);
            cipherAlphabet[i] = (char)('A' + i);
        }
    }
    /**
     * Sorts all calibration data and alphabets by relative frequency
     */
    private void sortAllArraysByRelFreq() {
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