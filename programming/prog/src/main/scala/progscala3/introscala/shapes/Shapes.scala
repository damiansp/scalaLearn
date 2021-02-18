package progscala3.introscala.shapes


case class Point(x: Double=0.0, y: Double=0.0)


abstract class Shape():
  /**
   * Draw the shape
   * @param f is a function to which the shape will pass a string version of 
   *   itself to be rendered
   */
  def draw(f: String => Unit): Unit = f(s"draw: $this")


case class Circle(center: Point, radius: Double) extends Shape


case class Rectangle(
  lowerLeft: Point, height: Double, width: Double
) extends Shape


case class Triangle(point1: Point, point2: Point, point3: Point) extends Shape

