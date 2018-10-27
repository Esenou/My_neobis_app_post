package app.superesenou.ru.example_neobis_translate.main.models

import java.io.Serializable


class ContactWeather(var location:Location,var current:Current){
    inner class Location(var name:String,var region:String,var country:String,var tz_id:String,var localtime:String)

    inner class Current(var last_updated:String,var temp_c:String,var temp_f:String,var wind_mph:String,var wind_kph:String,var cloud:String,var vis_km:String,var vis_miles:String)
}