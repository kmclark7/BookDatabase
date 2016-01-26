import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * 
 */

/**
 * @author Kristin Clark
 *
 */
	class MenuPanel extends JPanel {
		
		MasterPanel masterPanel;
		JPanel menu = new JPanel();
		ViewPanel viewPanel;
		AddPanel addPanel;
		SortPanel sortPanel;

		JButton view = new JButton("View List");
		JButton add = new JButton("Add Items");
		JButton sort = new JButton("Sort List");

		public MenuPanel() {
			System.out.println(this.getParent());
			MasterPanel masterPanel = (MasterPanel)this.getParent();
			
			ButtonHandler handler = new ButtonHandler();
			view.addActionListener(handler);
			add.addActionListener(handler);
			sort.addActionListener(handler);
			
			menu.add(view);
			menu.add(add);
			menu.add(sort);
			
			add(menu);

		}//end MenuPanel constructor

		class ButtonHandler implements ActionListener {
			@Override
	        public void actionPerformed(ActionEvent e) {
				
	                if (e.getSource() == view) {
	                	masterPanel.showCardView();
	                	System.out.println("View Clicked");             
	                }else if (e.getSource() == add) {
	                   	masterPanel.showCardAdd();                    
	                }else if (e.getSource() == sort) {
	                   	masterPanel.showCardAdd();                     
	                }//end if
	                
	        }//end actionPerformed
		}//end ButtonHandler
			
	}//end MenuPanel
