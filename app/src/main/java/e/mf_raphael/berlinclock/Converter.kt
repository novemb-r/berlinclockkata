package e.mf_raphael.berlinclock

import android.util.Log

class Converter {

    private var _hour: Int = 0
    private var _min: Int = 0
    private var _sec: Int = 0

    var convSingleMinRow: String = ""


    fun setDate(hour: Int, min: Int, second: Int) : Converter {
        _hour = hour
        _min = min
        _sec = second
        convert()

        return this
    }

    private fun convert() {
        convertToSingleMinRow()
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


    override fun toString(): String {
        return convSingleMinRow
    }
}