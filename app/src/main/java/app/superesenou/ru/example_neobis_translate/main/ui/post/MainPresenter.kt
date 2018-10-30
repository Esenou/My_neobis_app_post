package app.superesenou.ru.example_neobis_translate.main.ui.post


import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.Contact
import app.superesenou.ru.example_neobis_translate.main.models.ContactWeather

import kotlinx.android.synthetic.main.fragment_post.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(val view: MainContract.View): MainContract.Presenter {
    override fun getWeatherDate(txt: String) {

        StartApplication.servicew.getDateWeather(txt).enqueue(

                object : Callback<ContactWeather> {
                    override fun onFailure(call: Call<ContactWeather>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<ContactWeather>?, response: Response<ContactWeather>?) {
                        if (response!!.isSuccessful&&response.body()!=null){
                            view.onSuccessGetWeatherDate(response.body()!!)
                        } else{
                            view.onFailure()
                        }
                    }
                }
        )
    }
    override fun getSectionPost() {
        if(isViewAttached()){
            view.showProgress()
        StartApplication.service.getDate().enqueue(
                object : Callback<List<Contact>>{
                    override fun onFailure(call: Call<List<Contact>>?, t: Throwable?) {
                        if(isViewAttached()){
                            view.hideProgress()
                        }
                        t?.printStackTrace()
                    }
                    override fun onResponse(call: Call<List<Contact>>?, response: Response<List<Contact>>?) {
                        if(response!!.isSuccessful  && response.body() != null){
                            view.onSuccessGetContact((response.body() as MutableList<Contact>?)!!)
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




