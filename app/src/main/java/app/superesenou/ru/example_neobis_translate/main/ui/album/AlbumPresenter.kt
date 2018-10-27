package app.superesenou.ru.example_neobis_translate.main.ui.album

import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.ContactAlbums
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AlbumPresenter(val view: AlbumContract.View):AlbumContract.Presenter {

    override fun getSectionAlbum() {
        StartApplication.service.getDateAlbums().enqueue(
                object: Callback<List<ContactAlbums>>{
                    override fun onFailure(call: Call<List<ContactAlbums>>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                    override fun onResponse(call: Call<List<ContactAlbums>>?, response: Response<List<ContactAlbums>>?) {
                       if(response!!.isSuccessful && response.body()!=null){
                           view.onSuccessGetAlbum(response.body()!!)
                       }
                        else{
                           view.onFailure()
                       }
                    }
                })

    }


}