package com.example.knowledgehub

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class TechnologiesActivity : AppCompatActivity() {

    companion object {
        private const val CALL_PHONE_PERMISSION_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_technologies)

        val androidCard = findViewById<CardView>(R.id.card_android)
        val iosCard = findViewById<CardView>(R.id.card_ios)
        val webCard = findViewById<CardView>(R.id.card_web)
        val mlCard = findViewById<CardView>(R.id.card_ml)
        val blockchainCard = findViewById<CardView>(R.id.card_blockchain)
        val web3Card = findViewById<CardView>(R.id.card_web3)
        val callUsButton = findViewById<Button>(R.id.call_us_button)

        androidCard.setOnClickListener { openDetailActivity("Android App Dev") }
        iosCard.setOnClickListener { openDetailActivity("IOS App Dev") }
        webCard.setOnClickListener { openDetailActivity("Web Dev") }
        mlCard.setOnClickListener { openDetailActivity("ML") }
        blockchainCard.setOnClickListener { openDetailActivity("BlockChain") }
        web3Card.setOnClickListener { openDetailActivity("Web3") }

        callUsButton.setOnClickListener {
            checkPermissionAndMakeCall()
        }
    }

    private fun checkPermissionAndMakeCall() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), CALL_PHONE_PERMISSION_REQUEST_CODE)
        } else {
            makeCall()
        }
    }

    private fun makeCall() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:+917012789421")
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CALL_PHONE_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                makeCall()
            } else {
                Toast.makeText(this, "Permission denied. Cannot make a call.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openDetailActivity(title: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("TITLE", title)
        startActivity(intent)
    }
}