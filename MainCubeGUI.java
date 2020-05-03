import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class MainCubeGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private mainCube cube = new mainCube();
	private String [][] faceColors = new String[3][3];
	private JLabel Label00;
	private JLabel Label01;
	private JLabel Label02;
	private JLabel Label10;
	private JLabel Label11;
	private JLabel Label12;
	private JLabel Label20;
	private JLabel Label21;
	private JLabel Label22;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCubeGUI frame = new MainCubeGUI();
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
	public void colorMainFace () {
		faceColors = cube.currentSide.getFaceColors();
		this.colorSquare(Label00, 0, 0, faceColors);
		this.colorSquare(Label01, 0, 1, faceColors);
		this.colorSquare(Label02, 0, 2, faceColors);
		this.colorSquare(Label10, 1, 0, faceColors);
		this.colorSquare(Label11, 1, 1, faceColors);
		this.colorSquare(Label12, 1, 2, faceColors);
		this.colorSquare(Label20, 2, 0, faceColors);
		this.colorSquare(Label21, 2, 1, faceColors);
		this.colorSquare(Label22, 2, 2, faceColors);
	}
	// helper method to colorMainFace
	private void colorSquare(JLabel label, int y, int x, String[][] faceColors) {
		if(faceColors[y][x].equals("w")) {
			label.setBackground(Color.white);
		}
		if(faceColors[y][x].equals("y")) {
			label.setBackground(Color.yellow);
		}
		if(faceColors[y][x].equals("b")) {
			label.setBackground(Color.blue);
		}
		if(faceColors[y][x].equals("g")) {
			label.setBackground(Color.green);
		}
		if(faceColors[y][x].equals("r")) {
			label.setBackground(Color.red);
		}
		if(faceColors[y][x].equals("o")) {
			label.setBackground(Color.orange);
		}
		if(faceColors[y][x].equals("p")) {
			label.setBackground(Color.BLACK);
		}
		label.setOpaque(true);
	}
	public MainCubeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400,400);
		contentPane = new JPanel();
		
		contentPane.setSize(new Dimension(400, 400));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 245, 223);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 3, 2, 2));
		
		Label00 = new JLabel("");
		panel.add(Label00);
		
		Label01 = new JLabel("");
		panel.add(Label01);
		
		Label02 = new JLabel("");
		panel.add(Label02);
		
		Label10 = new JLabel("");
		panel.add(Label10);
		
		Label11 = new JLabel("");
		panel.add(Label11);
		
		Label12 = new JLabel("");
		panel.add(Label12);
		
		Label20 = new JLabel("");
		panel.add(Label20);
		
		Label21 = new JLabel("");
		panel.add(Label21);
		
		Label22 = new JLabel("");
		panel.add(Label22);
		
		JButton btnNewButton_1 = new JButton("right");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.right();
				colorMainFace();
			}
		});
		btnNewButton_1.setBounds(332, 0, 69, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.up();
				colorMainFace();
			}
		});
		btnNewButton_2.setBounds(332, 39, 69, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("left");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.left();
				colorMainFace();
			}
		});
		btnNewButton_3.setBounds(244, 39, 76, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("down");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.bottom();
				colorMainFace();
			}
		});
		btnNewButton_4.setBounds(244, 72, 76, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("back");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.back();
				colorMainFace();
			}
		});
		btnNewButton_5.setBounds(332, 72, 69, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnFrontinv = new JButton("frontinv");
		btnFrontinv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.frontinv();
				colorMainFace();
			}
		});
		btnFrontinv.setBounds(244, 113, 76, 29);
		contentPane.add(btnFrontinv);
		
		JButton btnLefinv = new JButton("lefinv");
		btnLefinv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.leftinv();
				colorMainFace();
			}
		});
		btnLefinv.setBounds(244, 153, 76, 29);
		contentPane.add(btnLefinv);
		
		JButton btnFinv = new JButton("dowinv");
		btnFinv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.bottominv();
				colorMainFace();
			}
		});
		btnFinv.setBounds(244, 194, 76, 29);
		contentPane.add(btnFinv);
		
		JButton btnRiginv = new JButton("riginv");
		btnRiginv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.rightinv();
				colorMainFace();
			}
		});
		btnRiginv.setBounds(332, 113, 69, 29);
		contentPane.add(btnRiginv);
		
		JButton btnBackinv = new JButton("upinv");
		btnBackinv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.upinv();
				colorMainFace();
			}
		});
		btnBackinv.setBounds(332, 153, 69, 29);
		contentPane.add(btnBackinv);
		
		JButton btnBacinv = new JButton("bacinv");
		btnBacinv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.backinv();
				colorMainFace();
			}
		});
		btnBacinv.setBounds(332, 194, 69, 29);
		contentPane.add(btnBacinv);
		
		JButton btnx = new JButton("x");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.x();
				colorMainFace();
			}
		});
		btnx.setBounds(0, 235, 117, 29);
		contentPane.add(btnx);
		
		JButton btnxprime = new JButton("x'");
		btnxprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.xprime();
				colorMainFace();
			}
		});
		btnxprime.setBounds(128, 235, 117, 29);
		contentPane.add(btnxprime);
		
		JButton btny = new JButton("y");
		btny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.y();
				colorMainFace();
			}
		});
		btny.setBounds(0, 276, 117, 29);
		contentPane.add(btny);
		
		JButton btnyprime = new JButton("y'");
		btnyprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.yprime();
				colorMainFace();
			}
		});
		
		btnyprime.setBounds(128, 276, 117, 29);
		contentPane.add(btnyprime);
		
		JButton btnz = new JButton("z");
		btnz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.z();
				colorMainFace();
			}
		});
		btnz.setBounds(0, 318, 117, 29);
		contentPane.add(btnz);
		
		JButton btnzprime = new JButton("z'");
		btnzprime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.zprime();
				colorMainFace();
			}
		});
		btnzprime.setBounds(128, 318, 117, 29);
		contentPane.add(btnzprime);
		
		JButton btnNewButton = new JButton("front");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.front();
				colorMainFace();
			}
		});
		btnNewButton.setBounds(244, 0, 76, 29);
		contentPane.add(btnNewButton);
		
		// on load, first current face will be white as default (look a mainCube class)
		this.colorMainFace();
		
	}
}
