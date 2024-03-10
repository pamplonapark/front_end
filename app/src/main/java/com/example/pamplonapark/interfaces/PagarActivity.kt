package com.example.pamplonapark.interfaces

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pamplonapark.MainActivity
import com.example.pamplonapark.R

/**
 * Activity to manage the payment of the parking space
 * This activity allows users to pay for the parking space
 */
class PagarActivity : AppCompatActivity() {
    private lateinit var btnPagar: Button
    private lateinit var btnVolver: ImageView
    private lateinit var txtPrecio: TextView
    private lateinit var txtZona: TextView

    /**
     * Method called when the activity is created.
     * UI components are initialized, listeners are set up
     * and the price and zone values are inserted.
     *
     *
     * @param savedInstanceState Previous instance data if exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar)

        btnPagar = findViewById(R.id.btn_pagar)
        btnVolver = findViewById(R.id.icon_back)
        txtPrecio = findViewById(R.id.txt_info_precio)
        txtZona = findViewById(R.id.txt_info_zona)

        //txtPrecio.text =
        //txtZona.text =

        btnPagar.setOnClickListener {
            pagar()
        }
        btnVolver.setOnClickListener {
            finish()
        }
    }

    fun pagar() {


        finish()
    }
    /**
     * Method called when it's requested for the activity to finish.
     * Redirects the user to the menu activity after a brief delay.
     */
    override fun finish() {
        startActivity(Intent(this, MenuActivity::class.java))
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            super.finish()
        }, 1500)
    }
}