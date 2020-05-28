package com.window;

import javax.swing.JFrame;

public class one extends JFrame {

	private static final long serialVersionUID = 1L;

	public one(){
		initUI800X600();
	}

    private void initUI800X600() {
        setTitle("Ventana de ejemplo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
