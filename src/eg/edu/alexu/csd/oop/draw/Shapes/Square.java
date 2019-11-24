package eg.edu.alexu.csd.oop.draw.Shapes;

import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.*;

public class Square extends DShape {
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getFillColor());
        canvas.fillRect((int)(this.getPosition().getX() - this.getProperties().get(this.ShapeProperties[0])),
                (int)(this.getPosition().getY() - this.getProperties().get(this.ShapeProperties[0])),
                (int)(2.0 * this.getProperties().get(this.ShapeProperties[0])),
                (int)(2.0 * this.getProperties().get(this.ShapeProperties[0])));
        canvas.setColor(this.getColor());
        canvas.drawRect((int)(this.getPosition().getX() -  this.getProperties().get(this.ShapeProperties[0])),
                (int)(this.getPosition().getY() - this.getProperties().get(this.ShapeProperties[0])),
                (int)(2.0 * this.getProperties().get(this.ShapeProperties[0])),
                (int)(2.0 * this.getProperties().get(this.ShapeProperties[0])));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape clonedShape = new Square();
        this.copyShapes(clonedShape);
        return clonedShape;
    }

    @Override
    public boolean contain(Point p) {
        Point bottomleft = new Point();
        Point topright = new Point();

        bottomleft.setLocation((int)(this.getPosition().getX() - this.getProperties().get(this.ShapeProperties[0])),
                (int)(this.getPosition().getY() + this.getProperties().get(this.ShapeProperties[0])));

        topright.setLocation((int)(this.getPosition().getX() + this.getProperties().get(this.ShapeProperties[0])),
                (int)(this.getPosition().getY() - this.getProperties().get(this.ShapeProperties[0])));


        return p.getX() > bottomleft.getX() && p.getX() < topright.getX() && p.getY() < bottomleft.getY() && p.getY() > topright.getY();
    }
}
