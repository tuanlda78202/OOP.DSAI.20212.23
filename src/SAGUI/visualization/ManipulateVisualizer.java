// author @tuanlda78202

package SAGUI.visualization;

import SAGUI.data.Siri;
import SAGUI.data.ValidData;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ManipulateVisualizer {

    ValidData validator = new ValidData();
    Siri helpers = new Siri();
    //private ManipulateSortingProcess manipulateSortingProcess;

    GraphVisualizer canvas;

    private Random r = new Random();
    private int current;
    private int check;
    private int length;
    private int[] array;
    private boolean isSorting;
    private boolean isPause;
    private boolean isStop;

    private int speed = 50;
    private int compared = 0;
    private int arrayAccessed = 0;
    private int curInputDataOption = 0; // 0 for manual, 1 for random
    private int curAlg = 0; // 0 for bubble, 1 for heap, 2 for shell
    private String[] sortingProcessListMsg = {"Bubble sort", "Heap sort", "Shell sort"};
    private String sortingProcessMsg = sortingProcessListMsg[curAlg];

    private final String ABOUT_MESSAGE = "Sorting Visualizer\n\n"
            + "This program is built to help you visualize some of sorting algorithms namely: Bubble sort, Heap sort, Shell sort.\n\n"
            + "Thank you for using our program \u2665\n\n"
            + "(c) Copyright by OOP.DSAI.20212.Team23";
    private final String HELP_INSTRUCTION_MESSAGE = "Here is the instruction of program:\n"
            + "1. Step 1: Generate Data.\n"
            + "In Data pane, you can generate the data by two ways:\n"
            + "- Random: You should input an positive integer for array length.\n"
            + "- Manual: You should input an positive integer array.\n"
            + "After input, choose Generate button\n"
            + "2. Step 2: Choose sorting algorithm\n"
            + "In Control pane, you can choose sorting algorithm in the combo box 'Choose algorithm'.\n"
            + "3. Step 3: Manipulate sorting process\n"
            + "You can manipulate the sorting process with start, pause, stop, resume actions.\n"
            + "You also can change the speed of process by slide a slider of Delay.\n\n";

    private static final int MAX_ARRAY_LENGTH = 300;
    private String displayTextArea = "[\n \n]";

    // GRAPH VARIABLES
    private static final int GRAPH_SIZE = 600;
    private int rectangle_width;

    // ARRAYS
    private String[] genDataOptions = {"Random", "Manual input"};
    private String[] helpGenDataMsg = {
        "You should input a positive integer for array length which have min = 2 and max = 300!",
        "You should input an array with 2-300 elements contains only positive integers that separated by comma and wrapped by square brackets"};
    private String[] algorithmOptions = {"Bubble sort", "Heap sort", "Shell sort"};
    private String[] algorithmListInfo = {"Best Case: O(n)\nWorst Case: O(n^2)\nAverage: O(n^2)",
        "Best Case: O(nlogn)\nWorst Case: O(nlogn)\nAverage: O(nlogn)",
        "Best Case: O(nlogn)\nWorst Case: O(n^2)\nAverage: O(nlogn)"};

    // FRAME
    private JFrame jframe;

    // PANEL
    JPanel genDataPane = new JPanel();
    JPanel controlsPane = new JPanel();

    // LABEL
    JLabel delayLabel = new JLabel("Delay :");
    JLabel speedLabel = new JLabel(speed + " ms");
    public JLabel comparedLabel = new JLabel("Comparisons: " + compared);
    public JLabel arrayAccessedLabel = new JLabel("Array Accessed: " + arrayAccessed);
    JLabel genDataOptionLabel = new JLabel("Choose how to create data");
    JLabel arrayLengthLabel = new JLabel("Array length:");
    JLabel arrayLengthErrorLabel = new JLabel("");
    JLabel algorithmOptionLabel = new JLabel("Choose algorithms");
    JLabel algorithmInfoLabel = new JLabel("Algorithm info");
    public JLabel sortingProcessLabel = new JLabel(sortingProcessMsg);

    // DROP DOWN BOX
    public JComboBox genDataOptionComboBox = new JComboBox(genDataOptions);
    public JComboBox algorithmComboBox = new JComboBox(algorithmOptions);

    // TEXT AREA
    public JTextArea inputArrayArea = new JTextArea(displayTextArea);
    JTextArea algorithmInfoArea = new JTextArea(algorithmListInfo[curAlg]);

    // SCROLL PANE
    public JScrollPane inputArrayScrollPane = new JScrollPane(inputArrayArea);

    // BUTTON
    public JButton btnGenerateArray = new JButton("Generate");
    JButton btnHelpGenerateArray = new JButton("?");

    public JButton btnStartSort = new JButton("Start");
    public JButton btnPauseSort = new JButton("Pause");
    public JButton btnStopSort = new JButton("Stop");
    JButton btnResumeSort = new JButton("Resume");

    JButton btnHelpComparison = new JButton("?");
    JButton btnHelpAccess = new JButton("?");

    JButton btnHelpInstructions = new JButton("Help");
    JButton btnAbout = new JButton("About");

    // TEXT FIELD
    public JTextField arrayLengthInput = new JTextField("50");

    // SLIDER
    JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, speed);

    // BORDER STYLE
    Border loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    public ManipulateVisualizer(int length, int[] array, boolean isSorting, boolean isPause, boolean isStop, int cur, int check) {
        this.length = length;
        this.array = array;
        this.isSorting = isSorting;
        this.isPause = isPause;
        this.isStop = isStop;
        this.current = cur;
        this.check = check;
        rectangle_width = GRAPH_SIZE / length;
    }

//    public ManipulateSortingProcess getManipulateSortingProcess() {
//        return manipulateSortingProcess;
//    }
//
//    public void setManipulateSortingProcess(ManipulateSortingProcess manipulateSortingProcess) {
//        this.manipulateSortingProcess = manipulateSortingProcess;
//    }
    public int getSpeed() {
        return speed;
    }

    public int getCurAlg() {
        return curAlg;
    }

    public int getGraphSize() {
        return GRAPH_SIZE;
    }

    public int getRectangleWidth() {
        return rectangle_width;
    }

    public boolean isIsSorting() {
        return isSorting;
    }

    public void setIsSorting(boolean isSorting) {
        this.isSorting = isSorting;
    }

    public void setRectangleWidth(int width) {
        this.rectangle_width = width;
    }

    public int getCompared() {
        return compared;
    }

    public void setCompared(int _compared) {
        this.compared = _compared;
    }

    public int getArrayAccessed() {
        return arrayAccessed;
    }

    public void setArrayAccessed(int _accessed) {
        this.arrayAccessed = _accessed;
    }

    public String getSortingProcessMsg() {
        return sortingProcessMsg;
    }

    public void setSortingProcessMsg(String _sortingProcessMsg) {
        this.sortingProcessMsg = _sortingProcessMsg;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public boolean isIsPause() {
        return isPause;
    }

    public void setIsPause(boolean isPause) {
        this.isPause = isPause;
    }

    public boolean isIsStop() {
        return isStop;
    }

    public void setIsStop(boolean isStop) {
        this.isStop = isStop;
    }

    public void initialize() {
        //manipulateSortingProcess = new ManipulateSortingProcess(length, array, isSorting, isPause, isStop, curAlg, speed, current, check);
        ActionListener manipulateSortingActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button = e.getActionCommand();
                switch (button) {
                    case "Start": {
                        if (isSorting) {
                            JOptionPane.showMessageDialog(jframe, "The data is already sorted! Let's try with new data.",
                                    "It's sorted!", JOptionPane.PLAIN_MESSAGE, null);
                        } else {
                            // disable data pane
                            genDataOptionComboBox.setEnabled(false);
                            arrayLengthInput.setEnabled(false);
                            inputArrayArea.setEnabled(false);
                            btnGenerateArray.setEnabled(false);

                            // disable algorithm option box
                            algorithmComboBox.setEnabled(false);

                            //data.setSorting(true);
                            isSorting = true;
                            isStop = false;
                            //manipulateSortingProcess.setIsSorting(true);

                            compared = 0;
                            arrayAccessed = 0;

                            btnStartSort.setVisible(false);
                            btnPauseSort.setVisible(true);
                            btnStopSort.setVisible(true);
                        }
                        break;
                    }
                    case "Pause": {
//                        data.setSorting(false);
//                        data.setPause(true);
                        isPause = true;
                        isSorting = false;
                        isStop = false;
                        //manipulateSortingProcess.setIsSorting(false);
                        //manipulateSortingProcess.setIsPause(true);

                        btnPauseSort.setVisible(false);
                        btnStopSort.setVisible(false);
                        btnResumeSort.setVisible(true);
                        break;
                    }
                    case "Stop": {
                        // enable data pane
                        genDataOptionComboBox.setEnabled(true);
                        arrayLengthInput.setEnabled(true);
                        inputArrayArea.setEnabled(true);
                        btnGenerateArray.setEnabled(true);

                        // enable algorithm option box
                        algorithmComboBox.setEnabled(true);

                        //data.setStop(true);
                        isStop = true;
                        //manipulateSortingProcess.reset();
                        //manipulateSortingProcess.reset();

                        // update processing message when stop sort
                        setSortingProcessMsg(sortingProcessListMsg[curAlg]);

                        btnStopSort.setVisible(false);
                        btnPauseSort.setVisible(false);
                        btnStartSort.setVisible(true);
                        break;
                    }
                    case "Resume": {
//                        data.setSorting(true);
//                        data.setPause(false);
                        isSorting = true;
                        isPause = false;
                        isStop = false;
                        //manipulateSortingProcess.setIsSorting(true);
                        //manipulateSortingProcess.setIsPause(false);

                        btnResumeSort.setVisible(false);
                        btnPauseSort.setVisible(true);
                        btnStopSort.setVisible(true);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };

        // FRAME
        jframe = new JFrame();
        jframe.setSize(816, 650);
        jframe.setTitle("Sorting Visualizer");
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.getContentPane().setLayout(null);

        // GENERATE DATA PANE
        genDataPane.setLayout(null);
        genDataPane.setBounds(5, 10, 180, 200);
        genDataPane.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Data"));

        // GENERATE DATA OPTION LABEL
        genDataOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        genDataOptionLabel.setBounds(0, 20, 180, 25);
        genDataPane.add(genDataOptionLabel);

        // DROP DOWN FOR GENERATE DATA OPTIONS
        genDataOptionComboBox.setBounds(25, 45, 120, 25);
        genDataPane.add(genDataOptionComboBox);

        // HELP GENERATE ARRAY BUTTON
        btnHelpGenerateArray.setBounds(150, 45, 20, 25);
        btnHelpGenerateArray.setMargin(new Insets(1, 1, 1, 1));
        genDataPane.add(btnHelpGenerateArray);

        // ARRAY LENGTH LABEL
        arrayLengthLabel.setHorizontalAlignment(JLabel.CENTER);
        arrayLengthLabel.setBounds(0, 105, 100, 25);
        genDataPane.add(arrayLengthLabel);

        // ARRAY LENGTH INPUT TEXT FIELD
        arrayLengthInput.setHorizontalAlignment(JLabel.CENTER);
        arrayLengthInput.setBounds(95, 106, 65, 25);
        genDataPane.add(arrayLengthInput);

        // ARRAY LENGTH ERROR LABEL
        arrayLengthErrorLabel.setHorizontalAlignment(JLabel.CENTER);
        arrayLengthErrorLabel.setBounds(0, 130, 180, 25);
        arrayLengthErrorLabel.setForeground(Color.RED);
        genDataPane.add(arrayLengthErrorLabel);

        // INPUT ARRAY AREA
        inputArrayScrollPane.setBounds(10, 80, 160, 60);
        inputArrayScrollPane.setVisible(false);
        genDataPane.add(inputArrayScrollPane);

        // GENERATE ARRAY BUTTON
        btnGenerateArray.setBounds(40, 155, 100, 25);
        genDataPane.add(btnGenerateArray);

        // TOOLS PANE
        controlsPane.setLayout(null);
        controlsPane.setBounds(5, 210, 180, 390);
        controlsPane.setBorder(BorderFactory.createTitledBorder(loweredEtched, "Controls"));

        // ALGORITHM OPTION LABEL
        algorithmOptionLabel.setHorizontalAlignment(JLabel.CENTER);
        algorithmOptionLabel.setBounds(15, 20, 150, 25);
        controlsPane.add(algorithmOptionLabel);

        // ALGORITHMS DROP DOWN
        algorithmComboBox.setBounds(30, 45, 120, 25);
        controlsPane.add(algorithmComboBox);

        // START SORT BUTTON
        btnStartSort.setBounds(40, 80, 100, 25);
        btnStartSort.addActionListener(manipulateSortingActionListener);
        controlsPane.add(btnStartSort);

        // PAUSE SORT BUTTON
        btnPauseSort.setBounds(15, 80, 70, 25);
        btnPauseSort.addActionListener(manipulateSortingActionListener);
        btnPauseSort.setVisible(false);
        controlsPane.add(btnPauseSort);

        // STOP SORT BUTTON
        btnStopSort.setBounds(95, 80, 70, 25);
        btnStopSort.addActionListener(manipulateSortingActionListener);
        btnStopSort.setVisible(false);
        controlsPane.add(btnStopSort);

        // RESUME SORT BUTTON
        btnResumeSort.setBounds(40, 80, 100, 25);
        btnResumeSort.addActionListener(manipulateSortingActionListener);
        btnResumeSort.setVisible(false);
        controlsPane.add(btnResumeSort);

        // DELAY LABEL
        delayLabel.setHorizontalAlignment(JLabel.LEFT);
        delayLabel.setBounds(10, 120, 50, 25);
        controlsPane.add(delayLabel);

        // SPEED LABEL
        speedLabel.setHorizontalAlignment(JLabel.LEFT);
        speedLabel.setBounds(135, 120, 50, 25);
        controlsPane.add(speedLabel);

        // SPEED SLIDER
        speedSlider.setMajorTickSpacing(5);
        speedSlider.setBounds(55, 122, 75, 25);
        speedSlider.setPaintTicks(false);
        controlsPane.add(speedSlider);

        // COMPARISONS LABEL
        comparedLabel.setHorizontalAlignment(JLabel.LEFT);
        comparedLabel.setBounds(10, 155, 200, 25);
        controlsPane.add(comparedLabel);

        // HELP COMPARISON BUTTON
        btnHelpComparison.setBounds(153, 155, 20, 25);
        btnHelpComparison.setMargin(new Insets(1, 1, 1, 1));
        controlsPane.add(btnHelpComparison);

        // ARRAY ACCESSED LABEL
        arrayAccessedLabel.setHorizontalAlignment(JLabel.LEFT);
        arrayAccessedLabel.setBounds(10, 185, 200, 25);
        controlsPane.add(arrayAccessedLabel);

        // HELP ACCESS BUTTON
        btnHelpAccess.setBounds(153, 185, 20, 25);
        btnHelpAccess.setMargin(new Insets(1, 1, 1, 1));
        controlsPane.add(btnHelpAccess);

        // ALGORITHM INFO LABEL
        algorithmInfoLabel.setHorizontalAlignment(JLabel.LEFT);
        algorithmInfoLabel.setBounds(10, 220, 200, 25);
        controlsPane.add(algorithmInfoLabel);

        // ALGORITHM INFO AREA
        algorithmInfoArea.setBounds(10, 250, 160, 70);
        algorithmInfoArea.setEditable(false);
        algorithmInfoArea.setMargin(new Insets(10, 25, 10, 10));
        controlsPane.add(algorithmInfoArea);

        // HELP INSTRUCTIONS BUTTON
        btnHelpInstructions.setBounds(15, 340, 70, 25);
        controlsPane.add(btnHelpInstructions);

        // ABOUT BUTTON
        btnAbout.setBounds(95, 340, 70, 25);
        controlsPane.add(btnAbout);

        // SORTING PROCESS LABEL
        sortingProcessLabel.setBounds(200, 10, 580, 25);
        jframe.getContentPane().add(sortingProcessLabel);

        // CANVAS FOR GRAPH
        canvas = new GraphVisualizer(rectangle_width, length, array, current, check);
        canvas.setBounds(190, 35, GRAPH_SIZE, GRAPH_SIZE - 30);
        canvas.setBorder(BorderFactory.createLineBorder(Color.black));

        jframe.getContentPane().add(genDataPane);
        jframe.getContentPane().add(controlsPane);
        jframe.getContentPane().add(canvas);

        jframe.repaint();
        jframe.revalidate();

        // ADD ACTION LISTENERS
        genDataOptionComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // disable start btn
                btnStartSort.setEnabled(false);

                curInputDataOption = genDataOptionComboBox.getSelectedIndex();
                switch (curInputDataOption) {
                    case 0: // random
                        arrayLengthLabel.setVisible(true);
                        arrayLengthInput.setVisible(true);
                        arrayLengthInput.setText("50");

                        displayTextArea = "[\n \n]";
                        inputArrayArea.setText(displayTextArea);
                        arrayLengthErrorLabel.setText("");
                        arrayLengthErrorLabel.setBounds(0, 130, 180, 25);

                        btnGenerateArray.setBounds(40, 155, 100, 25);
                        btnGenerateArray.setEnabled(true);
                        inputArrayScrollPane.setVisible(false);
                        break;
                    case 1: // manual input
                        arrayLengthLabel.setVisible(false);
                        arrayLengthInput.setVisible(false);

                        arrayLengthErrorLabel.setText("");
                        arrayLengthErrorLabel.setBounds(0, 140, 180, 25);

                        btnGenerateArray.setBounds(40, 165, 100, 25);
                        btnGenerateArray.setEnabled(false);
                        inputArrayScrollPane.setVisible(true);
                        break;
                }
            }

        });

        btnHelpGenerateArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jframe, helpGenDataMsg[genDataOptionComboBox.getSelectedIndex()],
                        "Help to generate array", JOptionPane.PLAIN_MESSAGE, null);
            }
        });

        btnHelpComparison.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jframe,
                        "Comparisons show number of times that sorting process have been compared two elements.",
                        "What is Comparisons?", JOptionPane.PLAIN_MESSAGE, null);
            }
        });

        btnHelpAccess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jframe,
                        "Array Accessed show number of times that sorting process have been accessed to array while sorting or comparison or swap.",
                        "What is Array Accessed?", JOptionPane.PLAIN_MESSAGE, null);
            }
        });

        arrayLengthInput.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // disable start btn
                btnStartSort.setEnabled(false);

                String curInput = arrayLengthInput.getText();
                if (!validator.checkNullOrEmpty(curInput)) {
                    if (validator.checkNumber(curInput)) {
                        int arrLength = Integer.parseInt(curInput);
                        if (arrLength > 1) {
                            if (arrLength <= 300) {
                                showErrorMsg("");
                                length = Integer.parseInt(curInput);
                                //manipulateSortingProcess.reset();
                                //manipulateSortingProcess.Update();

                                //manipulateSortingProcess.reset();
                                
                                //--------reset-------------
                                isSorting = false;
                                current = -1;
                                check = -1;
                                //updateProcess(length, array, current, check);
                                //--------------------------

                            } else {
                                showErrorMsg("Must less than or equal 300");
                            }
                        } else {
                            showErrorMsg("Must bigger than 1!");
                        }
                    } else {
                        showErrorMsg("Must be numberic!");
                    }
                } else {
                    showErrorMsg("Cannot be null or empty!");
                }
            }

            private void showErrorMsg(String errorMsg) {
                arrayLengthErrorLabel.setText(errorMsg);
                btnGenerateArray.setEnabled(validator.checkNullOrEmpty(errorMsg) ? true : false);
            }
        });

        inputArrayArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    onChange();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    onChange();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {

            }

            private void onChange() throws Exception {
                // disable start btn
                btnStartSort.setEnabled(false);

                String curInput = inputArrayArea.getText();
                try {
                    int[] arr = helpers.StrToArr(helpers.deleteNewLineTabSpaces(curInput), ",");
                    if (arr.length > 1 && arr.length <= 300) {
                        showErrorMsg("");
                        displayTextArea = curInput;
//						changeText(arr, ",");
                    } else {
                        showErrorMsg("Invalid array!");
                    }
                } catch (Exception ex) {
                    if (ex.getMessage() == "NotNumber") {
                        showErrorMsg("Invalid array!");
                    } else {
                        ex.printStackTrace();
                        showErrorMsg("There was an uncaught error!");
                    }
                }

            }

            private void showErrorMsg(String errorMsg) {
                arrayLengthErrorLabel.setText(errorMsg);
                btnGenerateArray.setEnabled(validator.checkNullOrEmpty(errorMsg) ? true : false);
            }
        });

        btnGenerateArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // enable start btn
                btnStartSort.setEnabled(true);
                // update to processing message when generate new data
                setSortingProcessMsg(sortingProcessListMsg[curAlg]);

                // reset statistics info to 0
                setCompared(0);
                setArrayAccessed(0);
                comparedLabel.setText("Comparisons: " + getCompared());
                arrayAccessedLabel.setText("Array Accessed : " + getArrayAccessed());

                curInputDataOption = genDataOptionComboBox.getSelectedIndex();
                switch (curInputDataOption) {
                    case 0: // random
//                        data.setLength(Integer.parseInt(arrayLengthInput.getText()));
                        //data.generateRandomArray();
                        length = Integer.parseInt(arrayLengthInput.getText());
                        array = new int[length];
                        for (int i = 0; i < length; i++) {
                            array[i] = i + 1;
                        }
                        for (int a = 0; a < 500; a++) {
                            for (int i = 0; i < length; i++) {
                                int rand = r.nextInt(length);
                                int temp = array[rand];
                                array[rand] = array[i];
                                array[i] = temp;
                            }
                        }
                        isSorting = false;

                        //manipulateSortingProcess.setLength(length);
                        canvas.setLength(length);
                        //manipulateSortingProcess.setArray(array);
                        canvas.setArray(array);

                        canvas.setRectangle_width(GRAPH_SIZE / length);
                        canvas.repaint();

                        break;
                    case 1: // manual input
                        int[] newArr;
                        try {
                            newArr = helpers.StrToArr(helpers.deleteNewLineTabSpaces(displayTextArea), ",");
//                            data.setLength(newArr.length);
//                            data.setArray(newArr);
                            length = newArr.length;
                            //manipulateSortingProcess.setLength(length);
                            canvas.setLength(length);

                            array = newArr;

                            //manipulateSortingProcess.setArray(array);
                            canvas.setArray(array);

                            canvas.setRectangle_width(GRAPH_SIZE / length);
                            canvas.repaint();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        break;
                }

            }
        });

        algorithmComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // update processing message when choose algorithm
            	curAlg = algorithmComboBox.getSelectedIndex();
                setSortingProcessMsg(sortingProcessListMsg[curAlg]);
                sortingProcessLabel.setText(getSortingProcessMsg());
                algorithmInfoArea.setText(algorithmListInfo[curAlg]);
            }

        });

        speedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                speed = (int) speedSlider.getValue();
                speedLabel.setText(speed + " ms");
            }
        });

        btnHelpInstructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jframe, HELP_INSTRUCTION_MESSAGE, "Help", JOptionPane.PLAIN_MESSAGE, null);
            }
        });

        btnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jframe, ABOUT_MESSAGE, "About", JOptionPane.PLAIN_MESSAGE, null);
            }
        });

        //manipulateSortingProcess.sorting();
    }

    public void updateWhenSortDone() {
        isSorting = false;
        // update data pane
        genDataOptionComboBox.setEnabled(true);
        btnGenerateArray.setEnabled(true);
        arrayLengthInput.setEnabled(true);
        inputArrayArea.setEnabled(true);
        inputArrayScrollPane.setEnabled(true);

        // update control pane
        algorithmComboBox.setEnabled(true);
        btnStartSort.setVisible(true);
        btnPauseSort.setVisible(false);
        btnStopSort.setVisible(false);
    }

    public void updateProcess(int length, int[] array, int current, int check) {
        // update graph elements width
        setRectangleWidth(GRAPH_SIZE / length);

        // update labels
        comparedLabel.setText("Comparisons: " + getCompared());
        arrayAccessedLabel.setText("Array Accessed : " + getArrayAccessed());
        sortingProcessLabel.setText(getSortingProcessMsg());

        //canvas = new GraphVisualizer(rectangle_width, length, array, current, check);
        canvas.setLength(length);
        canvas.setArray(array);
        canvas.setRectangle_width(GRAPH_SIZE / length);
        canvas.setCurrent(current);
        canvas.setCheck(check);

        canvas.repaint();
    }

    public void updateArrayAccessed(int i) {
        arrayAccessed += i;
    }

    public void delay() {
        try {
            Thread.sleep(speed);
        } catch (Exception e) {
        }
    }

}