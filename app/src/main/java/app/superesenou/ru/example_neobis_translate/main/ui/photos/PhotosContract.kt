package app.superesenou.ru.example_neobis_translate.main.ui.photos

import app.superesenou.ru.example_neobis_translate.main.models.ContactComment
import app.superesenou.ru.example_neobis_translate.main.models.ContactPhotos
import app.superesenou.ru.example_neobis_translate.main.utils.IProgressBar

interface PhotosContract {

    interface View:IProgressBar{

        fun onFailure()
        fun onSuccessGetPhotos(list: List<ContactPhotos>)

    }

    interface Presenter{
        fun  getSectionPhotos()
    }
}