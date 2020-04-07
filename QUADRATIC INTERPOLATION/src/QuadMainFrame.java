import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class QuadMainFrame extends JFrame {

	private QuadraticInterpolationPanel quadInterpolPanel;
	private About about;

	public QuadMainFrame() {
		setTitle("Quadratic Interpolation Calculator");
		
		try {
			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
		}

		quadMainFrameLayoutdesign();

		setResizable(false);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void quadMainFrameLayoutdesign() {
		setLayout(new BorderLayout());

		quadInterpolPanel = new QuadraticInterpolationPanel();

		add(quadInterpolPanel, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();

		JMenu aboutMenu = new JMenu("About");
		JMenuItem aboutItem = new JMenuItem("About");
		aboutMenu.add(aboutItem);

		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == aboutItem) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new About();
						}
					});
				}
			}
		});

		menuBar.add(aboutMenu);

		setJMenuBar(menuBar);

	}
}