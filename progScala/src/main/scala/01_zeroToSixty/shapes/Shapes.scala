package zeroToSixty.shapes;


abstract class Shape() {
  /**
   * Draw takes a function arg.  Each shape will pass a stingified version of itself to this func,
   * which does the 'drawing'.
   */
  def draw(f: String => Unit): Unit = f(s"draw: ${this.toString}");
}

case class Point(x: Double = 0.0, y: Double = 0.0);
case class Circle(center: Point, radius: Double) extends Shape;
case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape;
case class Triangle(point1: Point, point2: Point, point3: Point) extends Shape;

  
