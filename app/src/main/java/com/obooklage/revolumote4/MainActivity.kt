package com.obooklage.revolumote4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.preference.PreferenceFragmentCompat
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_container, MySettingsFragment())
            .commit()
*/
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
            R.id.btn_red -> sendKey("red",false)
            R.id.btn_yellow -> sendKey("yellow",false)
            R.id.btn_green -> sendKey("green",false)
            R.id.btn_blue -> sendKey("blue",false)

            R.id.btn_1 -> sendKey("1",false)
            R.id.btn_2 -> sendKey("2",false)
            R.id.btn_3 -> sendKey("3",false)
            R.id.btn_4 -> sendKey("4",false)

            R.id.btn_5 -> sendKey("5",false)
            R.id.btn_6 -> sendKey("6",false)
            R.id.btn_7 -> sendKey("7",false)
            R.id.btn_8 -> sendKey("8",false)

            R.id.btn_9 -> sendKey("9",false)
            R.id.btn_0 -> sendKey("0",false)
            R.id.btn_pause -> sendKey("pause",false) /* ????????????????? */
            R.id.btn_rec -> sendKey("rec",false)

            R.id.btn_vol_minus -> sendKey("vol_dec",false)
            R.id.btn_up -> sendKey("up",false)
            R.id.btn_mute -> sendKey("mute",false)
            R.id.btn_vol_plus -> sendKey("vol_inc",false)

            R.id.btn_left -> sendKey("left",false)
            R.id.btn_ok -> sendKey("ok",false)
            R.id.btn_right -> sendKey("right",false)
            R.id.btn_pgm_plus -> sendKey("prgm_inc",false)

            R.id.btn_power -> sendKey("power",false)
            R.id.btn_down -> sendKey("down",false)
            R.id.btn_free -> sendKey("home",false)
            R.id.btn_pgm_minus -> sendKey("prgm_dec",false)

        }
    }

    private fun buttonLongPressed(btn: Button): Boolean {
        when (btn.id) {
            R.id.btn_red -> sendKey("red",true)
            R.id.btn_yellow -> sendKey("yellow",true)
            R.id.btn_green -> sendKey("green",true)
            R.id.btn_blue -> sendKey("blue",true)

            R.id.btn_1 -> sendKey("1",true)
            R.id.btn_2 -> sendKey("2",true)
            R.id.btn_3 -> sendKey("3",true)
            R.id.btn_4 -> sendKey("4",true)

            R.id.btn_5 -> sendKey("5",true)
            R.id.btn_6 -> sendKey("6",true)
            R.id.btn_7 -> sendKey("7",true)
            R.id.btn_8 -> sendKey("8",true)

            R.id.btn_9 -> sendKey("9",true)
            R.id.btn_0 -> sendKey("0",true)
            R.id.btn_pause -> sendKey("pause",true) /* ????????????????? */
            R.id.btn_rec -> sendKey("rec",true)

            R.id.btn_vol_minus -> sendKey("vol_dec",true)
            R.id.btn_up -> sendKey("up",true)
            R.id.btn_mute -> sendKey("mute",true)
            R.id.btn_vol_plus -> sendKey("vol_inc",true)

            R.id.btn_left -> sendKey("left",true)
            R.id.btn_ok -> sendKey("ok",true)
            R.id.btn_right -> sendKey("right",true)
            R.id.btn_pgm_plus -> sendKey("prgm_inc",true)

            R.id.btn_power -> sendKey("power",true)
            R.id.btn_down -> sendKey("down",true)
            R.id.btn_free -> sendKey("home",true)
            R.id.btn_pgm_minus -> sendKey("prgm_dec",true)
        }
        return true
    }

    private fun sendKey(Key: String, longpress: Boolean) {
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

        Log.d("sendKey !",serverurl)
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

class MySettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}
