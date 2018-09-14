// 模拟图形绘制

case class Point(var x:Double, var y:Double) extends Drawable{
  def shift(deltaX: Double, deltaY: Double) {x += deltaX; y += deltaY}
  def - (other: Point) = {Point(x-other.x, y-other.y)}
  def * (n: Double) = {Point(n*x, n*y)}
  def -= (other: Point) = {x-=other.x; y-=other.y}
  def += (other: Point) = {x+=other.x; y+=other.y}
}

trait Drawable{
  def draw() {println(this.toString)}
}

//Shape Line Circle
abstract class Shape(var a:Point){
  var otherPoint:Point = Point(0, 0)
  var len:Double = 0.0

  def this(a:Point, otherPoint:Point) {
    this(a)
    this.otherPoint = otherPoint
  }

  def this(a:Point, len:Double) {
    this(a)
    this.len = len
  }

  def moveTo(movePoint: Point){a=movePoint}
  def zoom(delta: Double)
}

// 规定a在的位置要比otherPoint矮
class Line(a:Point, otherPoint:Point) extends Shape(a, otherPoint) {
  def draw(){
    println("Line:" + (a.x, a.y) + "--" + (otherPoint.x, otherPoint.y))
  }

  override def moveTo(movePoint: Point): Unit = {
    val dis = a - movePoint
    a -= dis
    otherPoint -= dis
  }

  def zoom(delta: Double): Unit = {
    val zoomPoint = otherPoint - a
    val zoomNum = (delta - 1) / 2
    a -= zoomPoint * zoomNum
    otherPoint += zoomPoint * zoomNum
  }
}

class Circle(center:Point, r:Double) extends Shape(center, r){
  def draw(){
    println("Circle center:" + (a.x, a.y) + "," + "R=" + len)
  }

  def zoom(delta: Double): Unit = {
    len = len * delta
  }
}

object exercise2_2 {
  def main(args: Array[String]): Unit = {
    val p=new Point(10, 30)
    p.draw
    val line1 = new Line(Point(0, 0), Point(20, 20))
    line1.draw
    line1.moveTo(Point(5, 5))
    line1.draw
    line1.zoom(2)
    line1.draw
    val cir = new Circle(Point(10, 10), 5)
    cir.draw
    cir.moveTo(Point(30, 20))
    cir.draw
    cir.zoom(0.5)
    cir.draw
  }
}
