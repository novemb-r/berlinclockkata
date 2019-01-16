package e.mf_raphael.berlinclock.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import e.mf_raphael.berlinclock.R
import kotlinx.android.synthetic.main.fiveminutesrow.view.*
import kotlinx.android.synthetic.main.singleminutesrow.view.*

class FiveMinutesRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : LinearLayoutCompat(context, attrs, defStyle) {

    var row: String = "YYRYYROOOOO"

    init {
        LayoutInflater.from(context)
                .inflate(R.layout.fiveminutesrow, this, true)
        updateView()
    }

    private fun updateView() {
        val childCount = parent_layout.childCount
        for (i in 0 until childCount) {
            if (row.length > i) {
                val v: View = parent_layout.getChildAt(i)
                if (row[i] == 'R')
                    v.setBackgroundColor(ContextCompat.getColor(context, R.color.katared))
                else if (row[i] == 'Y')
                    v.setBackgroundColor(ContextCompat.getColor(context, R.color.kataOrange))
            }
        }
    }
}