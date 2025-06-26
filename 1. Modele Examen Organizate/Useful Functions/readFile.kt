import java.io.File
import java.nio.file.Paths


fun main(args: Array<String>) = runBlocking<Unit> {
    val path = Paths.get("src", "main", "resources").toAbsolutePath().toString();
    val content = readFileLineByLineUsingForEachLine("$path/in.txt");

    // BONUS: Write File
    // File(outputFilePath).writeText(newContent);
}


fun readFileLineByLineUsingForEachLine(fileName: String): String {
    var content = "";
    File(fileName).forEachLine { content += it }
    return content;
}