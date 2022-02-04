package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;

class Grid extends MyFrame {

	public Grid() {
		setTitle("GridLayoutTest");

		setLayout(new GridLayout(0, 3));

		add(new JButton("Botton1"));
		add(new JButton("Botton2"));
		add(new JButton("Botton3"));
		add(new JButton("B4"));
		add(new JButton("Long Button5"));

		pack();
		setVisible(true);
	}

}

public class GridLayoutEx01 {

	public static void main(String[] args) {
		Grid grid = new Grid();

	}
}
