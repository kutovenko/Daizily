package com.blogspot.alexeykutovenko.daizily.ui.fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.blogspot.alexeykutovenko.daizily.R

import com.blogspot.alexeykutovenko.daizily.ui.fragment.TomorrowFragment.OnListFragmentInteractionListener
import com.blogspot.alexeykutovenko.daizily.ui.fragment.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.item_todolist.view.*

class TomorrowAdapter(
    private val mValues: List<DummyItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<TomorrowAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todolist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size // todo why here we need it and in TodayAdapter not??

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_text
        val mContentView: TextView = mView.item_text

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
