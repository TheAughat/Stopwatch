package stopwatch;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Stopwatch implements ActionListener {
	
	JFrame frame;
	JButton start, stop, reset;
	JPanel butpanel;
	JLabel timecount;
	Timer timer;
	
	int seconds, minutes;
	
	Stopwatch(){
		GUIConstrStyle1();
	}
	
	public void GUIConstrStyle1() {
		frame = new JFrame("Stopwatch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(350, 270);
		frame.setLayout(null);
		
		start = new JButton("Start");
		start.addActionListener(this);
		start.setFocusable(false);
		stop = new JButton("Pause");
		stop.addActionListener(this);
		stop.setFocusable(false);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setFocusable(false);
		
		butpanel = new JPanel();
		butpanel.setLayout(new GridLayout(0, 3, 20, 20));
		butpanel.setBounds(10, 150, 310, 30);
		butpanel.add(start);
		butpanel.add(stop);
		butpanel.add(reset);
		
		timecount = new JLabel("00:00");
		timecount.setBounds(120, 20, 200, 100);
		timecount.setFont(new Font("Arial", Font.PLAIN, 32));
		
		timer = new Timer(1000, this);
		
		frame.add(timecount);
		frame.add(butpanel);
		
		frame.setVisible(true);
	}
	
	public void GUIConstrStyle2() {
		frame = new JFrame("Stopwatch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(100, 220);
		frame.setLayout(null);
		
		start = new JButton("Start");
		start.addActionListener(this);
		start.setFocusable(false);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		stop.setFocusable(false);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setFocusable(false);
		
		butpanel = new JPanel();
		butpanel.setLayout(new GridLayout(3, 0, 10, 10));
		butpanel.setBounds(10, 50, 90, 110);
		butpanel.add(start);
		butpanel.add(stop);
		butpanel.add(reset);
		
		timecount = new JLabel("00:00");
		timecount.setBounds(15, 10, 90, 30);
		timecount.setFont(new Font("Arial", Font.PLAIN, 32));
		
		timer = new Timer(60, this);
		
		frame.add(timecount);
		frame.add(butpanel);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Stopwatch();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			if (seconds == 0) {
				seconds++;
			}
			timer.start();
			reset.setEnabled(false);
			start.setEnabled(false);
		}
		
		if (e.getSource() == stop) {
			timer.stop();
			reset.setEnabled(true);
			start.setEnabled(true);
		}
		
		if (e.getSource() == reset) {
			seconds = 0;
			minutes = 0;
			timecount.setText("00:00");
		}
		
		if (e.getSource() == timer) {
			if (seconds > 59) {
				seconds = 0;
				minutes++;
			}
			if (seconds < 10 && minutes < 10) {
				timecount.setText("0" + String.valueOf(minutes) + ":0" + String.valueOf(seconds));
			}
			else if (seconds < 10 && minutes > 9) {
				timecount.setText(String.valueOf(minutes) + ":0" + String.valueOf(seconds));
			}
			else if (seconds > 9 && minutes < 10) {
				timecount.setText("0" + String.valueOf(minutes) + ":" + String.valueOf(seconds));
			}
			else if (seconds > 9 && minutes > 9) {
				timecount.setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));
			}
			seconds++;
		}
	}

}









