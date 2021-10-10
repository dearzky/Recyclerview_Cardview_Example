package com.example.recyclerview_cardview_example

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val title: TextView = findViewById(R.id.titleTextView)
        val recipe: TextView = findViewById(R.id.recipeTextView)
        val intent: Intent = intent
         title.text = intent.getStringExtra("title")
         recipe.text = intent.getStringExtra("recipe")
     }
}