package com.iam.brandon.snapimages

import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.single_screen.view.*


class CardAdapter(private val myDataset: List<Bitmap>) :
        RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    class MyViewHolder(val outerLayer: RelativeLayout) : RecyclerView.ViewHolder(outerLayer)


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CardAdapter.MyViewHolder {
        val singleScreenView = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_screen, parent, false) as RelativeLayout
        return MyViewHolder(singleScreenView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.outerLayer.main_image.setImageBitmap(myDataset[position])
    }

    override fun getItemCount() = myDataset.size
}
