import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	StructureFactory problem;
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
	int[] arr;
	int[][] mat;
	LinkedList<Integer> lis;
	int len = 6;
	JSplitPane splitPane;

	public MainFrame() {
		super("Algorithm Helper");
		// initialize all the Frame contents and state
		init();
	}

	private void buildProblem(String type) {
		panelProb.removeAll();
		problem = new StructureFactory(type, len);
		panelProb.add(problem);
		panelProb.revalidate();
		btnHeap.setEnabled(true);
		btnMerge.setEnabled(true);
		btnQuick.setEnabled(true);
		revalidate();
		repaint();
	}

	private void buildSolution(String type, String sortType) {
		panelSol.removeAll();
		StructureFactory solution = new StructureFactory(type, len);
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
		panelSol.revalidate();
		revalidate();
		repaint();
	}

	private void init() {
		panelMain = new JPanel();
		ActionListener typeL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TYPE = e.getActionCommand();
				buildProblem(TYPE);
			}
		};
		ActionListener sortL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new SortStrategy(TYPE, e.getActionCommand());
				buildSolution(TYPE, e.getActionCommand());
			}
		};

		// frame state: size and close operation
		setSize(1200, 600);
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.X_AXIS));
		getContentPane().add(panelMain);

		splitPane = new JSplitPane();
		splitPane.setDividerLocation(this.getWidth() / 2);
		splitPane.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane.setAlignmentX(Component.CENTER_ALIGNMENT);

		panelMain.add(splitPane);
		west = new JPanel();
		east = new JPanel();

		splitPane.add(west, JSplitPane.LEFT);
		splitPane.add(east, JSplitPane.RIGHT);
		GridBagLayout gbl_west = new GridBagLayout();
		gbl_west.columnWidths = new int[] { 70, 70, 70, 70, 70 };
		gbl_west.rowHeights = new int[] { 70, 200 };
		gbl_west.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_west.rowWeights = new double[] { 0.0, 0.0 };
		west.setLayout(gbl_west);
		btnMat = new JButton(Const.MATRIX);
		btnMat.addActionListener(typeL);

		btnArray = new JButton(Const.ARRAY);
		btnArray.addActionListener(typeL);

		// west side
		GridBagConstraints gbc_btnArray = new GridBagConstraints();
		gbc_btnArray.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnArray.anchor = GridBagConstraints.NORTH;
		gbc_btnArray.insets = new Insets(0, 0, 5, 5);
		gbc_btnArray.gridx = 1;
		gbc_btnArray.gridy = 0;
		west.add(btnArray, gbc_btnArray);
		GridBagConstraints gbc_btnMat = new GridBagConstraints();
		gbc_btnMat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMat.anchor = GridBagConstraints.NORTH;
		gbc_btnMat.insets = new Insets(0, 0, 5, 5);
		gbc_btnMat.gridx = 2;
		gbc_btnMat.gridy = 0;
		west.add(btnMat, gbc_btnMat);
		btnList = new JButton(Const.LIST);
		btnList.addActionListener(typeL);
		GridBagConstraints gbc_btnList = new GridBagConstraints();
		gbc_btnList.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnList.anchor = GridBagConstraints.NORTH;
		gbc_btnList.insets = new Insets(0, 0, 5, 5);
		gbc_btnList.gridx = 3;
		gbc_btnList.gridy = 0;
		west.add(btnList, gbc_btnList);
		panelProb = new JPanel();
		panelProb.setBackground(Color.GRAY);
		GridBagConstraints gbc_panelProb = new GridBagConstraints();
		gbc_panelProb.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelProb.gridwidth = 5;
		gbc_panelProb.insets = new Insets(0, 0, 0, 5);
		gbc_panelProb.gridx = 0;
		gbc_panelProb.gridy = 1;
		west.add(panelProb, gbc_panelProb);
		GridBagLayout gbl_east = new GridBagLayout();
		gbl_east.columnWidths = gbl_west.columnWidths;
		gbl_east.rowHeights = gbl_west.rowHeights;
		gbl_east.columnWeights = gbl_west.columnWeights;
		gbl_east.rowWeights = gbl_west.rowWeights;
		east.setLayout(gbl_east);

		btnHeap = new JButton(Const.HEAP);
		btnHeap.setEnabled(false);
		btnHeap.addActionListener(sortL);
		// east side
		GridBagConstraints gbc_btnHeap = new GridBagConstraints();
		gbc_btnHeap.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHeap.anchor = GridBagConstraints.NORTH;
		gbc_btnHeap.insets = new Insets(0, 0, 0, 5);
		gbc_btnHeap.gridx = 1;
		gbc_btnHeap.gridy = 0;
		east.add(btnHeap, gbc_btnHeap);
		btnMerge = new JButton(Const.MERGE);
		btnMerge.setEnabled(false);
		btnMerge.addActionListener(sortL);
		btnQuick = new JButton(Const.QUICK);
		btnQuick.setEnabled(false);
		btnQuick.addActionListener(sortL);
		GridBagConstraints gbc_btnQuick = new GridBagConstraints();
		gbc_btnQuick.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuick.anchor = GridBagConstraints.NORTH;
		gbc_btnQuick.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuick.gridx = 2;
		gbc_btnQuick.gridy = 0;
		east.add(btnQuick, gbc_btnQuick);
		GridBagConstraints gbc_btnMerge = new GridBagConstraints();
		gbc_btnMerge.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMerge.anchor = GridBagConstraints.NORTH;
		gbc_btnMerge.insets = new Insets(0, 0, 0, 5);
		gbc_btnMerge.gridx = 3;
		gbc_btnMerge.gridy = 0;
		east.add(btnMerge, gbc_btnMerge);
		panelSol = new JPanel();
		panelSol.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panelSol = new GridBagConstraints();
		gbc_panelSol.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelSol.gridwidth = 5;
		gbc_panelSol.insets = new Insets(0, 0, 0, 5);
		gbc_panelSol.gridx = 0;
		gbc_panelSol.gridy = 1;
		east.add(panelSol, gbc_panelSol);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
