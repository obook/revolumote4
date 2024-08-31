package com.obooklage.revolumote4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        /* Row 1 */
        makeButtonEvt(R.id.btn00)
        makeButtonEvt(R.id.btn01)
        makeButtonEvt(R.id.btn02)
        makeButtonEvt(R.id.btn03)

        /* Row 2 */
        makeButtonEvt(R.id.btn10)
        makeButtonEvt(R.id.btn11)
        makeButtonEvt(R.id.btn12)
        makeButtonEvt(R.id.btn13)

        /* Row 3 */
        makeButtonEvt(R.id.btn20)
        makeButtonEvt(R.id.btn21)
        makeButtonEvt(R.id.btn22)
        makeButtonEvt(R.id.btn23)

        /* Row 4 */
        makeButtonEvt(R.id.btn30)
        makeButtonEvt(R.id.btn31)
        makeButtonEvt(R.id.btn32)
        makeButtonEvt(R.id.btn33)

        /* Row 5 */
        makeButtonEvt(R.id.btn40)
        makeButtonEvt(R.id.btn41)
        makeButtonEvt(R.id.btn42)
        makeButtonEvt(R.id.btn43)

        /* Row 6 */
        makeButtonEvt(R.id.btn50)
        makeButtonEvt(R.id.btn51)
        makeButtonEvt(R.id.btn52)
        makeButtonEvt(R.id.btn53)

        /* Row 7 */
        makeButtonEvt(R.id.btn60)
        makeButtonEvt(R.id.btn61)
        makeButtonEvt(R.id.btn62)
        makeButtonEvt(R.id.btn63)
    }

    private fun makeButtonEvt(id: Int) {
        val btn: Button = findViewById(id)
        btn.setOnClickListener { buttonPressed(btn) }
        btn.setOnLongClickListener { buttonLongPressed(btn) }
    }

    private fun buttonPressed(btn: Button) {
        when (btn.id) {
            R.id.btn00 -> Log.d("FREEBOX !","BOUTON FLECHE !")
            R.id.btn01 -> Log.d("FREEBOX !","BOUTON INFO !")
        }
    }

    private fun buttonLongPressed(btn: Button): Boolean {
        when (btn.id) {
            R.id.btn00 -> Log.d("FREEBOX LONG !","BOUTON FLECHE !")
            R.id.btn01 -> Log.d("FREEBOX LONG !","BOUTON INFO !")
        }
        return true
    }

    private fun SendKey(Key: String, longpress: Boolean) {
        /*
        editTextRemoteCode = prefs.getString("editTextRemoteCode", "")
        if (editTextRemoteCode.contentEquals("")) {
            Toast.makeText(this, getString(R.string.main_code_missing), Toast.LENGTH_SHORT).show()
            return
        }*/

        val editTextRemoteCode = "12345"
        var serverurl =
            "http://hd1.freebox.fr/pub/remote_control?code=$editTextRemoteCode"
        if (longpress) serverurl = "$serverurl&long=true"

        Log.d("SendKey !",serverurl)
        // synchronousGetRequest("$serverurl&key=$Key")
    }

    private fun synchronousGetRequest(url: String): String {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""
    }
}
