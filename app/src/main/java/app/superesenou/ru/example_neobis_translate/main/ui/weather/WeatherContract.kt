package app.superesenou.ru.example_neobis_translate.main.ui.weather

import app.superesenou.ru.example_neobis_translate.main.models.ContactWeather
import app.superesenou.ru.example_neobis_translate.main.utils.IProgressBar

interface WeatherContract {

    interface View:IProgressBar{
        fun onFailure()
        fun onSuccessGetWeatherDate(body: ContactWeather?)

    }
    interface Presenter{
        fun getWeatherDate(txt: String)
    }
}