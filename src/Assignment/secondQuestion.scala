package Assignment

object secondQuestion extends App {

  val bufferSource = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\thief_data.txt", "UTF-8")

    for (line <- bufferSource.getLines) {
      if(!line.equals(""))
        {
          println(thiefData(line,'1',0))
        }
    }
 def thiefData(s : String, p : Char , c : Int) : Int = {
   if(s.equals(""))
     c
   else if(s.charAt(0) != p)
     thiefData(s.substring(1),s.charAt(0),c+1) // counting the change in character and iteration
   else
     thiefData(s.substring(1),p,c) // iterating by reserving the prev char
 }

}
