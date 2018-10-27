package app.superesenou.ru.example_neobis_translate.main.ui.photos

import app.superesenou.ru.example_neobis_translate.main.models.ContactComment
import app.superesenou.ru.example_neobis_translate.main.models.ContactPhotos

interface PhotosContract {

    interface View{

        fun onFailure()
        fun onSuccessGetPhotos(list: List<ContactPhotos>)

    }

    interface Presenter{
        fun  getSectionPhotos()
    }
}