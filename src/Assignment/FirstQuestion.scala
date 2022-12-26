package Assignment

object FirstQuestion extends App{

  val bufferSource = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\exam_data.txt", "UTF-8")
  for (line <- bufferSource.getLines) {
    println(line)
    if(!line.equals("")) {
      val s = line.split(",").map(_.trim).map(_.toInt)
      println(passNFail(s(0),s(1),s(2)))
    }
  }

  def passNFail(k: Int, l: Int, M: Int): String =
    if (k * l <= M) "YES"
    else
      "NO"


}
