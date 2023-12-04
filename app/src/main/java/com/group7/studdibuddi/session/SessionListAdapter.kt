package com.group7.studdibuddi.session

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.group7.studdibuddi.R
import com.group7.studdibuddi.Util
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class SessionListAdapter(private val context: Context, private var sessionList: List<Session>) : BaseAdapter(){

    override fun getItem(position: Int): Session {
        return sessionList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return sessionList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.session_item,null)
        val sessionImage: ImageView = view.findViewById(R.id.session_im_view)
        val sessionName: TextView = view.findViewById(R.id.session_name)
        val sessionDescription: TextView = view.findViewById(R.id.session_description)
        val sessionLocation: TextView = view.findViewById(R.id.session_location)

        sessionName.text = sessionList[position].sessionName
        sessionDescription.text = sessionList[position].description
        sessionLocation.text = context.getString(R.string.location_)+Util.getLocationStringFromInt(sessionList[position].location)

        if (sessionList[position].imageURL.isNotEmpty()) {
            Picasso.get().load(sessionList[position].imageURL).into(sessionImage)
        }

        return view
    }

    fun replace(newSessionList: List<Session>){
        sessionList = newSessionList
    }

}