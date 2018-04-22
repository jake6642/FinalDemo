package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import factory.StructureFactory;
import strategy.SortStrategy;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	StructureFactory problem;
	StructureFactory solution;
	JSlider slideNum;
	JButton btnHeap;
	JButton btnQuick;
	JButton btnMerge;
	JButton btnArray;
	JButton btnMat;
	JButton btnList;
	JPanel panelProb;
	JPanel panelSol;
	JPanel panelMain;
	JPanel panelCenter;
	JPanel west;
	JPanel east;
	String TYPE;
	public static Font mono;
	int[] arr;
	int[][] mat;
	LinkedList<Integer> lis;
	int len = 6;
	JSplitPane splitPane;

	public MainFrame() {
		super(Const.TITLE);
		// initialize all the Frame contents and state
		init();
		// put our output to a console on the display
		JTextArea consoleOut = new JTextArea();
		consoleOut.setEditable(false);
		consoleOut.setFont(mono);
		JScrollPane scroller = new JScrollPane(consoleOut);
		scroller.setPreferredSize(new Dimension(this.getWidth(), (int) (this.getHeight() / 2.5)));
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelMain.add(scroller, BorderLayout.SOUTH);
		PrintStream con = new PrintStream(new TextAreaOutputStream(consoleOut));
		System.setOut(con);
		System.setErr(con);
	}

	// update the panel with the original data structure
	private void buildProblem(String type) {
		panelProb.removeAll();
		problem = new StructureFactory(type, len);
		panelProb.add(problem);
		panelProb.revalidate();
		// enable the sort buttons
		btnHeap.setEnabled(true);
		btnMerge.setEnabled(true);
		btnQuick.setEnabled(true);
		// update
		revalidate();
		repaint();
	}

	// update the east panel with the sorted data structure
	private void buildSolution(String type, String sortType) {
		panelSol.removeAll();
		solution = new StructureFactory(type, len);
		switch (type) {
		case Const.ARRAY:
			solution.setArray(SortStrategy.getSortedArray(sortType));
			break;
		case Const.MATRIX:
			solution.setMatrix(SortStrategy.getSortedMatrix(sortType));
			break;
		case Const.LIST:
			solution.setList(SortStrategy.getSortedList(sortType));
			break;
		}

		panelSol.add(solution);
		// update
		panelSol.revalidate();
		revalidate();
		repaint();
	}

	private void init() {
		panelMain = new JPanel();
		mono = new Font(Font.MONOSPACED, Font.BOLD, 16);
		/* Button listeners for the factory and strategy buttons */
		ActionListener typeL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TYPE = e.getActionCommand();
				System.out.print("----------------\nBuilding " + TYPE + "\n\n");
				buildProblem(TYPE);
			}
		};
		ActionListener sortL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.print("----------------\nSorting " + TYPE + " with " + e.getActionCommand() + "\n\n");
				new SortStrategy(TYPE, e.getActionCommand());
				buildSolution(TYPE, e.getActionCommand());
			}
		};

		// initializers
		west = new JPanel();
		east = new JPanel();
		btnMat = new JButton(Const.MATRIX);
		btnArray = new JButton(Const.ARRAY);
		btnList = new JButton(Const.LIST);
		splitPane = new JSplitPane();
		panelProb = new JPanel();
		panelSol = new JPanel();
		btnHeap = new JButton(Const.HEAP);
		btnQuick = new JButton(Const.QUICK);
		btnMerge = new JButton(Const.MERGE);

		// frame state: size and close operation
		setSize(1200, 600);
		getContentPane().add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		panelMain.add(splitPane, BorderLayout.CENTER);
		panelProb.setBackground(Color.GRAY);
		panelSol.setBackground(Color.GRAY);

		// buttons and their listeners
		btnMat.addActionListener(typeL);
		btnArray.addActionListener(typeL);
		btnList.addActionListener(typeL);
		btnHeap.setEnabled(false);
		btnHeap.addActionListener(sortL);
		btnMerge.setEnabled(false);
		btnMerge.addActionListener(sortL);
		btnQuick.setEnabled(false);
		btnQuick.addActionListener(sortL);

		// splitPane setup
		splitPane.setDividerLocation(this.getWidth() / 2);
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		splitPane.add(west, JSplitPane.LEFT);
		splitPane.add(east, JSplitPane.RIGHT);

		// west side
		GridBagLayout gbl_west = new GridBagLayout();
		gbl_west.columnWidths = new int[] { 70, 70, 70, 70, 70 };
		gbl_west.rowHeights = new int[] { 70, 0, 200 };
		gbl_west.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_west.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		west.setLayout(gbl_west);
		GridBagConstraints gbc_btnArray = new GridBagConstraints();
		gbc_btnArray.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnArray.insets = new Insets(0, 0, 5, 5);
		gbc_btnArray.gridx = 1;
		gbc_btnArray.gridy = 0;
		west.add(btnArray, gbc_btnArray);
		GridBagConstraints gbc_btnMat = new GridBagConstraints();
		gbc_btnMat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMat.insets = new Insets(0, 0, 5, 5);
		gbc_btnMat.gridx = 2;
		gbc_btnMat.gridy = 0;
		west.add(btnMat, gbc_btnMat);
		GridBagConstraints gbc_btnList = new GridBagConstraints();
		gbc_btnList.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnList.insets = new Insets(0, 0, 5, 5);
		gbc_btnList.gridx = 3;
		gbc_btnList.gridy = 0;
		west.add(btnList, gbc_btnList);
		GridBagConstraints gbc_panelProb = new GridBagConstraints();
		gbc_panelProb.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelProb.gridwidth = 5;
		gbc_panelProb.gridx = 0;
		gbc_panelProb.gridy = 2;
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		JLabel label = new JLabel("Original");
		west.add(label, gbc_label);
		west.add(panelProb, gbc_panelProb);

		// east side
		GridBagLayout gbl_east = new GridBagLayout();
		gbl_east.columnWidths = gbl_west.columnWidths;
		gbl_east.rowHeights = gbl_west.rowHeights;
		gbl_east.columnWeights = gbl_west.columnWeights;
		gbl_east.rowWeights = gbl_west.rowWeights;
		east.setLayout(gbl_east);
		GridBagConstraints gbc_btnHeap = new GridBagConstraints();
		gbc_btnHeap.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHeap.insets = new Insets(0, 0, 5, 5);
		gbc_btnHeap.gridx = 1;
		gbc_btnHeap.gridy = 0;
		east.add(btnHeap, gbc_btnHeap);
		GridBagConstraints gbc_btnQuick = new GridBagConstraints();
		gbc_btnQuick.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuick.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuick.gridx = 2;
		gbc_btnQuick.gridy = 0;
		east.add(btnQuick, gbc_btnQuick);
		GridBagConstraints gbc_btnMerge = new GridBagConstraints();
		gbc_btnMerge.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMerge.insets = new Insets(0, 0, 5, 5);
		gbc_btnMerge.gridx = 3;
		gbc_btnMerge.gridy = 0;
		east.add(btnMerge, gbc_btnMerge);
		GridBagConstraints gbc_panelSol = new GridBagConstraints();
		gbc_panelSol.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelSol.gridwidth = 5;
		gbc_panelSol.gridx = 0;
		gbc_panelSol.gridy = 2;
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 2;
		gbc_label2.gridy = 1;
		JLabel label2 = new JLabel("Sorted");
		east.add(label2, gbc_label2);
		east.add(panelSol, gbc_panelSol);

		System.out.println("Starting " + Const.TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
