package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class omokeMouseEventHandler extends MouseAdapter {
	private omokeMap map;
	private omokeMapSize mapSize;
	private omokeDrawBoard drawBoard;
	private omokeGUI gui;
	
	public omokeMouseEventHandler(omokeMap map, omokeMapSize mapSize, omokeDrawBoard drawBoard, omokeGUI gui) {
		this.map = map;
		this.mapSize = mapSize;
		this.drawBoard = drawBoard;
		this.gui = gui;
	}
	
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		
		int x = (int) Math.round(e.getX() / (double) mapSize.getCell()) - 1;
		int y = (int) Math.round(e.getY() / (double) mapSize.getCell()) - 2;
		if(x < 0 || x > 19 || y < 0 || y > 19) {
			return;
		}
		if(map.getXY(y,x) == map.getBlack() || map.getXY(y,x) == map.getWhite()) {
			return;
		}
		map.setMap(y,x);
		map.changeCheck();
		drawBoard.repaint();
		if(map.winCheck(x,y)) {
			if(map.getCheck()==true) {
				gui.showPopUp("백돌이 승리하였습니다.");
			}else {
				gui.showPopUp("흑돌이 승리하였습니다.");
			}
		}
	}
}
