import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputHandler implements MouseMotionListener,MouseListener{

	public int mouseB,mouseX,mouseY;
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseB = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseB = -1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	if((e.getX() / Visualizer.WC) >= 0 && (e.getX() / Visualizer.WC)< Visualizer.getWidthGrid() && (e.getY() / Visualizer.HC) >= 0 && (e.getY() / Visualizer.HC) < Visualizer.getHeightGrid()) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if((e.getX() / Visualizer.WC) >= 0 && (e.getX() / Visualizer.WC)< Visualizer.getWidthGrid() && (e.getY() / Visualizer.HC) >= 0 && (e.getY() / Visualizer.HC) < Visualizer.getHeightGrid()) {
			mouseX = e.getX();
			mouseY = e.getY();
		}
	}

}
