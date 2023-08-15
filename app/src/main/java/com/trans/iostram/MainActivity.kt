package com.trans.iostram

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.trans.iostram.bean.DataBean01
import com.trans.iostram.bean.DataBean02
import com.trans.iostram.bean.OJsonBean
import com.trans.iostram.ui.theme.IOStramTheme
import com.trans.iostram.utils.PermissionsUtils
import com.trans.iostram.utils.Tools
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.OutputStreamWriter
import java.nio.charset.Charset

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class MainActivity : ComponentActivity() {
    private lateinit var permissionsUtils: PermissionsUtils
    private val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IOStramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }


        permissionsUtils = PermissionsUtils.getInstance(this) {
            Thread {
                inOut()
            }.start()
        }
        permissionsUtils.checkSelfPermission()

    }

    private fun inOut() {
        val textFile01 = File(
            Environment.getExternalStorageDirectory().absolutePath +
                    "/trans/textFile/obu数据1.txt"
        )

        val textFile02 = File(
            Environment.getExternalStorageDirectory().absolutePath +
                    "/trans/textFile/obu数据2.txt"
        )

        val newFile = File(
            Environment.getExternalStorageDirectory().absolutePath +
                    "/trans/textFile/new_obu_数据07.txt"
        )


//        text01ToText02(textFile01, textFile02, newFile)

        text02(textFile01, newFile)

//        oJson2LinePoint(textFile02, newFile)
    }


    private fun oJson2LinePoint(textFile: File, newFile: File) {
        if (!newFile.exists()) newFile.createNewFile()
        val oJsonBean =
            gson.fromJson(
                loadGeoJsonFromAsset(this, "荣华南路.json"),
                OJsonBean::class.java
            )

        val latlogs = oJsonBean.objItems[0].`object`.objectDetail.latlng

        val bufferedReader01 = BufferedReader(FileReader(textFile))
        val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(newFile)))

        var text = ""
        var i = -1
        while (bufferedReader01.readLine()?.also { text = it } != null) {
            if (isJson(text)) {
                val dataBean01 = gson.fromJson(text, DataBean01::class.java)
                if (dataBean01 != null && i < latlogs.size - 2) {
                    val dataBean01 = gson.fromJson(text, DataBean01::class.java)
                    dataBean01.tpm.pos.lat = latlogs[++i]
                    dataBean01.tpm.pos.longX = latlogs[++i]

                    bufferedWriter.write(gson.toJson(dataBean01))
                    bufferedWriter.write("\r\n")
                    bufferedWriter.flush()
                }
            }
        }
        bufferedWriter.close()
        bufferedReader01.close()
    }

    private fun text02(textFile: File, newFile: File) {
        newFile.createNewFile()

        val bufferedReader02 = BufferedReader(FileReader(textFile))

        val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(newFile)))
        var text = ""
        var index = 0
        while (bufferedReader02.readLine()?.also { text = it } != null) {
            index++
            if (isJson(text)) {
                val dataBean02 = gson.fromJson(text, DataBean02::class.java)
                bufferedWriter.write(
                    gson.toJson(
                        DataBean01().apply {
                            tpm = DataBean01.TPMBean()
                            tpm.pos = DataBean01.TPMBean.PosBean()
                            val l84 =
                                Tools.GCJ02ToWGS84(dataBean02.bsm.pos.lon, dataBean02.bsm.pos.lat)
                            tpm.pos.lat = l84[1]
                            tpm.pos.longX = l84[0]
//                            tpm.pos.lat = dataBean02.bsm.pos.lat
//                            tpm.pos.longX = dataBean02.bsm.pos.lon

                            tpm.pos.elevation = dataBean02.bsm.pos.elevation
                            tpm.heading = dataBean02.bsm.heading
                            tpm.speed = dataBean02.bsm.speed
                            tpm.utcTime = dataBean02.bsm.utcTime
                        })
                )
                bufferedWriter.write("\r\n")
                if (index % 5 == 0)
                    bufferedWriter.flush()
                Log.i("tomcan", "数据写入成功($index)")
            } else {
                Log.i("tomcan", "数据写入失败: 不是json数据($index)")
            }
        }
        bufferedWriter.close()
        bufferedReader02.close()
    }


    private fun text01ToText02(textFile01: File, textFile02: File, newFile: File) {
//      val inputStream = assets.open("新数据01.txt")
        newFile.createNewFile()
        var text = ""
        val txt02s = ArrayList<String>()
        val bufferedReader02 = BufferedReader(FileReader(textFile02))
        while (bufferedReader02.readLine()?.also { text = it } != null) {
            txt02s.add(text)
        }
        bufferedReader02.close()

        val bufferedReader01 = BufferedReader(FileReader(textFile01))
        val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream(newFile)))
        var inde = 0
        while (bufferedReader01.readLine()?.also { text = it } != null) {
            if (isJson(text)) {
                val dataBean01 = gson.fromJson(text, DataBean01::class.java)
                if (dataBean01 != null) {
                    val txt02Str = txt02s[inde++]
                    if (isJson(txt02Str)) {
                        val dataBean02 = gson.fromJson(txt02Str, DataBean02::class.java)
                        val l84 = Tools.GCJ02ToWGS84(dataBean02.bsm.pos.lon, dataBean02.bsm.pos.lat)
//                        dataBean01.tpm.pos.lat = dataBean02.bsm.pos.lat
//                        dataBean01.tpm.pos.longX = dataBean02.bsm.pos.lon
                        dataBean01.tpm.pos.lat = l84[1]
                        dataBean01.tpm.pos.longX = l84[0]
                        dataBean01.tpm.pos.elevation = dataBean02.bsm.pos.elevation
                        dataBean01.tpm.heading = dataBean02.bsm.heading

                        bufferedWriter.write(gson.toJson(dataBean01))
                        bufferedWriter.write("\r\n")
                        bufferedWriter.flush()
                    }
                }
            }
        }
        bufferedWriter.close()
        bufferedReader01.close()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        permissionsUtils.onActivityResult(requestCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionsUtils.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    /**
     * 判断是否为Json格式数据
     *
     * @param json
     * @return
     */
    private val jsonParser: JsonParser = JsonParser()
    private fun isJson(json: String): Boolean {
        try {
            jsonParser.parse(json)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    fun loadGeoJsonFromAsset(context: Context, filename: String?): String? {
        return try {
            // Load GeoJSON file from local asset folder
            val `is` = context.assets.open(filename!!)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (exception: java.lang.Exception) {
            throw RuntimeException(exception)
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IOStramTheme {
        Greeting("Android")
    }
}