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
        if (hour > 24 || hour < 0)
            throw Error("hour is not good!")
        if (min > 60 || min < 0)
            throw Error("min is not good!")
        if (second > 60 || second < 0)
            throw Error("second is not good!")

        _hour = hour
        _min = min
        _sec = second
        convertToBerlinTime()

        return this
    }

    fun getDate() : String {
        return _hour.toString() + ":" + _min.toString() + ":" + _sec.toString()
    }

    private fun convertToBerlinTime() {
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

    fun parse(berlinTime: String) : String {
        if (berlinTime.length != 24)
            throw Error("Berlin time should be 24 length")

        var sec = parseSecond(berlinTime[0])
        var hours = parseHours(berlinTime.substring(1, 5), berlinTime.substring(5, 9))
        var min = parseMinutes(berlinTime.substring(9, 20), berlinTime.substring(20))

        return hours.toString()+":"+min.toString()+":"+sec.toString()
    }

    private fun parseHours(fiveRow : String, singleRow : String) : Int {
        var hour = 0

        for(i in 0 until fiveRow.length) {
            if (fiveRow[i] == 'R')
                hour += 5
        }

        for(i in 0 until singleRow.length) {
            if (singleRow[i] == 'R')
                hour++
        }

        return hour
    }

    private fun parseMinutes(fiveRow : String, singleRow : String) : Int {
        var min = 0

        for(i in 0 until fiveRow.length) {
            if (fiveRow[i] == 'Y' || fiveRow[i] == 'R')
                min += 5
        }

        for(i in 0 until singleRow.length) {
            if (singleRow[i] == 'Y')
                min++
        }

        return min
    }

    private fun parseSecond(second : Char) : Int {
        if (second == 'Y')
            return 0
        else
            return 1
    }

}