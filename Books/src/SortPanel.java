import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Kristin Clark
 *
 */
public class SortPanel extends JPanel{
	
	JPanel sort = new JPanel();
	JLabel title = new JLabel("SORT SHOPPING LIST BY STORE");
	String[] stores = {"Target", "HyVee", "PetSmart", "Home Depot"};
	JComboBox store = new JComboBox(stores);
	JTextArea list = new JTextArea(5,15);
	JButton back = new JButton("Back");
	
	MasterPanel masterPanel;
	
	ListItemDAO itemDAO = new ListItemDAO();
	
	public SortPanel(){
		
		MasterPanel masterPanel = (MasterPanel) this.getParent();
		
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		setMinimumSize(new Dimension(400,250));
		list.append(itemDAO.getCurrentListFromStore(stores[0]));
		list.setLineWrap(true);
	    list.setEditable(true);
	    list.setVisible(true);
	    
	    JScrollPane scroll = new JScrollPane(list);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
        SelectorListener sl = new SelectorListener();
        store.addActionListener(sl);
        back.addActionListener(sl);
        
        setLayout(new BorderLayout());
		sort.add(title, BorderLayout.NORTH);
		sort.add(store, BorderLayout.WEST);
		sort.add(scroll, BorderLayout.CENTER);
		sort.add(back, BorderLayout.SOUTH);
		
		add(sort);
		
	}
	
	class SelectorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = store.getSelectedItem().toString();
			//System.
			list.setText(itemDAO.getCurrentListFromStore(s));
			
			System.out.println("noted change");
			
			if(e.getSource() == back){
				masterPanel.showCardMenu();
			}
		}
		
	}

}
