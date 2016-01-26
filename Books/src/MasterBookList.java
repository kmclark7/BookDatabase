import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Kristin Clark
 *
 */
public class MasterBookList extends JFrame{

	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		MasterPanel master = new MasterPanel();
		frame.add(master);
		frame.setSize(400, 250);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
