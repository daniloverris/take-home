package util

import org.json.JSONArray
import org.json.JSONObject
import java.util.function.Consumer

class JoinArrays(jsonArray: HashMap<Int, Any>, jArr: JSONArray) {
    private var jsonArray: HashMap<Int, Any> = HashMap<Int, Any>()
    private var jArr: JSONArray? = null

    fun JoinArrays(jsonArray: HashMap<Int, Any>, jArr: JSONArray) {
        this.jsonArray = jsonArray
        this.jArr = jArr
    }
    fun join() {
        jArr!!.forEach(Consumer { item: Any ->
            val jsonObj = item as JSONObject
            val key = jsonObj.getInt("ISBN")
            if (jsonArray!![key] != null) {
                val obj = jsonArray!![key] as JSONObject?
                val qty = jsonObj.opt("Qty.").toString().trim { it <= ' ' }.toInt()
                obj!!.put("Qty.", obj.getInt("Qty.") + qty)
            } else {
                this.jsonArray.put(key, item)
            }
        })
    }
}