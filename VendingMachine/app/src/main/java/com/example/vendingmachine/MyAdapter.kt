package com.example.vendingmachine

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MyAdapter( private var activity: Activity, private var items: ArrayList<BeverageModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, contentView: View?, p2: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if(contentView == null){
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            view = inflater.inflate(R.layout.list_item_layout, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }else{
            view = contentView
            viewHolder = view.tag as ViewHolder
        }

        var beverages = items[position]
        viewHolder.txtName?.text = beverages.name
        viewHolder.txtQuantity?.text = beverages.quantity.toString()
        viewHolder.beverageImg?.setImageResource(beverages.beverage_img)

        view?.setOnClickListener {
            if(beverages.quantity > 0){
                beverages.quantity --
                viewHolder.txtQuantity?.text = beverages.quantity.toString()
                notifyDataSetChanged()
//                Toast.makeText(activity, "You choose: ${beverages.name}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(activity, "Sorry, ${beverages.name} is out of stock.", Toast.LENGTH_SHORT).show()
            }
        }
        return view as View
    }

    private class ViewHolder(row:View?){
        var txtName: TextView? = null
        var txtQuantity: TextView? = null
        var beverageImg: ImageView? = null

        init {
            this.txtName = row?.findViewById(R.id.beverageName)
            this.txtQuantity = row?.findViewById(R.id.beverageQuantity)
            this.beverageImg = row?.findViewById(R.id.imageView)
        }
    }
}