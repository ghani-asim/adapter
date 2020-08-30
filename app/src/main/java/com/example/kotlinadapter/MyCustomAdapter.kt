package com.example.kotlinadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyCustomAdapter(context: Context, private val presidents: MutableList<President>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_item, parent, false)

        val thisPresident = presidents[position]

        var tv = rowView.findViewById(R.id.txtName) as TextView
        tv.text = thisPresident.name

        tv = rowView.findViewById(R.id.txtStart) as TextView
        tv.text = Integer.toString(thisPresident.startDuty)

        tv = rowView.findViewById(R.id.txtEnd) as TextView
        tv.text = Integer.toString(thisPresident.endDuty)

        return rowView
    }

    override fun getItem(position: Int): Any {
        return presidents[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return presidents.size
    }

}