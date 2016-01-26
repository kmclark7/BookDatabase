import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Kristin Clark
 *
 */
public class AddPanel extends JPanel{

	String[] stores = {"Target", "Hyvee", "PetSmart", "Home Depot"};
	
	JLabel title = new JLabel("ADD ITEMS TO SHOPPING LIST");
	JLabel storeLabel = new JLabel("Store");
	JComboBox store = new JComboBox(stores);
	JLabel itemLabel = new JLabel("Item");
	JTextField item = new JTextField(25);
	JButton submit = new JButton("Add to List");
	JButton back = new JButton("Back to Main");
	JButton viewList = new JButton("View List");
	JButton viewAllItems = new JButton("View all items");
	ListItemDAO itemDAO = new ListItemDAO();
	MasterPanel masterPanel;

	
	
	public AddPanel(){
		
		MasterPanel masterPanel = (MasterPanel)this.getParent();
		
		ButtonListener b = new ButtonListener();
		submit.addActionListener(b);
		viewList.addActionListener(b);
		viewAllItems.addActionListener(b);
		back.addActionListener(b);
		
		setLayout(new BorderLayout());
		
		title.setFont(new Font("Serif", Font.PLAIN, 16));
		add(title,BorderLayout.NORTH);

		JPanel buttonLabels = new JPanel(new GridLayout(2,0));

		buttonLabels.add(storeLabel);
		buttonLabels.add(itemLabel);
		add(buttonLabels, BorderLayout.WEST);
		JPanel textBoxes = new JPanel(new GridLayout(2,0));
		textBoxes.add(store);
		textBoxes.add(item);
		add(textBoxes,BorderLayout.CENTER);
	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));   

		buttonPanel.add(submit);
		buttonPanel.add(viewList);
		buttonPanel.add(viewAllItems);
		buttonPanel.add(back);
		
		add(buttonPanel, BorderLayout.SOUTH);
				
	}//end constructor
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == submit) {
				System.out.println("Add new item to database");
				String tempStore = store.getSelectedItem().toString();
				String tempItem = item.getText();
				ListItem t = new ListItem(tempStore, tempItem);
				itemDAO.insertNewItem(t);
				
				item.setText("");		
			}
			
			if (e.getSource() == viewList){
				masterPanel.showCardView();
			}
			
			if(e.getSource() == viewAllItems){
				masterPanel.showCardSort();
            	
			}
			
			if(e.getSource() == back){
				masterPanel.showCardMenu();
			}
		}
		
	}

}
