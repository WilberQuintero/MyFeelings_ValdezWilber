package valdez.wilber.myfeelings_247180.utilities

import android.content.Context
import android.util.Log
import java.io.IOException

class JSONFile {
    val MY_FEELING = "data.json"

    constructor() { }

    fun saveData(context: Context, json: String) {
        try {
            context.openFileOutput(MY_FEELING, Context.MODE_PRIVATE).use {
                it.write(json.toByteArray())
            }
        }catch (e: IOException) {
            Log.e("Guardar", "Error in writing: " + e.localizedMessage)
        }
    }

    fun getData(context: Context): String {
        try {
            return context.openFileInput(MY_FEELING).bufferedReader().readLine()
        }catch (e: IOException) {
            Log.e("Obtener", "Error in fetching data: " + e.localizedMessage)
            return ""
        }
    }
}