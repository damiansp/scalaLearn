package typeLessDoMore.shapes;

abstract class Shape() {
  /**
   * Draw take TWO arg LISTS, one list with an offset for drawing, and the other list that is the
   * function arg
   */
  def draw(offset: Point = Point(0.0, 0.0))(f: String => Unit): Unit =
    f(s"draw(offset = $offset), ${this.toString}");
}
  
case class Point(x: Double = 0.0, y: Double = 0.0) {
  def shift(deltax: Double = 0.0, deltay: Double = 0.0) = copy (x + deltax, y + deltay);
}

case class Circle(center: Point, radius: Double) extends Shape;
case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape;
