package com.example.sergiosuarez.newarchexample.hero

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.sergiosuarez.newarchexample.R
import com.example.sergiosuarez.newarchexample.adapter.EndlessRecyclerAdapter
import com.example.sergiosuarez.newarchexample.extensions.inflate
import kotlinx.android.synthetic.main.layout_hero_row.view.*

class HeroAdapter(val clickListener: (Hero, Pair<View, String>) -> Unit, val favoriteListener: (Hero) -> Unit) :
    EndlessRecyclerAdapter<Hero>() {

    //Fix for previous versions needed
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun createItemViewHolder(parent: ViewGroup): ItemViewHolder<Hero> =
        HeroViewHolder(parent.inflate(R.layout.layout_hero_row)).apply {
            view.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    clickListener(items[adapterPosition], Pair(view.heroImage as View, view.heroImage.transitionName))
                }
            }

            view.starImage.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    favoriteListener(items[adapterPosition])
                    //updateItemView(adapterPosition)
                }
            }
        }

    //private fun updateItemView(position: Int) {
    //    val hero = items[position]
    //    hero.isFavorite = !hero.isFavorite
    //    notifyItemChanged(position)
    //}

    /**
     * Search over the adapter list the item by id and selects the favorite value
     */
    //fun updateItemView(id: Int, isFavorite: Boolean) {
    //    (items.filter { it.id == id } as MutableList<Hero>)[0].isFavorite = isFavorite
    //    notifyDataSetChanged()
    //}
}