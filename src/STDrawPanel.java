import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

//		STDrawPanel drawPanel = new STDrawPanel();
//		STMouseAdapter mAdapter = new STMouseAdapter(drawPanel);
//		drawPanel.addMouseListener(mAdapter);
//		drawPanel.addMouseMotionListener(mAdapter);
//

@SuppressWarnings("serial")
public class STDrawPanel extends JPanel {
	private static final int ST_WIDTH = 400;
	private static final int ST_HEIGHT = 400;
	private static final Color BACKGROUND_COLOR = Color.yellow;
	private static final Stroke STROKE = new BasicStroke(2f,
			BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	private BufferedImage bImage = new BufferedImage(ST_WIDTH, ST_HEIGHT,
			BufferedImage.TYPE_INT_RGB);
	private ArrayList<Point> points = new ArrayList<Point>();

	public STDrawPanel() {
		Graphics g = bImage.getGraphics();
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, ST_WIDTH, ST_HEIGHT);
		g.dispose();
	}

	public void clear() {
		Graphics g = bImage.getGraphics();
		g.setColor(BACKGROUND_COLOR);
		g.fillRect( 0, 0, ST_WIDTH, ST_HEIGHT);
		g.dispose();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bImage, 0, 0, null);
		Graphics2D g2 = (Graphics2D) g;
		drawCurve(g2);
	}

	private void addCurveToBufferedImage() {
		Graphics2D g2 = bImage.createGraphics();
		drawCurve(g2);
		g2.dispose();
	}

	private void drawCurve(Graphics2D g2) {
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(STROKE);
		g2.setColor(Color.black);
		if (points != null && points.size() > 1) {
			for (int i = 0; i < points.size() - 1; i++) {
				int x1 = points.get(i).x;
				int y1 = points.get(i).y;
				int x2 = points.get(i + 1).x;
				int y2 = points.get(i + 1).y;
				g2.drawLine(x1, y1, x2, y2);
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(ST_WIDTH, ST_HEIGHT);
	}

	public void curveStart(Point point) {
		points.clear();
		points.add(point);
	}

	public void curveEnd(Point point) {
		points.add(point);
		addCurveToBufferedImage();
		points.clear();
		repaint();
	}

	public void curveAdd(Point point) {
		points.add(point);
		repaint();
	}
}

