package org.poo.geomago.celda;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

public class CeldaView {
	private static final Color CELDA_STROKE = Color.black;
	public static final double CELDA_HEIGHT = 32;
	public static final double CELDA_WIDTH = 32;
	private static final Color CELDA_COLOR_ENABLED = Color.white;
	private static final Color CELDA_COLOR_DISABLED = Color.gray;
	private Rectangle2D.Double shape;
	private Stroke stroke;
	private int x;
	private int y;
	private boolean isEnabled;
	private Celda mCell;

	public CeldaView(Celda cell) {
		setX(cell.getX());
		setY(cell.getY());
		mCell = cell;
		shape = new Rectangle2D.Double(0,0,CELDA_WIDTH,CELDA_HEIGHT);
		stroke = new BasicStroke(2f);
	}
	
	protected void paintComponent(Graphics2D g) {
 		shape.setFrame(getX()*CELDA_WIDTH, getY()*CELDA_HEIGHT, CELDA_WIDTH, CELDA_HEIGHT);
 		switch (mCell.getmState()) {
		case NORMAL:
			g.setColor(CELDA_COLOR_ENABLED);
			break;
		case DISABLED:
			g.setColor(CELDA_COLOR_DISABLED);
			break;
		default:
			g.setColor(CELDA_COLOR_ENABLED);
			break;
		}
 		g.fill(shape);
 		g.setColor(CELDA_STROKE);
 		g.setStroke(stroke);
 		g.draw(shape);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

