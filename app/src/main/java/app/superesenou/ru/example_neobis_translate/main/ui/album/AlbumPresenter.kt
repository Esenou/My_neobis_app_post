package app.superesenou.ru.example_neobis_translate.main.ui.album

import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.ContactAlbums
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AlbumPresenter(val view: AlbumContract.View):AlbumContract.Presenter {

    override fun getSectionAlbum() {

        if(isViewAttached()) {
            view.showProgress()
            StartApplication.service.getDateAlbums().enqueue(
                    object : Callback<List<ContactAlbums>> {
                        override fun onFailure(call: Call<List<ContactAlbums>>?, t: Throwable?) {

                            if(isViewAttached()){
                                view.hideProgress()
                            }
                            t?.printStackTrace()
                        }

                        override fun onResponse(call: Call<List<ContactAlbums>>?, response: Response<List<ContactAlbums>>?) {
                            if(isViewAttached()){
                                if (response!!.isSuccessful && response.body() != null) {
                                    view.onSuccessGetAlbum(response.body()!!)
                                }
                                else
                                    view.onFailure()
                                view!!.hideProgress()

                            }
                        }
                    })
        }
    }

    fun isViewAttached():Boolean = view!= null


}