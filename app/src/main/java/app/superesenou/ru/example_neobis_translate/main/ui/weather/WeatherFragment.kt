package app.superesenou.ru.example_neobis_translate.main.ui.weather


import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.ContactWeather
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_weather.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class WeatherFragment : Fragment(),WeatherContract.View,View.OnClickListener {

    lateinit var presenter: WeatherPresenter
    var txt:String="Bishkek"

    override fun onFailure() {
        Toast.makeText(activity,"error search", Toast.LENGTH_LONG).show()
    }

    override fun onSuccessGetWeatherDate(body: ContactWeather?) {
        txtWeatherName.text= body?.location?.name
        txtWeatherLocaltime.text=body?.location?.localtime
        txtWeatherCountry.text=body?.location?.country
        txtWeatherTz_id.text=body?.location?.tz_id
        txtWeatherLast_updated.text="last_updated :"+body?.current?.last_updated
        txtWeatherTemp_c.text="temp_c :"+body?.current?.temp_c
        txtWeatherTemp_f.text="temp_f :"+body?.current?.temp_f
        txtWeatherWind__mph.text="wind_mph :"+body?.current?.wind_mph
        txtWeatherWind_kph.text="wind_kph :"+body?.current?.wind_kph
        txtWeatherCloud.text="cloud :"+body?.current?.cloud
        txtWeatherVis_km.text="vis_km :"+body?.current?.vis_km
        txtWeatherVis_miles.text="vis_miles :"+body?.current?.vis_miles
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        //return inflater.inflate(R.layout.fragment_weather, container, false)
        val view: View = inflater!!.inflate(R.layout.fragment_weather, container, false)
        val btn: Button = view.findViewById(R.id.btnSearch)
        btn.setOnClickListener(this)
        init()
        // Return the fragment view/layout
        return view
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSearch -> {
                txt= inputTxt.text.toString()
                init()
                Toast.makeText(activity,"Search :" +txt, Toast.LENGTH_LONG).show()
            }

        }
    }

    fun init(){

        presenter= WeatherPresenter(this)
        presenter.getWeatherDate(txt)

    }



}
