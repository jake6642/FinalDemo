import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

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
	String TYPE;
	int[] arr;
	int[][] mat;
	LinkedList<Integer> lis;
	int len = 2;

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
		panelProb.add(btnHeap);
		panelProb.add(btnQuick);
		panelProb.add(btnMerge);
		panelCenter.revalidate();
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
		panelCenter.revalidate();
		revalidate();
		repaint();
	}

	private void init() {
		panelMain = new JPanel();
		panelProb = new JPanel();
		panelSol = new JPanel();
		panelCenter = new JPanel();
		JPanel west = new JPanel();
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

		btnHeap = new JButton(Const.HEAP);
		btnHeap.addActionListener(sortL);
		btnQuick = new JButton(Const.QUICK);
		btnQuick.addActionListener(sortL);
		btnMerge = new JButton(Const.MERGE);
		btnMerge.addActionListener(sortL);

		btnArray = new JButton(Const.ARRAY);
		btnArray.addActionListener(typeL);
		btnMat = new JButton(Const.MATRIX);
		btnMat.addActionListener(typeL);
		btnList = new JButton(Const.LIST);
		btnList.addActionListener(typeL);

		slideNum = new JSlider();

		// frame state: size and close operation
		setSize(600, 400);
		panelMain.setLayout(new BorderLayout());

		west.add(btnArray);
		west.add(btnMat);
		west.add(btnList);
		panelCenter.add(panelProb);
		panelCenter.add(panelSol);
		panelMain.add(panelCenter, BorderLayout.CENTER);
		panelMain.add(west, BorderLayout.WEST);
		getContentPane().add(panelMain);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
