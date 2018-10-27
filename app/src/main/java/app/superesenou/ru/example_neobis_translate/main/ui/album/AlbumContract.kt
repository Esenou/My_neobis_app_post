package app.superesenou.ru.example_neobis_translate.main.ui.album

import app.superesenou.ru.example_neobis_translate.main.models.ContactAlbums

interface AlbumContract {

    interface View{

        fun onFailure()
        fun onSuccessGetAlbum(list: List<ContactAlbums>)

    }
    interface Presenter{
        fun getSectionAlbum()
    }
}