package e.mf_raphael.berlinclock

import android.util.Log

class Converter {

    private var _hour: Int = 0
    private var _min: Int = 0
    private var _sec: Int = 0

    var convSingleMinRow: String = ""
    var convFiveMinRow: String = ""
    var convSingleHoursRow: String = ""
    var convFourHoursRow: String = ""
    var convSecondRow: String = ""


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
        convertToSingleHoursRow()
        convertToFourHoursRow()
        convertToSecondRow()
    }

    private fun convertToSingleMinRow() {
        convSingleMinRow = ""
        val nbrLight: Int = _min % 5

        for (i in 0 until 4) {
            if (i < nbrLight)
                convSingleMinRow += 'Y'
            else
                convSingleMinRow += 'O'
        }
    }

    private fun convertToFiveMinRow() {
        convFiveMinRow = ""
        val nbrLight: Int = _min / 5 + 1 //+1 because we start at 1 in the loop

        Log.d("kata", nbrLight.toString())

        for (i in 1 until 12) { //start to 1 to be sync with the view
            if (i < nbrLight && i %3 == 0)
                convFiveMinRow += 'R'
            else if (i < nbrLight)
                convFiveMinRow += 'Y'
            else
                convFiveMinRow += 'O'
        }
    }

    private fun convertToSingleHoursRow() {
        convSingleHoursRow = ""
        val nbrLight: Int = _hour % 5

        for (i in 0 until 4) {
            if (i < nbrLight)
                convSingleHoursRow += 'R'
            else
                convSingleHoursRow += 'O'
        }
    }

    private fun convertToFourHoursRow() {
        convFourHoursRow = ""
        val nbrLight: Int = _hour / 5

        for (i in 0 until 4) {
            if (i < nbrLight)
                convFourHoursRow += 'R'
            else
                convFourHoursRow += 'O'
        }
    }

    private fun convertToSecondRow() {
        convSecondRow = "O"

        if (_sec % 2 == 0)
            convSecondRow = "Y"
    }

    override fun toString(): String {
        return convSecondRow + convFourHoursRow + convSingleHoursRow + convFiveMinRow + convSingleMinRow
    }
}