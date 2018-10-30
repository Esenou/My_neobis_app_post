package app.superesenou.ru.example_neobis_translate.main.ui.post

import android.icu.util.ULocale
import app.superesenou.ru.example_neobis_translate.main.models.Contact
import app.superesenou.ru.example_neobis_translate.main.models.ContactWeather
import app.superesenou.ru.example_neobis_translate.main.utils.IProgressBar

interface MainContract {



    interface View:IProgressBar{
        fun onFailure()
        fun onSuccessGetContact(list: List<Contact>)
        fun onSuccessGetWeatherDate(body: ContactWeather?)
    }


    interface Presenter{
        fun getSectionPost()
        fun getWeatherDate(txt: String)
    }





}