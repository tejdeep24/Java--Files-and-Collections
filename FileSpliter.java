package ex10;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FileSpliter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame f = new Frame("My AWT frame");
		f.setSize(300,250);
		f.setVisible(true);
		f.addWindowListener(new Myclass());
	}

}
class Myclass extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
