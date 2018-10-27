package app.superesenou.ru.example_neobis_translate.main.ui.photos

import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.ContactPhotos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosPresenter(val view:PhotosContract.View ):PhotosContract.Presenter {
    override fun getSectionPhotos() {
        StartApplication.service.getDatePhotos().enqueue(
                object: Callback<List<ContactPhotos>>{
                    override fun onFailure(call: Call<List<ContactPhotos>>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<List<ContactPhotos>>?, response: Response<List<ContactPhotos>>?) {
                        if (response!!.isSuccessful&&response != null) {
                            view.onSuccessGetPhotos(response.body()!!)
                        }
                        else{
                            view.onFailure()
                        }
                    }
                }
        )
    }


}