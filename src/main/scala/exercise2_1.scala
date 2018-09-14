// scala console ctrl + enter

object exercise2_1 {

  def main(args: Array[String]): Unit = {
    val n = 50
    var sum = 0.0
    var a = 1.0

    while(sum < n) {
      sum += (a + 1) / a
      a += 1
    }

    println(sum)
  }
}
