package org.poo.geomago.etc;

import java.awt.*;
import java.awt.geom.*;

public class PentagonShape extends RectangularShape
{
	  private Polygon poly;

	  public PentagonShape( Polygon p )
	  {
	    poly = p;
	  }

	  /*
	   * Extension of original Triangle shape code
	   * Makes a pentagon shape pointing upwards
	   * constrained into the defined box.
	   * 
	   * @param x X coordinate
	   * @param y Y coordinate
	   * @param w Width
	   * @param h Height
	   */
	  
	  public PentagonShape(int x, int y, int w, int h) {
		  poly = new Polygon();
		  int w2 = (int) (w*0.14);
		  int w3 = (int) (w*0.86);
		  int h2 = (int) (h*.425);
 		  poly.addPoint(x+w/2, y);
		  poly.addPoint(x, y+h2);
		  poly.addPoint(x+w2, y+h);
		  poly.addPoint(x+w3, y+h);
		  poly.addPoint(x+w, y+h2);
	  }	  
	  
	  public PentagonShape(double x, double y, double w, double h) {
			this((int)x,(int)y,(int)w,(int)h);
		}
	  
	  public void draw( Graphics g )
	  {
	    g.drawPolygon( poly );
	  }

	  public void fill( Graphics g )
	  {
	    g.fillPolygon( poly );
	  }
	  
	  //methods implemented from interface Shape

	  @Override
	public Rectangle getBounds()
	  {
	    return poly.getBounds();
	  }

	  @Override
	public Rectangle2D getBounds2D()
	  {
	    return poly.getBounds2D();
	  }

	  @Override
	public boolean contains(double x, double y)
	  {
	    return poly.contains(x, y);
	  }

	  @Override
	public boolean contains(Point2D p)
	  {
	    return poly.contains(p);
	  }

	  @Override
	public boolean intersects(double x, double y, double w, double h)
	  {
	    return poly.intersects(x, y, w, h);
	  }

	  @Override
	public boolean intersects(Rectangle2D r)
	  {
	    return poly.intersects(r);
	  }

	  @Override
	public boolean contains(double x, double y, double w, double h)
	  {
	    return poly.contains(x, y, w, h);
	  }

	  @Override
	public boolean contains(Rectangle2D r)
	  {
	    return poly.intersects(r);
	  }

	  @Override
	public PathIterator getPathIterator(AffineTransform at)
	  {
	    return poly.getPathIterator(at);
	  }

	  @Override
	public PathIterator getPathIterator(AffineTransform at, double flatness)
	  {
	    return poly.getPathIterator(at, flatness);
	  }

	@Override
	public double getHeight() {
		return poly.getBounds2D().getHeight();
	}

	@Override
	public double getWidth() {
		return poly.getBounds2D().getWidth();
	}

	@Override
	public double getX() {
		return poly.getBounds2D().getX();
	}

	@Override
	public double getY() {
		return poly.getBounds2D().getY();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFrame(double x, double y, double w, double h) {
		Rectangle2D r = poly.getBounds2D();
		double mX = r.getX();
		double mY = r.getY();
		poly.translate((int) (x - mX), (int) (y - mY));
	}

   
}
