package com.blogspot.alexeykutovenko.daizily.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.blogspot.alexeykutovenko.daizily.R
import com.blogspot.alexeykutovenko.daizily.ui.fragment.dummy.DummyContent
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener
import kotlinx.android.synthetic.main.fragment_today.*

/**
 * Today todos class
 */
class TodayFragment : Fragment() {

    private var listener: TodayFragment.OnListFragmentInteractionListener? = null


    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: DummyContent.DummyItem)
        //TODO implement
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataSet = DummyContent.ITEMS
        val mAdapter = TodayAdapter(dataSet, listener)
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = mAdapter
        list.swipeListener = onItemSwipeListener
    }

    private val onItemSwipeListener = object : OnItemSwipeListener<DummyContent.DummyItem> {
        override fun onItemSwiped(position: Int, direction: OnItemSwipeListener.SwipeDirection, item: DummyContent.DummyItem) {
            Toast.makeText(context, "Tomorrow ${item.id}", Toast.LENGTH_SHORT).show()
        }
    }


}
