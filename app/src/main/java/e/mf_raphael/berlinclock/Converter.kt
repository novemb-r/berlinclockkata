package e.mf_raphael.berlinclock

import android.util.Log

class Converter {

    private var _hour: Int = 0
    private var _min: Int = 0
    private var _sec: Int = 0

    var convSingleMinRow: String = ""
    var convFiveMinRow: String = ""


    fun setDate(hour: Int, min: Int, second: Int) : Converter {
        _hour = hour
        _min = min
        _sec = second
        convert()

        return this
    }

    private fun convert() {
        convertToSingleMinRow()
        convertToFiveMinRow()
    }

    private fun convertToSingleMinRow() {
        convSingleMinRow = ""
        val nbrLight: Int = _min % 5

        for (i in 0 until 4) {
            Log.d("kata", "i = " + i.toString())
            if (i < nbrLight)
                convSingleMinRow += 'Y'
            else
                convSingleMinRow += 'O'
        }
    }

    private fun convertToFiveMinRow() {
        convFiveMinRow = ""
        val nbrLight: Int = _min / 5

        for (i in 1 until 12) { //start to 1 to be sync with the view
            if (i < nbrLight && i %3 == 0)
                convFiveMinRow += 'R'
            else if (i < nbrLight)
                convFiveMinRow += 'Y'
            else
                convFiveMinRow += 'O'
        }
    }


    override fun toString(): String {
        return convFiveMinRow + convSingleMinRow
    }
}