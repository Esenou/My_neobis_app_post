package app.superesenou.ru.example_neobis_translate.main.ui.album

import app.superesenou.ru.example_neobis_translate.main.models.ContactAlbums
import app.superesenou.ru.example_neobis_translate.main.utils.IProgressBar

interface AlbumContract {

    interface View:IProgressBar{


        fun onFailure()
        fun onSuccessGetAlbum(list: List<ContactAlbums>)


    }
    interface Presenter{
        fun getSectionAlbum()
    }
}