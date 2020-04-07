import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuadraticInterpolationPanel extends JPanel {

	QuadraticInterpolation quadinterpol = new QuadraticInterpolation();

	private JLabel xnot;

	private JLabel xone;

	private JLabel xtwo;

	private JLabel xvalue;

	private JLabel ynot;

	private JLabel yone;

	private JLabel ytwo;

	public JTextField xnotxtfd;

	public JTextField xonetxtfd;

	public JTextField xtwotxtfd;

	public JTextField xvaluetxtfd;

	public JTextField ynotxtfd;

	public JTextField yonetxtfd;

	public JTextField ytwotxtfd;

	public JButton Calcbtn;

	public JButton Clearbtn;

	public JTextArea answertxtarea;

	public QuadraticInterpolationPanel() {
		quadInterpolLayoutdesign();
	}

	public void quadInterpolLayoutdesign() {
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		this.xnot = new JLabel("Xo");
		this.xone = new JLabel("X1");
		this.xtwo = new JLabel("X2");
		this.xvalue = new JLabel("X=");
		this.xnotxtfd = new JTextField(10);
		this.xonetxtfd = new JTextField(10);
		this.xtwotxtfd = new JTextField(10);
		this.xvaluetxtfd = new JTextField(10);

		this.ynot = new JLabel("Yo");
		this.yone = new JLabel("Y1");
		this.ytwo = new JLabel("Y2");
		this.ynotxtfd = new JTextField(10);
		this.yonetxtfd = new JTextField(10);
		this.ytwotxtfd = new JTextField(10);

		this.answertxtarea = new JTextArea(10, 60);

		this.Calcbtn = new JButton("Compute");

		this.Clearbtn = new JButton("Clear");

		Dimension getCalcbtnsize = Calcbtn.getPreferredSize();
		this.Clearbtn.setPreferredSize(getCalcbtnsize);
		
		//------------------------------------
		gc.gridx = 0;
		gc.gridy = 0;
		gc.ipadx = 8;
		gc.ipady = 8;
		gc.insets = new Insets(5, 5, 5, 5);
		add(this.xnot, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		add(this.xnotxtfd, gc);

		gc.gridx = 2;
		gc.gridy = 0;
		add(this.ynot, gc);
		
		gc.gridx = 3;
		gc.gridy = 0;
		add(this.ynotxtfd, gc);
		
		gc.gridx = 4;
		gc.gridy = 0;
		add(this.Calcbtn, gc);
		
		
		//-------------------------------------
		gc.gridx = 0;
		gc.gridy = 1;
		add(this.xone, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		add(this.xonetxtfd, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(this.yone, gc);
		
		gc.gridx = 3;
		gc.gridy = 1;
		add(this.yonetxtfd, gc);
		
		
		gc.gridx = 4;
		gc.gridy = 2;
		add(this.Clearbtn, gc);
		
		
		//---------------------------------------
		gc.gridx = 0;
		gc.gridy = 2;
		add(this.xtwo, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(this.xtwotxtfd, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		add(this.ytwo, gc);
		
		gc.gridx = 3;
		gc.gridy = 2;
		add(this.ytwotxtfd, gc);
		
		//---------------------------------------
		gc.gridx = 0;
		gc.gridy = 3;
		add(this.xvalue, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		add(this.xvaluetxtfd, gc);
		
		
		//---------------------------------------
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth = 5;
		add(new JScrollPane(this.answertxtarea), gc);
		
		

		this.Calcbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String xnotvalue = "";
				xnotvalue = xnotxtfd.getText();
				double xnot = Double.parseDouble(xnotvalue);

				String xonevalue = "";
				xonevalue = xonetxtfd.getText();
				double xone = Double.parseDouble(xonevalue);

				String xtwovalue = "";
				xtwovalue = xtwotxtfd.getText();
				double xtwo = Double.parseDouble(xtwovalue);

				String xvalgiven = "";
				xvalgiven = xvaluetxtfd.getText();
				double pvalue = Double.parseDouble(xvalgiven);

				String ynotvalue = "";
				ynotvalue = ynotxtfd.getText();
				double ynot = Double.parseDouble(ynotvalue);

				String yonevalue = "";
				yonevalue = yonetxtfd.getText();
				double yone = Double.parseDouble(yonevalue);

				String ytwovalue = "";
				ytwovalue = ytwotxtfd.getText();
				double ytwo = Double.parseDouble(ytwovalue);

				String lnotanswer = quadinterpol.setLnot(xnot, xone, xtwo);
				answertxtarea.append(" L0 =  " + lnotanswer + "\n");

				String loneanswer = quadinterpol.setLxone(xnot, xone, xtwo);
				answertxtarea.append(" L1 =  " +loneanswer + "\n");

				String ltwoanswer = quadinterpol.setLxtwo(xnot, xone, xtwo);
				answertxtarea.append(" L2 =  " +ltwoanswer + "\n");

				String p2txtoneans = quadinterpol.setPtwo(ynot, yone, ytwo, xnot, xone, xtwo);
				answertxtarea.append(" P2 =  " +p2txtoneans + "\n");

				double p2evaluated = quadinterpol.setPevaluated(pvalue, ynot, yone, ytwo, xnot, xone, xtwo);
				answertxtarea.append(" P2evaluated =  " +Double.toString(p2evaluated) + "\n");
			}
		});

		this.Clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xnotxtfd.setText("");
				xonetxtfd.setText("");
				xtwotxtfd.setText("");
				xvaluetxtfd.setText("");
				ynotxtfd.setText("");
				yonetxtfd.setText("");
				ytwotxtfd.setText("");
				answertxtarea.setText("");
			}
		});
	}

}