package e.mf_raphael.berlinclock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singleminutesrow.updateRow("YYYO")
        fiveminutesrow.updateRow("YYRYYROOOOO")
        singlehoursrow.updateRow("YYOO")
        fourhoursrow.updateRow("YOOO")
    }
}
