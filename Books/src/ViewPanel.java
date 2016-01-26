import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.LayoutPath;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

public class ViewPanel extends JPanel {
	Container c = getRootPane();
	ListItemDAO itemDAO = new ListItemDAO(); /// ListItem is JList p. 413 in
												/// Head First Java
	JLabel title = new JLabel("VIEW BOOK LIST");

	ArrayList<ListItem> listModel = new ArrayList<ListItem>(itemDAO.arrayList);
	// ListItem abc = new ListItem("Sample store", "Sample Item");
	JList list = new JList(listModel.toArray());

	JScrollPane scroll = new JScrollPane(list);
	JButton back = new JButton("Back");
	JButton remove = new JButton("Remove item");
	MasterPanel masterPanel;

	public ViewPanel() {

		JPanel masterPanel = (JPanel)this.getParent();
		title.setFont(new Font("Serif", Font.PLAIN, 16));

		setLayout(new BorderLayout());

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(350, 100));

		add(title, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

		ButtonListener bl = new ButtonListener();
		back.addActionListener(bl);
		remove.addActionListener(bl);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(back);
		buttonPanel.add(remove);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == back) {
				masterPanel.showCardMenu();
			}

			if (e.getSource() == remove) {

				int index = list.getSelectedIndex();
				System.out.println(list.getSelectedIndex());

				if (index != -1) {
					ListItem tempItem = listModel.get(index);
					itemDAO.deleteItem(tempItem);
					setVisible(false);
					listModel.remove(index);
					list.setListData(listModel.toArray());
					scroll.revalidate();
					scroll.repaint();
					setVisible(true);
				}

				System.out.println("Remove selected object");

			} // end if

		}// end actionperformed

	}// end ButtonListener

}// end ViewPanel
