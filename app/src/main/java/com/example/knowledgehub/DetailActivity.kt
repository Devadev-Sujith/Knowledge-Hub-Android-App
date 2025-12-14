package com.example.knowledgehub

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class TechInfo(val name: String, val description: String)

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titleTextView = findViewById<TextView>(R.id.title_textview)
        val techListContainer = findViewById<LinearLayout>(R.id.tech_list_container)

        val title = intent.getStringExtra("TITLE") ?: "Technology"
        titleTextView.text = title
        setRainbowText(titleTextView)

        val techData = getTechData(title)

        val inflater = LayoutInflater.from(this)
        for (tech in techData) {
            val itemView = inflater.inflate(R.layout.item_tech, techListContainer, false)
            val logoImageView = itemView.findViewById<ImageView>(R.id.tech_logo)
            val descriptionTextView = itemView.findViewById<TextView>(R.id.tech_description)

            // In a real app, you would load an image from the internet here
            // For now, we'll just use the placeholder
            descriptionTextView.text = tech.description

            techListContainer.addView(itemView)
        }
    }

    private fun setRainbowText(textView: TextView) {
        val text = textView.text.toString()
        val paint = textView.paint
        val width = paint.measureText(text)
        val textShader: Shader = LinearGradient(0f, 0f, width, textView.textSize,
            intArrayOf(
                Color.parseColor("#F97C3C"),
                Color.parseColor("#F97C3C"),
                Color.parseColor("#D0649D"),
                Color.parseColor("#A450FE"),
                Color.parseColor("#6A42F8"),
                Color.parseColor("#3B35F7")
            ), null, Shader.TileMode.CLAMP)
        textView.paint.shader = textShader
        textView.invalidate()
    }

    // This is where you will hardcode your data for each category
    private fun getTechData(category: String): List<TechInfo> {
        val data = mutableListOf<TechInfo>()
        // Generating placeholder data for 20 items
        for (i in 1..20) {
            data.add(TechInfo("Tech $i", "This is a placeholder description for tech $i in the $category category."))
        }
        return data
    }
}