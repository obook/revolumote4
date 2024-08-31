package com.obooklage.revolumote4

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity

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
    }

    private fun buttonPressed(Button: Button) {
        Log.d("FREEBOX !",Button.getText().toString())
    }
}
