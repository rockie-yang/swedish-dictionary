package knockdata

/**
 * Hello world!
 *
 */
object App {

  def main(args: Array[String]) {
    val file = "src/main/resources/folkets_sv_en_public.xml"
    val root = xml.XML.loadFile(file)

    val dictionary = root.head

    val words = (dictionary \ "word").map(wordItem => (wordItem \ "@value").text)

    println(s"total number of words ${words.size}")

    new java.io.PrintWriter("src/main/resources/words.txt") { write(words.sorted.mkString("\n")); close }
  }
}
