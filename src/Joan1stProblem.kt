import org.json.CDL
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import util.JoinArrays
import java.io.*
import java.util.*

class Joan1stProblem {
    fun main(args: Array<String>){
        val jsonArray: HashMap<Int, Any> = HashMap()

        for (file in args) {
            val fis = FileInputStream(file)
            if (file.toLowerCase().endsWith(".json")) {
                val jArr = JSONArray(JSONTokener(fis))
                JoinArrays(jsonArray, jArr).join()
            } else if (file.toLowerCase().endsWith(".csv")) {
                val jArr: JSONArray = CDL.toJSONArray(JSONTokener(fis))
                JoinArrays(jsonArray, jArr).join()
            } else if (file.toLowerCase().endsWith(".txt")) {
                val bis = BufferedReader(InputStreamReader(fis))
                var line = bis.readLine()
                val sb = StringBuilder()
                while (line != null) {
                    val newLine = "\"" + line.replace("\t".toRegex(), "\",\"") + "\"\n"
                    sb.append(newLine)
                    line = bis.readLine()
                }
                val jArr: JSONArray = CDL.toJSONArray(sb.toString())
                JoinArrays(jsonArray, jArr).join()
            } else {
                throw FileNotFoundException("The file args should have the following extensions: '.json', '.csv', '.txt'")
            }
            fis.close()
        }
        val jsonArrayList: List<JSONObject> = jsonArray.values as List<JSONObject>
        Collections.sort(jsonArrayList, Comparator<JSONObject> { jsonObjectA, jsonObjectB ->
            var compare: Int
            val genreA: String = jsonObjectA.getString("Genre")
            val genreB: String = jsonObjectB.getString("Genre")
            compare = genreA.compareTo(genreB)
            if (compare == 0) {
                val authorA: String = jsonObjectA.getString("Author").split(" ").get(1)
                val authorB: String = jsonObjectB.getString("Author").split(" ").get(1)
                compare = authorA.compareTo(authorB)
            }
            if (compare == 0) {
                val authorA: String = jsonObjectA.getString("Author").split(" ").get(0)
                val authorB: String = jsonObjectB.getString("Author").split(" ").get(0)
                compare = authorA.compareTo(authorB)
            }
            compare
        } as Comparator<in Any?>?)

        val csv: String = CDL.toString(JSONArray(jsonArrayList))
        val output = FileWriter("FinalCSV.csv")
        output.write(csv)
        output.close()


    }
}