package e.mf_raphael.berlinclock

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val converter : Converter = Converter().setDate(23,51,36)

        Log.d("kata Clock : ", converter.toString())

        singleminutesrow.updateRow(converter.convSingleMinRow)
        fiveminutesrow.updateRow(converter.convFiveMinRow)
        singlehoursrow.updateRow(converter.convSingleHoursRow)
        fourhoursrow.updateRow(converter.convFourHoursRow)

    }
}
