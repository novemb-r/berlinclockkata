package e.mf_raphael.berlinclock

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val berlinClockConverter : BerlinClockConverter = BerlinClockConverter().setDate(22 ,26 ,11 )

        Log.d("kata Clock : ", berlinClockConverter.toString())

        secondrow.updateRow(berlinClockConverter.convSecondRow)
        singleminutesrow.updateRow(berlinClockConverter.convSingleMinRow)
        fiveminutesrow.updateRow(berlinClockConverter.convFiveMinRow)
        singlehoursrow.updateRow(berlinClockConverter.convSingleHoursRow)
        fourhoursrow.updateRow(berlinClockConverter.convFourHoursRow)

        Log.d("kata parse : ", BerlinClockConverter().parse("ORROOROOOYYRYYRYOOOOYYOO"))

    }
}
