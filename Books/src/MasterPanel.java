import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Kristin Clark
 *
 */
@SuppressWarnings("serial")
public class MasterPanel extends JPanel{

	private JPanel master = new JPanel();
	CardLayout clayout = new CardLayout();
	final private String MENU = "Menu";
	final private String VIEW = "View";
	final private String ADD = "Add";
	final private String SORT = "Sort";

	private MenuPanel menuPanel;
	private ViewPanel viewPanel;
	private AddPanel addPanel;
	private SortPanel sortPanel;


	public MasterPanel(){
		
		master.setLayout(clayout);
		
		menuPanel = new MenuPanel();
		viewPanel = new ViewPanel();
		addPanel = new AddPanel();
		sortPanel = new SortPanel();
		
		master.add(menuPanel, MENU);
		master.add(viewPanel, VIEW);
		master.add(addPanel, ADD);
		master.add(sortPanel, SORT);
		
		add(master);

		clayout.show(master, MENU);
				
	}//end MasterPanel constructor
	
	
	public void showCardMenu(){	
		clayout.show(master, MENU);
	}//end showCardMenu

	public void showCardView(){	
		clayout.show(master, VIEW);
	}//end showCardView
	
	public void showCardAdd(){	
		clayout.show(master, ADD);
	}//end showCardAdd

	public void showCardSort(){	
		clayout.show(master, SORT);
	}//end showCardSort

}//end MasterPanel