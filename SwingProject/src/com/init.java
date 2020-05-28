package com;

import java.awt.EventQueue;
import com.window.one;

/**
 * @author Tomás Delgado Acosta
 *
 */
public class init {

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			one ex = new one();
            ex.setVisible(true);
        });

	}

}
