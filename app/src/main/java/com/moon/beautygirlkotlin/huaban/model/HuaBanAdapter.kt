package com.moon.beautygirlkotlin.huaban.model

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.moon.beautygirlkotlin.R
import com.moon.beautygirlkotlin.listener.ViewItemListener
import com.moon.beautygirlkotlin.utils.ImageLoader
import java.util.*

/**
 * author: moon
 * created on: 18/4/4 下午4:37
 * description: 花瓣妹子 adapter
 */
class HuaBanAdapter( ) : RecyclerView.Adapter<HuaBanAdapter.OrderListHolder>(), View.OnClickListener {

    lateinit var context: Context

    override fun onClick(v: View?) {
        var position : Int = v?.getTag() as Int
        itemListener?.itemClick(v,position)
    }

    var list: ArrayList<HuaBanBody>? = null

    lateinit var itemListener : ViewItemListener

    init {
        this.list = ArrayList()
    }

    fun loadMoreData(list:List<HuaBanBody>){
        this.list?.addAll(list)
        notifyDataSetChanged()
    }

    fun refreshData(list:List<HuaBanBody>){

        if (this.list?.size!! > 0){
            this.list?.clear()
            notifyDataSetChanged()
        }

        this.list?.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: OrderListHolder?, position: Int) {

        var body : HuaBanBody = list?.get(position)!!


        ImageLoader.load(context, body.thumb, R.drawable.placeholder_image, holder!!.item_img)


        holder?.item_title?.setText(body.title)


        holder?.item_layout?.setTag(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): OrderListHolder {
        var v : View = LayoutInflater.from(parent?.context)?.inflate(R.layout.item_meng_meizi,parent,false)!!

        var holder = OrderListHolder(v)

        context = parent?.context!!

        holder?.item_layout?.setOnClickListener(this)

        return holder
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }


    class OrderListHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        var item_img : ImageView = itemView!!.findViewById<ImageView>(R.id.item_img) as ImageView

        var item_title: TextView = itemView!!.findViewById<View>(R.id.item_title) as TextView

        var item_layout: LinearLayout = itemView!!.findViewById<View>(R.id.item_layout) as LinearLayout


    }


}