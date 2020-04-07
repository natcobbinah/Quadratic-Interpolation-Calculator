import javax.swing.SwingUtilities;

public class QuadDriver_exe {

	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new QuadMainFrame();
				}
			});
	}

}
