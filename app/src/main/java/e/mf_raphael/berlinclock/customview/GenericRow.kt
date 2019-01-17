package e.mf_raphael.berlinclock.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import e.mf_raphael.berlinclock.R
import kotlinx.android.synthetic.main.genericrow.view.*

class GenericRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : LinearLayoutCompat(context, attrs, defStyle) {

    var row: String = ""

    init {
        LayoutInflater.from(context)
                .inflate(R.layout.genericrow, this, true)
        createView()
    }

    fun updateRow(value: String) {
        this.row = value
        updateView()
    }

    private fun createView() {
        parent_layout.weightSum = row.length * 1f
        for (i in 0 until row.length) {
            val v = View(context, null, 0, R.style.bearingpoint)
            v.layoutParams = LayoutParams(0, LayoutParams.MATCH_PARENT, 1f)
            setBackgroundItem(v, i)
            parent_layout.addView(v)
        }
    }

    private fun updateView() {
        parent_layout.weightSum = row.length * 1f
        for (i in 0 until row.length) {
            var v: View? = null
            val child = parent_layout.getChildAt(i)
            if (child != null)
                v = child
            else
                v = View(context, null, 0, R.style.bearingpoint)

            v.layoutParams = LayoutParams(0, LayoutParams.MATCH_PARENT, 1f)
            setBackgroundItem(v, i)

            if (child == null)
                parent_layout.addView(v)
        }
    }

    private fun setBackgroundItem(v: View, i : Int) {
        if (row[i] == 'R')
            v.setBackgroundColor(ContextCompat.getColor(context, R.color.katared))
        else if (row[i] == 'Y')
            v.setBackgroundColor(ContextCompat.getColor(context, R.color.kataOrange))
        else
            v.setBackgroundColor(ContextCompat.getColor(context, R.color.katablack))
    }
}