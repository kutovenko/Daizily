package com.blogspot.alexeykutovenko.daizily.ui.fragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.blogspot.alexeykutovenko.daizily.R
import com.blogspot.alexeykutovenko.daizily.ui.fragment.dummy.DummyContent
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter

class TodayAdapter  (private val mValues: List<DummyContent.DummyItem>,
private val mListener: TodayFragment.OnListFragmentInteractionListener?
) : DragDropSwipeAdapter<DummyContent.DummyItem, TodayAdapter.ViewHolder>(mValues){
    override fun getViewToTouchToStartDraggingItem(
        item: DummyContent.DummyItem,
        viewHolder: ViewHolder,
        position: Int
    ): View? {
        return viewHolder.dragIcon
    }

    override fun onBindViewHolder(item: DummyContent.DummyItem, viewHolder: ViewHolder, position: Int) {
        viewHolder.itemText.text = item.content
    }

    override fun getViewHolder(itemView: View) = TodayAdapter.ViewHolder(itemView)

//    override fun getItemCount(): Int = mValues.size //todo why not needed????

    class ViewHolder(itemView: View) : DragDropSwipeAdapter.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.item_text)
        val dragIcon: ImageView = itemView.findViewById(R.id.drag_icon)
    }
}