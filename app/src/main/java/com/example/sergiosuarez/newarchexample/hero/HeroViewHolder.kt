package com.example.sergiosuarez.newarchexample.hero

import android.view.View
import com.example.sergiosuarez.newarchexample.R
import com.example.sergiosuarez.newarchexample.adapter.EndlessRecyclerAdapter
import kotlinx.android.synthetic.main.layout_hero_row.view.*

class HeroViewHolder(view: View) : EndlessRecyclerAdapter.ItemViewHolder<Hero>(view) {

    override fun bind(item: Hero) {
        //Image
        //getRoundedImage(view.heroImage, item.photo)

        //Name
        view.heroName.text = item.name

        //Favorite icon
        val imageResource = if (item.isFavorite) R.drawable.ic_star_filled else R.drawable.ic_star
        view.starImage.setImageResource(imageResource)
    }

}