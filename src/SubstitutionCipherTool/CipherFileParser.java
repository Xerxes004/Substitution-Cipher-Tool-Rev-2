/**
 * Title : Cipher File Parser Description: An input .txt "cipher" file is input
 * to the system, and its letter frequencies are analyzed and made available to
 * the user. Copyright : Copyright (c) 2015, Wesley Kelly, Cedarville University
 * Company : N/A
 *
 * @author : Wesley Kelly
 * @version 1.0
 */
package SubstitutionCipherTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CipherFileParser {

    private File cipherFile;
    private double[] cipherValues;
    private char[] cipherAlphabet;
    private String ciphertextData;
    private String rawCipherText;

    public CipherFileParser() {
        this.cipherFile = null;
        this.cipherValues = new double[26];
        for (int i = 0; i < 26; i++) {
            this.cipherValues[i] = 0.0D;
        }
        this.cipherAlphabet = new char[26];

        this.ciphertextData = "";
        this.rawCipherText = "";
    }

    public void setCipherFile(File newCipherFile) {
        this.cipherFile = newCipherFile;
    }

    public File getCipherFile() {
        return this.cipherFile;
    }

    private void setCiphertextData(String cipherData) {
        this.ciphertextData = cipherData;
    }

    public String getCiphertextCalibrationData() {
        return this.ciphertextData;
    }

    public String getRawCiphertext() {
        return this.rawCipherText;
    }

    public boolean parseAndCalibrateCipherFile() {
        boolean finishedSuccessfully = false;
        if (this.cipherFile != null) {
            try {
                Scanner line = new Scanner(this.cipherFile);

                int countTotalChars = 0;

                this.rawCipherText = "";
                while (line.hasNext()) {
                    String nextLine = line.nextLine();
                    for (int i = 0; i < nextLine.length(); i++) {
                        if (Character.isLetter(nextLine.charAt(i))) {
                            countTotalChars++;
                            this.rawCipherText += nextLine.charAt(i);
                            this.cipherValues[(Character.toUpperCase(nextLine.charAt(i)) - 'A')] += 1.0D;
                        }
                        if (Character.isWhitespace(nextLine.charAt(i))) {
                            this.rawCipherText += ' ';
                        }
                    }
                }
                String newLine = System.getProperty("line.separator");

                sortCalibrationDataByRelFreq();

                String ciphertextFieldAppend = "";
                for (int i = 0; i < 26; i++) {
                    this.cipherValues[i] /= countTotalChars;

                    ciphertextFieldAppend = ciphertextFieldAppend + this.cipherAlphabet[i] + ": " + String.format("%.4f", new Object[]{Double.valueOf(this.cipherValues[i])}) + newLine;
                }
                setCiphertextData(ciphertextFieldAppend);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found: " + ex.getMessage());
            }
            finishedSuccessfully = true;
        }
        return finishedSuccessfully;
    }

    private void initAlphabet() {
        for (int i = 0; i < 26; i++) {
            this.cipherAlphabet[i] = ((char) (65 + i));
        }
    }

    private void sortCalibrationDataByRelFreq() {
        initAlphabet();
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (this.cipherValues[j] > this.cipherValues[i]) {
                    double tempDoub = this.cipherValues[i];
                    this.cipherValues[i] = this.cipherValues[j];
                    this.cipherValues[j] = tempDoub;

                    char tempChar = this.cipherAlphabet[i];
                    this.cipherAlphabet[i] = this.cipherAlphabet[j];
                    this.cipherAlphabet[j] = tempChar;
                }
            }
        }
    }

    public void swapLettersInCipher(char a, char b) {
        if ((this.ciphertextData.toCharArray().length > 0) && (a != b)) {
            a = Character.toUpperCase(a);
            b = Character.toUpperCase(b);

            double aTempFreq = 0.0D;
            double bTempFreq = 0.0D;

            int aTempLoc = 0;
            int bTempLoc = 0;
            for (int i = 0; i < 26; i++) {
                if (this.cipherAlphabet[i] == a) {
                    aTempLoc = i;
                    aTempFreq = this.cipherValues[i];
                }
                if (this.cipherAlphabet[i] == b) {
                    bTempLoc = i;
                    bTempFreq = this.cipherValues[i];
                }
            }
            this.cipherAlphabet[aTempLoc] = b;
            this.cipherAlphabet[bTempLoc] = a;

            this.cipherValues[aTempLoc] = bTempFreq;
            this.cipherValues[bTempLoc] = aTempFreq;

            String newLine = System.getProperty("line.separator");
            String cipherTextFieldAppend = "";
            for (int i = 0; i < 26; i++) {
                cipherTextFieldAppend = cipherTextFieldAppend + this.cipherAlphabet[i] + ": " + String.format("%.4f", new Object[]{Double.valueOf(this.cipherValues[i])}) + newLine;
            }
            this.ciphertextData = cipherTextFieldAppend;
        }
    }

}
