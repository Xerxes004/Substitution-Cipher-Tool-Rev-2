/**
 * Title      : Cipher File Parser
 * Description: An input .txt "cipher" file is input to the system, and
 *              its letter frequencies are analyzed and made available to the
 *              user.
 * Copyright  : Copyright (c) 2015, Wesley Kelly, Cedarville University
 * Company    : N/A
 * @author    : Wesley Kelly, James Von Eiff
 * @version 1.0
 */

package SubstitutionCipherTool;
import java.io.FileNotFoundException;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainGUIWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainGUIWindow
     */
    public MainGUIWindow() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.pack();
        this.setTitle("Substitution Cipher Tool - Wesley Kelly, James Von Eiff");
        
        FileSelector.setDialogTitle("Select File");
        
        
        cipherParser = new CipherFileParser();
        calibrationParser = new CalibrationFileParser();
        decipherer = new Decipherer(calibrationParser, cipherParser);
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("*.txt", "txt", "TXT");
        FileSelector.setFileFilter(textFilter);
    }
    
    private final CalibrationFileParser calibrationParser;
    private final CipherFileParser cipherParser;
    private final Decipherer decipherer;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileSelector = new javax.swing.JFileChooser();
        WarningDialog = new javax.swing.JDialog();
        WarningDialogPanel = new javax.swing.JPanel();
        WarningIcon = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        RecalibrateButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenu3 = new javax.swing.JMenu();
        MainWindowPane = new javax.swing.JPanel();
        CalibrationFileSelectorLabel = new javax.swing.JLabel();
        SelectCalibrationFileButton = new javax.swing.JButton();
        CipherFileSelectorLabel = new javax.swing.JLabel();
        SelectCipherFileButton = new javax.swing.JButton();
        CalibrationFileBrowserLabel = new javax.swing.JLabel();
        CipherFileBrowserLabel = new javax.swing.JLabel();
        CalFreqScrollPane = new javax.swing.JScrollPane();
        CalibrationDataFieldTextArea = new javax.swing.JTextArea();
        CipherFreqScrollPane = new javax.swing.JScrollPane();
        CipherDataFieldTextArea = new javax.swing.JTextArea();
        SwapButton = new javax.swing.JButton();
        SwapLabel = new javax.swing.JLabel();
        withLabel = new javax.swing.JLabel();
        RawCipherScrollPane = new javax.swing.JScrollPane();
        RawCipherTextArea = new javax.swing.JTextArea();
        CurrentGuessScrollPane = new javax.swing.JScrollPane();
        CurrentGuessTextArea = new javax.swing.JTextArea();
        CipherFreqLetterSwapperLabel = new javax.swing.JLabel();
        firstLetterToSwap = new javax.swing.JTextField();
        secondLetterToSwap = new javax.swing.JTextField();
        MapCipherButton = new javax.swing.JButton();
        SetGuessToCipherButton = new javax.swing.JButton();
        HelpTextScrollPane = new javax.swing.JScrollPane();
        HelpTextTextArea = new javax.swing.JTextArea();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        SaveCurrentGuess = new javax.swing.JMenuItem();
        ExitProgramMenuItem = new javax.swing.JMenuItem();

        FileSelector.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        FileSelector.setCurrentDirectory(new java.io.File("/"));

        WarningDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        WarningDialog.setForeground(new java.awt.Color(255, 255, 255));
        WarningDialog.setMinimumSize(new java.awt.Dimension(203, 144));
        WarningDialog.setResizable(false);

        WarningDialogPanel.setBackground(new java.awt.Color(255, 255, 255));
        WarningDialogPanel.setMaximumSize(new java.awt.Dimension(203, 144));
        WarningDialogPanel.setMinimumSize(new java.awt.Dimension(203, 144));

        WarningIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SubstitutionCipherTool/genericwarning.jpeg"))); // NOI18N

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        RecalibrateButton.setText("Accept");
        RecalibrateButton.setDefaultCapable(false);
        RecalibrateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecalibrateButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("This will overwrite your current guess.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Warning");

        javax.swing.GroupLayout WarningDialogPanelLayout = new javax.swing.GroupLayout(WarningDialogPanel);
        WarningDialogPanel.setLayout(WarningDialogPanelLayout);
        WarningDialogPanelLayout.setHorizontalGroup(
            WarningDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WarningDialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WarningDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WarningDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addGroup(WarningDialogPanelLayout.createSequentialGroup()
                            .addComponent(RecalibrateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(WarningDialogPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(76, 76, 76)
                        .addComponent(WarningIcon)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WarningDialogPanelLayout.setVerticalGroup(
            WarningDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WarningDialogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WarningDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(WarningIcon)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addGroup(WarningDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecalibrateButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout WarningDialogLayout = new javax.swing.GroupLayout(WarningDialog.getContentPane());
        WarningDialog.getContentPane().setLayout(WarningDialogLayout);
        WarningDialogLayout.setHorizontalGroup(
            WarningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WarningDialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        WarningDialogLayout.setVerticalGroup(
            WarningDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WarningDialogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Substitution Cipher Tool - Wesley Kelly, James Von Eiff");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1, 1));
        setResizable(false);

        MainWindowPane.setName("Substitution Cipher Cracker"); // NOI18N

        CalibrationFileSelectorLabel.setBackground(new java.awt.Color(255, 255, 255));
        CalibrationFileSelectorLabel.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        CalibrationFileSelectorLabel.setText(" ");
        CalibrationFileSelectorLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CalibrationFileSelectorLabel.setOpaque(true);

        SelectCalibrationFileButton.setText("Select Calibration File...");
        SelectCalibrationFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectCalibrationFileButtonActionPerformed(evt);
            }
        });

        CipherFileSelectorLabel.setBackground(new java.awt.Color(255, 255, 255));
        CipherFileSelectorLabel.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        CipherFileSelectorLabel.setText("  ");
        CipherFileSelectorLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CipherFileSelectorLabel.setOpaque(true);

        SelectCipherFileButton.setText("Select Cipher File...");
        SelectCipherFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectCipherFileButtonActionPerformed(evt);
            }
        });

        CalibrationFileBrowserLabel.setText("Calibration File");

        CipherFileBrowserLabel.setText("Cipher File");

        CalFreqScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Calibration Freqs", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        CalFreqScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        CalFreqScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        CalFreqScrollPane.setMaximumSize(new java.awt.Dimension(90, 500));
        CalFreqScrollPane.setMinimumSize(new java.awt.Dimension(90, 500));
        CalFreqScrollPane.setPreferredSize(new java.awt.Dimension(90, 500));
        CalFreqScrollPane.setRequestFocusEnabled(false);

        CalibrationDataFieldTextArea.setEditable(false);
        CalibrationDataFieldTextArea.setBackground(new java.awt.Color(250, 250, 250));
        CalibrationDataFieldTextArea.setColumns(20);
        CalibrationDataFieldTextArea.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        CalibrationDataFieldTextArea.setRows(4);
        CalibrationDataFieldTextArea.setTabSize(4);
        CalibrationDataFieldTextArea.setAutoscrolls(false);
        CalibrationDataFieldTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CalibrationDataFieldTextArea.setMaximumSize(new java.awt.Dimension(90, 500));
        CalibrationDataFieldTextArea.setMinimumSize(new java.awt.Dimension(90, 500));
        CalFreqScrollPane.setViewportView(CalibrationDataFieldTextArea);

        CipherFreqScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Cipher Freqs", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        CipherFreqScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        CipherFreqScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        CipherFreqScrollPane.setMaximumSize(new java.awt.Dimension(90, 500));
        CipherFreqScrollPane.setMinimumSize(new java.awt.Dimension(90, 500));
        CipherFreqScrollPane.setPreferredSize(new java.awt.Dimension(90, 500));

        CipherDataFieldTextArea.setEditable(false);
        CipherDataFieldTextArea.setBackground(new java.awt.Color(250, 250, 250));
        CipherDataFieldTextArea.setColumns(20);
        CipherDataFieldTextArea.setFont(new java.awt.Font("Courier New", 0, 16)); // NOI18N
        CipherDataFieldTextArea.setRows(5);
        CipherDataFieldTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        CipherDataFieldTextArea.setMaximumSize(new java.awt.Dimension(90, 500));
        CipherDataFieldTextArea.setMinimumSize(new java.awt.Dimension(90, 500));
        CipherFreqScrollPane.setViewportView(CipherDataFieldTextArea);

        SwapButton.setText("Swap");
        SwapButton.setToolTipText("");
        SwapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwapButtonActionPerformed(evt);
            }
        });

        SwapLabel.setText("Swap");

        withLabel.setText("with");

        RawCipherScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Cipher File Raw Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        RawCipherScrollPane.setMaximumSize(new java.awt.Dimension(500, 250));
        RawCipherScrollPane.setMinimumSize(new java.awt.Dimension(500, 250));
        RawCipherScrollPane.setPreferredSize(new java.awt.Dimension(500, 250));

        RawCipherTextArea.setBackground(new java.awt.Color(250, 250, 250));
        RawCipherTextArea.setColumns(20);
        RawCipherTextArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        RawCipherTextArea.setLineWrap(true);
        RawCipherTextArea.setRows(5);
        RawCipherTextArea.setWrapStyleWord(true);
        RawCipherTextArea.setMaximumSize(new java.awt.Dimension(500, 500));
        RawCipherTextArea.setMinimumSize(new java.awt.Dimension(1, 1));
        RawCipherTextArea.setPreferredSize(null);
        RawCipherScrollPane.setViewportView(RawCipherTextArea);

        CurrentGuessScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Current Guess", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        CurrentGuessScrollPane.setMaximumSize(new java.awt.Dimension(500, 250));
        CurrentGuessScrollPane.setMinimumSize(new java.awt.Dimension(500, 250));
        CurrentGuessScrollPane.setPreferredSize(new java.awt.Dimension(500, 250));

        CurrentGuessTextArea.setBackground(new java.awt.Color(250, 250, 250));
        CurrentGuessTextArea.setColumns(20);
        CurrentGuessTextArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        CurrentGuessTextArea.setLineWrap(true);
        CurrentGuessTextArea.setRows(5);
        CurrentGuessTextArea.setWrapStyleWord(true);
        CurrentGuessTextArea.setMaximumSize(new java.awt.Dimension(500, 250));
        CurrentGuessTextArea.setMinimumSize(new java.awt.Dimension(1, 1));
        CurrentGuessTextArea.setPreferredSize(null);
        CurrentGuessScrollPane.setViewportView(CurrentGuessTextArea);

        CipherFreqLetterSwapperLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CipherFreqLetterSwapperLabel.setText("Cipher Freq Letter Swapper");

        MapCipherButton.setText("Map Cipher");
        MapCipherButton.setToolTipText("Maps the Calibration Frequency straight across to the Cipher Frequency");
        MapCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapCipherButtonActionPerformed(evt);
            }
        });

        SetGuessToCipherButton.setText("Set Guess to Cipher Text");
        SetGuessToCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetGuessToCipherButtonActionPerformed(evt);
            }
        });

        HelpTextScrollPane.setBorder(null);

        HelpTextTextArea.setEditable(false);
        HelpTextTextArea.setBackground(new java.awt.Color(240, 240, 240));
        HelpTextTextArea.setColumns(20);
        HelpTextTextArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        HelpTextTextArea.setLineWrap(true);
        HelpTextTextArea.setRows(5);
        HelpTextTextArea.setText("After calibrating both files, use the Cipher Letter Swapper to swap letters in the \"Cipher Freqs\" box. \n\nUse the \"Map Cipher\" button to map Calibration Freqs letters to the Cipher Freqs letters.");
        HelpTextTextArea.setWrapStyleWord(true);
        HelpTextScrollPane.setViewportView(HelpTextTextArea);

        javax.swing.GroupLayout MainWindowPaneLayout = new javax.swing.GroupLayout(MainWindowPane);
        MainWindowPane.setLayout(MainWindowPaneLayout);
        MainWindowPaneLayout.setHorizontalGroup(
            MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainWindowPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainWindowPaneLayout.createSequentialGroup()
                        .addComponent(CalFreqScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CipherFreqScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MainWindowPaneLayout.createSequentialGroup()
                                .addComponent(SwapLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstLetterToSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(withLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondLetterToSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SetGuessToCipherButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MapCipherButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SwapButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CipherFreqLetterSwapperLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HelpTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RawCipherScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CurrentGuessScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(MainWindowPaneLayout.createSequentialGroup()
                        .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CalibrationFileBrowserLabel)
                            .addComponent(CipherFileBrowserLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalibrationFileSelectorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CipherFileSelectorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SelectCalibrationFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectCipherFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        MainWindowPaneLayout.setVerticalGroup(
            MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainWindowPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalibrationFileSelectorLabel)
                    .addComponent(CalibrationFileBrowserLabel)
                    .addComponent(SelectCalibrationFileButton))
                .addGap(3, 3, 3)
                .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectCipherFileButton)
                    .addComponent(CipherFileSelectorLabel)
                    .addComponent(CipherFileBrowserLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CipherFreqScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainWindowPaneLayout.createSequentialGroup()
                        .addComponent(RawCipherScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrentGuessScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CalFreqScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MainWindowPaneLayout.createSequentialGroup()
                        .addComponent(CipherFreqLetterSwapperLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainWindowPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SwapLabel)
                            .addComponent(firstLetterToSwap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(withLabel)
                            .addComponent(secondLetterToSwap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SwapButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MapCipherButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SetGuessToCipherButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HelpTextScrollPane)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FileMenu.setText("File");

        SaveCurrentGuess.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveCurrentGuess.setText("Save Current Guess...");
        SaveCurrentGuess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveCurrentGuessActionPerformed(evt);
            }
        });
        FileMenu.add(SaveCurrentGuess);

        ExitProgramMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ExitProgramMenuItem.setText("Exit Program");
        ExitProgramMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitProgramMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitProgramMenuItem);

        MenuBar.add(FileMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainWindowPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainWindowPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void RecalibrateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecalibrateButtonActionPerformed
        CurrentGuessTextArea.setText(cipherParser.getRawCiphertext());
        CurrentGuessTextArea.setCaretPosition(0);
        WarningDialog.dispose();
        MainWindowPane.repaint();
    }//GEN-LAST:event_RecalibrateButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        WarningDialog.dispose();
        MainWindowPane.repaint();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SetGuessToCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetGuessToCipherButtonActionPerformed
        WarningDialog.setVisible(true);
        WarningDialog.setLocationRelativeTo(null);
        WarningDialog.pack();
        MainWindowPane.repaint();
    }//GEN-LAST:event_SetGuessToCipherButtonActionPerformed

    private void SwapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SwapButtonActionPerformed
        char firstChar = firstLetterToSwap.getText().toCharArray()[0];
        char secondChar = secondLetterToSwap.getText().toCharArray()[0];
        
        firstLetterToSwap.setText(Character.toString(Character.toUpperCase(firstChar)));
        secondLetterToSwap.setText(Character.toString(Character.toUpperCase(secondChar)));
        
        if (Character.isLetter(firstChar) && Character.isLetter(secondChar)) {
            cipherParser.swapLettersInCipher(firstChar, secondChar);
            CipherDataFieldTextArea.setText(cipherParser.getCiphertextCalibrationData());
        }
        MainWindowPane.repaint();
    }//GEN-LAST:event_SwapButtonActionPerformed

    private void SelectCipherFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectCipherFileButtonActionPerformed
        //if we select the cipher file (select the "open" option or double click)
        if (FileSelector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            cipherParser.setCipherFile(FileSelector.getSelectedFile());
            CipherFileSelectorLabel.setText(cipherParser.getCipherFile().getName());
            
            if(cipherParser.parseAndCalibrateCipherFile()) {
                CipherDataFieldTextArea.setText(cipherParser.getCiphertextCalibrationData());
                RawCipherTextArea.setText(cipherParser.getRawCiphertext());
                RawCipherTextArea.setCaretPosition(0);
            }
        }
        MainWindowPane.repaint();
    }//GEN-LAST:event_SelectCipherFileButtonActionPerformed

    private void SelectCalibrationFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectCalibrationFileButtonActionPerformed
        //if we select the cipher file (select the "open" option or double click)
        if (FileSelector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            calibrationParser.setCalibrationFile(FileSelector.getSelectedFile());
            CalibrationFileSelectorLabel.setText(calibrationParser.getCalibrationFile().getName());
            
            if(calibrationParser.parseAndCalibratePlaintextFile()) {
                CalibrationDataFieldTextArea.setText(calibrationParser.getCalibrationData());
                CalibrationDataFieldTextArea.setCaretPosition(0);
            }
        }
        MainWindowPane.repaint();
    }//GEN-LAST:event_SelectCalibrationFileButtonActionPerformed

    private void SaveCurrentGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveCurrentGuessActionPerformed
        /*
        Open file browser
        Name new file
        Save new file with current guess data
        */
        JFileChooser saveFile = new JFileChooser(".");
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("*.txt", "txt", "TXT");
        saveFile.setFileFilter(textFilter);
        saveFile.showSaveDialog(null);
        
        try {
            java.io.PrintWriter guessSaver = new java.io.PrintWriter(saveFile.getSelectedFile());
            guessSaver.printf(decipherer.getCurrentGuess());
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        }
    }//GEN-LAST:event_SaveCurrentGuessActionPerformed

    private void ExitProgramMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitProgramMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitProgramMenuItemActionPerformed

    private void MapCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapCipherButtonActionPerformed
        
    }//GEN-LAST:event_MapCipherButtonActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUIWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUIWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUIWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUIWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUIWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CalFreqScrollPane;
    private javax.swing.JTextArea CalibrationDataFieldTextArea;
    private javax.swing.JLabel CalibrationFileBrowserLabel;
    private javax.swing.JLabel CalibrationFileSelectorLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextArea CipherDataFieldTextArea;
    private javax.swing.JLabel CipherFileBrowserLabel;
    private javax.swing.JLabel CipherFileSelectorLabel;
    private javax.swing.JLabel CipherFreqLetterSwapperLabel;
    private javax.swing.JScrollPane CipherFreqScrollPane;
    private javax.swing.JScrollPane CurrentGuessScrollPane;
    private javax.swing.JTextArea CurrentGuessTextArea;
    private javax.swing.JMenuItem ExitProgramMenuItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JFileChooser FileSelector;
    private javax.swing.JScrollPane HelpTextScrollPane;
    private javax.swing.JTextArea HelpTextTextArea;
    private javax.swing.JPanel MainWindowPane;
    private javax.swing.JButton MapCipherButton;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JScrollPane RawCipherScrollPane;
    private javax.swing.JTextArea RawCipherTextArea;
    private javax.swing.JButton RecalibrateButton;
    private javax.swing.JMenuItem SaveCurrentGuess;
    private javax.swing.JButton SelectCalibrationFileButton;
    private javax.swing.JButton SelectCipherFileButton;
    private javax.swing.JButton SetGuessToCipherButton;
    private javax.swing.JButton SwapButton;
    private javax.swing.JLabel SwapLabel;
    private javax.swing.JDialog WarningDialog;
    private javax.swing.JPanel WarningDialogPanel;
    private javax.swing.JLabel WarningIcon;
    private javax.swing.JTextField firstLetterToSwap;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JTextField secondLetterToSwap;
    private javax.swing.JLabel withLabel;
    // End of variables declaration//GEN-END:variables
}
