/**
 * Title      : Cipher File Parser
 * Description: An input .txt "cipher" file is input to the system, and
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

public class CalibrationFileParser {
    
    public CalibrationFileParser() {
        calibrationFile = null;
        calibrationValues = new double[26];
        
        for (int i = 0; i < 26; i++) {
            calibrationValues[i] = 0.0;
        }
        
        calibrationAlphabet = new char[26];
        
        calibrationData = "";
    }
    
        //File used to calibrate (regular text)
    private File calibrationFile;
        //Array where the relative frequencies are stored for the cal file
    private double[] calibrationValues;
    private char[] calibrationAlphabet;
        //Data that will be displayed on screen
    private String calibrationData;
    
    /**
     * Returns the calibration alphabet stored internally
     * @return 
     */
    public char[] getCalibrationAlphabet() throws NullPointerException {
        if (calibrationAlphabet == null) {
            throw new NullPointerException("No calibration alphabet found");
        }
        return calibrationAlphabet;
    }
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
                         if (Character.toUpperCase(nextLine.charAt(i)) <= 'Z' && Character.toUpperCase(nextLine.charAt(i)) >= 'A') {
                            countTotalChars++;
                            calibrationValues[Character.toUpperCase(nextLine.charAt(i)) - 'A']++;
                        }
                    }
                }
                
                String newLine = System.getProperty("line.separator");
                    //sort the arrays
                sortCalibrationDataByRelFreq();
                
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
    
    private void initAlphabet() {
        for (int i = 0; i < 26; i++) {
            calibrationAlphabet[i] = (char)('A' + i);
        }
    }
    /**
     * Sorts all calibration data and alphabets by relative frequency
     */
    private void sortCalibrationDataByRelFreq() {
        double tempDoub;
        char tempChar;
        
        initAlphabet();
        
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
    }
}
