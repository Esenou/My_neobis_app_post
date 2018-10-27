package app.superesenou.ru.example_neobis_translate.main.ui.post

import android.icu.util.ULocale
import app.superesenou.ru.example_neobis_translate.main.models.Contact

interface MainContract {



    interface View{
        fun onFailure()
        fun onSuccessGetContact(list: List<Contact>)
    }


    interface Presenter{
        fun getSectionPost()
    }





}