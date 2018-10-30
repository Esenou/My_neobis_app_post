package app.superesenou.ru.example_neobis_translate.main.ui.comment

import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.ContactComment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentPresenter(val view:CommentContract.View):CommentContract.Presenter {


    override fun getSectionComments() {

        if(isViewAttached()){
            view.showProgress()
       StartApplication.service.getDateComments().enqueue(

               object :Callback<List<ContactComment>>{
                   override fun onFailure(call: Call<List<ContactComment>>?, t: Throwable?) {
                       if(isViewAttached()){
                           view.hideProgress()
                       }
                       t?.printStackTrace()
                   }

                   override fun onResponse(call: Call<List<ContactComment>>?, response: Response<List<ContactComment>>?) {
                       if (response!!.isSuccessful&& response != null) {
                           view.onSuccessGetComments(response.body()!!)
                       }
                       else
                           view.onFailure()
                       view!!.hideProgress()
                   }
               }

       )
        }

    }

    fun isViewAttached():Boolean = view!= null
}