package com.example.recyclerview_cardview_example

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class PizzaRecipeAdapter(
    var pizzaRecipeItems: ArrayList<PizzaRecipeItem>,
    var context: Context
) : RecyclerView.Adapter<PizzaRecipeAdapter.PizzaRecipeViewHolder?>() {
    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): PizzaRecipeViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.pizza_recipe_item,
            viewGroup, false
        )
        return PizzaRecipeViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull viewHolder: PizzaRecipeViewHolder, i: Int) {
        val pizzaRecipeItem = pizzaRecipeItems[i]
        viewHolder.pizzaImageView.setImageResource(pizzaRecipeItem.imageResource)
        viewHolder.title.text = pizzaRecipeItem.title
        viewHolder.description.text = pizzaRecipeItem.description
    }

    override fun getItemCount(): Int {
        return pizzaRecipeItems.size
    }

    inner class PizzaRecipeViewHolder(@NonNull itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var pizzaImageView: ImageView
        var title: TextView
        var description: TextView
        override fun onClick(v: View) {
            val position: Int = adapterPosition
            val pizzaRecipeItem = pizzaRecipeItems[position]
            val intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra("imageResource", pizzaRecipeItem.imageResource)
            intent.putExtra("title", pizzaRecipeItem.title)
            intent.putExtra("description", pizzaRecipeItem.description)
            intent.putExtra("recipe", pizzaRecipeItem.recipe)
            context.startActivity(intent)
        }

        init {
            itemView.setOnClickListener(this)
            pizzaImageView = itemView.findViewById(R.id.pizzaImageView)
            title = itemView.findViewById(R.id.titleTextView)
            description = itemView.findViewById(R.id.descriptionTextView)
        }
    }
}