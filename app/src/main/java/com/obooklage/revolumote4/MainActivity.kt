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
        makeButtonEvt(R.id.button_red)
        makeButtonEvt(R.id.button_yellow)
        makeButtonEvt(R.id.button_green)
        makeButtonEvt(R.id.button_blue)

        /* Row 2 */
        makeButtonEvt(R.id.button_1)
        makeButtonEvt(R.id.button_2)
        makeButtonEvt(R.id.button_3)
        makeButtonEvt(R.id.button_4)

        /* Row 3 */
        makeButtonEvt(R.id.button_5)
        makeButtonEvt(R.id.button_6)
        makeButtonEvt(R.id.button_7)
        makeButtonEvt(R.id.button_8)

        /* Row 4 */
        makeButtonEvt(R.id.button_9)
        makeButtonEvt(R.id.button_0)
        makeButtonEvt(R.id.button_play) /* PAUSE ? */
        makeButtonEvt(R.id.button_rec)

        /* Row 5 */
        makeButtonEvt(R.id.button_vol_dec)
        makeButtonEvt(R.id.button_up)
        makeButtonEvt(R.id.button_mute)
        makeButtonEvt(R.id.button_vol_inc)

        /* Row 6 */
        makeButtonEvt(R.id.button_left)
        makeButtonEvt(R.id.button_ok)
        makeButtonEvt(R.id.button_right)
        makeButtonEvt(R.id.button_prgm_inc)

        /* Row 7 */
        makeButtonEvt(R.id.button_power)
        makeButtonEvt(R.id.button_down)
        makeButtonEvt(R.id.button_home)
        makeButtonEvt(R.id.button_prgm_dec)
    }

    private fun makeButtonEvt(id: Int) {
        val btn: Button = findViewById(id)
        btn.setOnClickListener { buttonPressed(btn) }
        btn.setOnLongClickListener { buttonLongPressed(btn) }
    }

    private fun buttonPressed(btn: Button) {
        when (btn.id) {
            R.id.button_red -> sendKey("red",false)
            R.id.button_yellow -> sendKey("yellow",false)
            R.id.button_green -> sendKey("green",false)
            R.id.button_blue -> sendKey("blue",false)

            R.id.button_1 -> sendKey("1",false)
            R.id.button_2 -> sendKey("2",false)
            R.id.button_3 -> sendKey("3",false)
            R.id.button_4 -> sendKey("4",false)

            R.id.button_5 -> sendKey("5",false)
            R.id.button_6 -> sendKey("6",false)
            R.id.button_7 -> sendKey("7",false)
            R.id.button_8 -> sendKey("8",false)

            R.id.button_9 -> sendKey("9",false)
            R.id.button_0 -> sendKey("0",false)
            R.id.button_play -> sendKey("pause",false) /* ????????????????? */
            R.id.button_rec -> sendKey("rec",false)

            R.id.button_vol_dec -> sendKey("vol_dec",false)
            R.id.button_up -> sendKey("up",false)
            R.id.button_mute -> sendKey("mute",false)
            R.id.button_vol_inc -> sendKey("vol_inc",false)

            R.id.button_left -> sendKey("left",false)
            R.id.button_ok -> sendKey("ok",false)
            R.id.button_right -> sendKey("right",false)
            R.id.button_prgm_inc -> sendKey("prgm_inc",false)

            R.id.button_power -> sendKey("power",false)
            R.id.button_down -> sendKey("down",false)
            R.id.button_home -> sendKey("home",false)
            R.id.button_prgm_dec -> sendKey("prgm_dec",false)

        }
    }

    private fun buttonLongPressed(btn: Button): Boolean {
        when (btn.id) {
            R.id.button_red -> sendKey("red",true)
            R.id.button_yellow -> sendKey("yellow",true)
            R.id.button_green -> sendKey("green",true)
            R.id.button_blue -> sendKey("blue",true)

            R.id.button_1 -> sendKey("1",true)
            R.id.button_2 -> sendKey("2",true)
            R.id.button_3 -> sendKey("3",true)
            R.id.button_4 -> sendKey("4",true)

            R.id.button_5 -> sendKey("5",true)
            R.id.button_6 -> sendKey("6",true)
            R.id.button_7 -> sendKey("7",true)
            R.id.button_8 -> sendKey("8",true)

            R.id.button_9 -> sendKey("9",true)
            R.id.button_0 -> sendKey("0",true)
            R.id.button_play -> sendKey("pause",true) /* ????????????????? */
            R.id.button_rec -> sendKey("rec",true)

            R.id.button_vol_dec -> sendKey("vol_dec",true)
            R.id.button_up -> sendKey("up",true)
            R.id.button_mute -> sendKey("mute",true)
            R.id.button_vol_inc -> sendKey("vol_inc",true)

            R.id.button_left -> sendKey("left",true)
            R.id.button_ok -> sendKey("ok",true)
            R.id.button_right -> sendKey("right",true)
            R.id.button_prgm_inc -> sendKey("prgm_inc",true)

            R.id.button_power -> sendKey("power",true)
            R.id.button_down -> sendKey("down",true)
            R.id.button_home -> sendKey("home",true)
            R.id.button_prgm_dec -> sendKey("prgm_dec",true)
        }
        return true
    }

    private fun sendKey(key: String, longpress: Boolean) {
        /*
        editTextRemoteCode = prefs.getString("editTextRemoteCode", "")
        if (editTextRemoteCode.contentEquals("")) {
            Toast.makeText(this, getString(R.string.main_code_missing), Toast.LENGTH_SHORT).show()
            return
        }*/

        val editTextRemoteCode = "12345"
        var serverurl =
            "http://hd1.freebox.fr/pub/remote_control?code=$editTextRemoteCode&key=$key"
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
