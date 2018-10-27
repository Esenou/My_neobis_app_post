package app.superesenou.ru.example_neobis_translate.main.ui.weather

import app.superesenou.ru.example_neobis_translate.main.models.ContactWeather

interface WeatherContract {

    interface View{
        fun onFailure()
        fun onSuccessGetWeatherDate(body: ContactWeather?)

    }
    interface Presenter{
        fun getWeatherDate(txt: String)
    }
}