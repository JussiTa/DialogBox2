package fi.isokaju.DialogBox2.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import fi.isokaju.DialogBox2.dao.PeugeotDao;
import fi.isokaju.DialogBox2.dao.PeugeotDaoImpl;
import fi.isokaju.DialogBox2.model.P308;
import fi.isokaju.DialogBox2.model.Peugeot;

public class Paneeli extends JFrame {

	private JPanel contentPane;
	private Peugeot[] peugeot; 
	private JList list;
	private JTextArea textArea;
	private Peugeot p;
	private PeugeotDao pd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		//Configuration cfg = new Configuration()
	   // .addClass(Peugeot.class);
	   // .addClass(P308.class);
			
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paneeli frame = new Paneeli();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public Paneeli() {
		
		p=    new P308("308","1.6 HDI","SW");
		
		pd = new PeugeotDaoImpl();
		try {
			pd.addModel(p);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));		
		peugeot = createNewModel();		
		list = new JList(peugeot);		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(60, 80));
		
		
		contentPane.add(listScroller, BorderLayout.WEST);
		
		textArea = new JTextArea(5,30);
		contentPane.add(textArea, BorderLayout.EAST);
		
		
	
	//#################Event handlers methods
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index;
				index= list.getSelectedIndex();
				textArea.append(peugeot[index].getInfo());
			}
		});
		
		
	
  //Methods for handling data
		
	
	}
	
	
	
	 Peugeot[] createNewModel(){		
		//P308 P308 = new P308("308","1.6 HDI","SW");		
		
		Peugeot[] Peugeot2 =  pd.getModel();
		return Peugeot2;  
	}
  
	
	

}
