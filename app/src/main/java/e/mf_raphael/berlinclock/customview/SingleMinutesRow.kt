package e.mf_raphael.berlinclock.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import e.mf_raphael.berlinclock.R
import kotlinx.android.synthetic.main.singleminutesrow.view.*

class SingleMinutesRow @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : LinearLayoutCompat(context, attrs, defStyle) {

    var row: String = "YYOO"

    init {
        LayoutInflater.from(context)
                .inflate(R.layout.singleminutesrow, this, true)
        updateView()
    }

    private fun updateView() {
        if (row.isNotEmpty() && row[0] == 'Y')
            firstminute?.setBackgroundColor(ContextCompat.getColor(context, R.color.kataOrange))
        if (row.length > 1 && row[1] == 'Y')
            secondminute?.setBackgroundColor(ContextCompat.getColor(context, R.color.kataOrange))
        if (row.length > 2 && row[2] == 'Y')
            thirdminute?.setBackgroundColor(ContextCompat.getColor(context, R.color.kataOrange))
        if (row.length > 3 && row[3] == 'Y')
            fourthminute?.setBackgroundColor(ContextCompat.getColor(context, R.color.kataOrange))
    }
}