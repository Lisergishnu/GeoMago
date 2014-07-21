package org.poo.geomago.etc;

/*
 * Author: Havard Rast Blok
 * Web   : www.rememberjava.com
 */

import java.awt.*;
import java.awt.geom.*;


/*
 * Class to represent a Triangle.
 * Implementing the java.awt.Shape inteface.
 */
public class TriangleShape extends RectangularShape
{
  private Polygon poly;

  public TriangleShape( Polygon p )
  {
    poly = p;
  }
  
  /*
   * Extension of original Triangle shape code
   * Makes a triangle shape pointing upwards
   * constrained into the defined box.
   * 
   * @param x X coordinate
   * @param y Y coordinate
   * @param w Width
   * @param h Height
   * 
   * @author Marco Benzi
   */
  public TriangleShape(int x, int y, int w, int h) {
	  poly = new Polygon();
	  poly.addPoint(x, y+h);
	  poly.addPoint(x+w, y+h);
	  poly.addPoint(x+w/2, y);
  }
  
  public TriangleShape( Point p1, Point p2, Point p3 )
  {
    poly = new Polygon();
    poly.addPoint( p1.x, p1.y );
    poly.addPoint( p2.x, p2.y );
    poly.addPoint( p3.x, p3.y );
  }
  
  public TriangleShape(double x, double y, double w, double h) {
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

  public Rectangle getBounds()
  {
    return poly.getBounds();
  }

  public Rectangle2D getBounds2D()
  {
    return poly.getBounds2D();
  }

  public boolean contains(double x, double y)
  {
    return poly.contains(x, y);
  }

  public boolean contains(Point2D p)
  {
    return poly.contains(p);
  }

  public boolean intersects(double x, double y, double w, double h)
  {
    return poly.intersects(x, y, w, h);
  }

  public boolean intersects(Rectangle2D r)
  {
    return poly.intersects(r);
  }

  public boolean contains(double x, double y, double w, double h)
  {
    return poly.contains(x, y, w, h);
  }

  public boolean contains(Rectangle2D r)
  {
    return poly.intersects(r);
  }

  public PathIterator getPathIterator(AffineTransform at)
  {
    return poly.getPathIterator(at);
  }

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