import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;


class STMouseAdapter extends MouseAdapter {
	private STDrawPanel drawPanel;
	private long currentTime;

	public STMouseAdapter(STDrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	
	void eventOutput(String eventDescription, MouseEvent e) {
		PrintWriter out = null;
		try {
			boolean append = true;
			File dir = new File("Test_Data/");
			
			if (!dir.exists()) {
				dir.mkdir();
			}
			FileWriter outFile = new FileWriter("Test_Data/Text.txt", append);
			out = new PrintWriter(outFile);
			out.println(e.getX() + "," + e.getY() + "," + (e.getWhen() - currentTime));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentTime = e.getWhen();
		drawPanel.curveStart(e.getPoint());
		eventOutput("Mouse pressed", e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drawPanel.curveEnd(e.getPoint());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawPanel.curveAdd(e.getPoint());
		eventOutput("Mouse dragged", e);
	}
}