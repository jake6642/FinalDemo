import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	JSlider slideNum;
	JButton btnGen;
	JPanel panelProb;
	JPanel panelSol;
	JPanel panelMain;
	JComboBox<String> type;
	JComboBox<String> algo;
	
	public MainFrame()
	{
		super( "Algorithm Helper" );
		//initialize all the Frame contents and state
		init();
	}
	
	private void init()
	{
		panelMain = new JPanel();
		panelProb = new JPanel();
		panelSol = new JPanel();
		JPanel south = new JPanel();
		btnGen = new JButton("Generate");
		slideNum = new JSlider();
		type = new JComboBox<String>();
		algo = new JComboBox<String>();
		
		type.addItem(Const.ARRAY);
		type.addItem(Const.MATRIX);
		type.addItem(Const.LIST);
		
		algo.addItem(Const.HEAP);
		algo.addItem(Const.QUICK);
		
		type.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (type.getSelectedItem().toString()) {
				case Const.ARRAY:
					panelProb.removeAll();
					panelProb.add(new StructureFactory(Const.ARRAY, 5));
					panelProb.revalidate();
					panelMain.revalidate();
					revalidate();
					System.out.println(Const.ARRAY);
					break;
				case Const.MATRIX:
					panelProb.removeAll();
					panelProb.add(new StructureFactory(Const.MATRIX, 5));
					panelProb.revalidate();
					panelMain.revalidate();
					revalidate();
					System.out.println(Const.MATRIX);
					break;
				case Const.LIST:
					panelProb.removeAll();
					panelProb.add(new StructureFactory(Const.LIST, 5));
					panelProb.revalidate();
					panelMain.revalidate();
					revalidate();
					System.out.println(Const.MATRIX);
					break;
				default:
				}				
			}});
		//frame state: size and close operation
		setSize( 600, 400 );
		panelMain.setLayout(new FlowLayout());

		
		panelSol.add(new JLabel("Solution"));
		panelMain.add(type);
		panelMain.add(new JLabel("Problem"));
		panelMain.add(panelProb);
		//panelMain.add(panelSol);
		//panelMain.add(south);
		getContentPane().add(panelMain, BorderLayout.CENTER);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}
}
