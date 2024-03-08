package `in`.bitcode.resourcesandlocalisation

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var txtInfo : TextView
    private lateinit var edtInfo : EditText
    private lateinit var btnSetInfo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mt("onCreate")



        txtInfo = findViewById(R.id.txtInfo)
        edtInfo = findViewById(R.id.edtInfo)
        btnSetInfo = findViewById(R.id.btnSetInfo)

        btnSetInfo.setOnClickListener {
            txtInfo.text = edtInfo.text.toString()
        }

        //check if there is data which is backed up
        if(lastCustomNonConfigurationInstance != null) {
            mt("Got the data!")
            Log.e("TAG", "onCreate: $lastCustomNonConfigurationInstance", )
            txtInfo.text = (lastNonConfigurationInstance as MyData).data
        }

        val companyTitle = resources.getString(R.string.company_title)
        val isPasword = resources.getBoolean(R.bool.is_password)
        val width = resources.getDimension(R.dimen.text_width)
        val colorCode = resources.getColor(R.color.main_bg_color)
        val companyCode = resources.getInteger(R.integer.company_code)
        mt(companyTitle + " " + companyCode)
        val cities = resources.getStringArray(R.array.cities)
        val pinCodes = resources.getIntArray(R.array.pincodes)
        for(city in cities) {
            mt(city)
        }

        val config = resources.configuration
        //mt(config.keyboard)
        if( config.keyboard == Configuration.KEYBOARD_QWERTY){
        }
        if( config.keyboard == Configuration.KEYBOARD_12KEY){
        }

        if(config.touchscreen == Configuration.TOUCHSCREEN_FINGER){}

        if(config.orientation == Configuration.ORIENTATION_PORTRAIT) {

        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    class MyData(
        val data : String
    )

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        mt("onRetainCustomNonConfigurationInstance")
        return MyData(txtInfo.text.toString())
    }

    override fun onDestroy() {
        mt("onDestroy")
        super.onDestroy()
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}