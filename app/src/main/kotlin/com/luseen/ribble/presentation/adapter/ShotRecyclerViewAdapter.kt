package com.luseen.ribble.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.luseen.ribble.R
import com.luseen.ribble.domain.entity.Shot
import com.luseen.ribble.presentation.adapter.holder.ShotViewHolder
import com.luseen.ribble.presentation.adapter.listener.ShotClickListener
import com.luseen.ribble.utils.inflate

/**
 * Created by Chatikyan on 04.08.2017.
 */
class ShotRecyclerViewAdapter constructor(
        private val shotList: MutableList<Shot>,
        private val shotClickListener: ShotClickListener)
    : AbstractAdapter<ShotViewHolder, Shot>(shotList) {

    override fun createViewHolder(parent: ViewGroup): ShotViewHolder {
        val shotView = parent inflate R.layout.shot_item
        val viewHolder = ShotViewHolder(shotView)
        viewHolder.itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                shotClickListener.onShotClicked(shotList[adapterPosition])
            }
        }
        return viewHolder
    }


    override fun onBind(holder: ShotViewHolder, item: Shot) {
        holder.bind(item)
    }
}