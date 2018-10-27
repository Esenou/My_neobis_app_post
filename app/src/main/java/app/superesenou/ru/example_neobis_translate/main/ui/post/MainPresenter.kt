package app.superesenou.ru.example_neobis_translate.main.ui.post


import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.Contact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(val view: MainContract.View): MainContract.Presenter {


    override fun getSectionPost() {


        StartApplication.service.getDate().enqueue(
                object : Callback<List<Contact>>{
                    override fun onFailure(call: Call<List<Contact>>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<List<Contact>>?, response: Response<List<Contact>>?) {
                        if(response!!.isSuccessful  && response.body() != null){
                            view.onSuccessGetContact(response.body()!!)
                        }
                        else{
                            view.onFailure()
                        }    }
                    }
        )
                }

    }



