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
        makeButtonEvt(R.id.btn_red)
        makeButtonEvt(R.id.btn_yellow)
        makeButtonEvt(R.id.btn_green)
        makeButtonEvt(R.id.btn_blue)

        /* Row 2 */
        makeButtonEvt(R.id.btn_1)
        makeButtonEvt(R.id.btn_2)
        makeButtonEvt(R.id.btn_3)
        makeButtonEvt(R.id.btn_4)

        /* Row 3 */
        makeButtonEvt(R.id.btn_5)
        makeButtonEvt(R.id.btn_6)
        makeButtonEvt(R.id.btn_7)
        makeButtonEvt(R.id.btn_8)

        /* Row 4 */
        makeButtonEvt(R.id.btn_9)
        makeButtonEvt(R.id.btn_0)
        makeButtonEvt(R.id.btn_pause)
        makeButtonEvt(R.id.btn_rec)

        /* Row 5 */
        makeButtonEvt(R.id.btn_vol_minus)
        makeButtonEvt(R.id.btn_up)
        makeButtonEvt(R.id.btn_mute)
        makeButtonEvt(R.id.btn_vol_plus)

        /* Row 6 */
        makeButtonEvt(R.id.btn_left)
        makeButtonEvt(R.id.btn_ok)
        makeButtonEvt(R.id.btn_right)
        makeButtonEvt(R.id.btn_pgm_plus)

        /* Row 7 */
        makeButtonEvt(R.id.btn_power)
        makeButtonEvt(R.id.btn_down)
        makeButtonEvt(R.id.btn_free)
        makeButtonEvt(R.id.btn_pgm_minus)
    }

    private fun makeButtonEvt(id: Int) {
        val btn: Button = findViewById(id)
        btn.setOnClickListener { buttonPressed(btn) }
        btn.setOnLongClickListener { buttonLongPressed(btn) }
    }

    private fun buttonPressed(btn: Button) {
        when (btn.id) {
            R.id.btn_red -> SendKey("red",false)
            R.id.btn_yellow -> SendKey("yellow",false)
            R.id.btn_green -> SendKey("green",false)
            R.id.btn_blue -> SendKey("blue",false)

            R.id.btn_1 -> SendKey("1",false)
            R.id.btn_2 -> SendKey("2",false)
            R.id.btn_3 -> SendKey("3",false)
            R.id.btn_4 -> SendKey("4",false)

            R.id.btn_5 -> SendKey("5",false)
            R.id.btn_6 -> SendKey("6",false)
            R.id.btn_7 -> SendKey("7",false)
            R.id.btn_8 -> SendKey("8",false)

            R.id.btn_9 -> SendKey("9",false)
            R.id.btn_0 -> SendKey("0",false)
            R.id.btn_pause -> SendKey("pause ",false) /* ????????????????? */
            R.id.btn_rec -> SendKey("rec",false)

            R.id.btn_vol_minus -> SendKey("vol_dec",false)
            R.id.btn_up -> SendKey("up",false)
            R.id.btn_mute -> SendKey("mute",false)
            R.id.btn_vol_plus -> SendKey("vol_inc",false)

            R.id.btn_left -> SendKey("left",false)
            R.id.btn_ok -> SendKey("ok",false)
            R.id.btn_right -> SendKey("right",false)
            R.id.btn_pgm_plus -> SendKey("prgm_inc",false)

            R.id.btn_power -> SendKey("power",false)
            R.id.btn_down -> SendKey("down",false)
            R.id.btn_free -> SendKey("home",false)
            R.id.btn_pgm_minus -> SendKey("prgm_dec",false)

        }
    }

    private fun buttonLongPressed(btn: Button): Boolean {
        when (btn.id) {
            R.id.btn_red -> SendKey("red",true)
            R.id.btn_yellow -> SendKey("yellow",true)
            R.id.btn_green -> SendKey("green",true)
            R.id.btn_blue -> SendKey("blue",true)

            R.id.btn_1 -> SendKey("1",true)
            R.id.btn_2 -> SendKey("2",true)
            R.id.btn_3 -> SendKey("3",true)
            R.id.btn_4 -> SendKey("4",true)

            R.id.btn_5 -> SendKey("5",true)
            R.id.btn_6 -> SendKey("6",true)
            R.id.btn_7 -> SendKey("7",true)
            R.id.btn_8 -> SendKey("8",true)

            R.id.btn_9 -> SendKey("9",true)
            R.id.btn_0 -> SendKey("0",true)
            R.id.btn_pause -> SendKey("pause ",true) /* ????????????????? */
            R.id.btn_rec -> SendKey("rec",true)

            R.id.btn_vol_minus -> SendKey("vol_dec",true)
            R.id.btn_up -> SendKey("up",true)
            R.id.btn_mute -> SendKey("mute",true)
            R.id.btn_vol_plus -> SendKey("vol_inc",true)

            R.id.btn_left -> SendKey("left",true)
            R.id.btn_ok -> SendKey("ok",true)
            R.id.btn_right -> SendKey("right",true)
            R.id.btn_pgm_plus -> SendKey("prgm_inc",true)

            R.id.btn_power -> SendKey("power",true)
            R.id.btn_down -> SendKey("down",true)
            R.id.btn_free -> SendKey("home",true)
            R.id.btn_pgm_minus -> SendKey("prgm_dec",true)
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
            "http://hd1.freebox.fr/pub/remote_control?code=$editTextRemoteCode&key=$Key"
        if (longpress) serverurl = "$serverurl&long=true"

        Log.d("SendKey !",serverurl)
        // synchronousGetRequest("$serverurl")
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
