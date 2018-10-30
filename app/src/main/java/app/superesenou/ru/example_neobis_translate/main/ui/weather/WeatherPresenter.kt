package app.superesenou.ru.example_neobis_translate.main.ui.weather

import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.ContactWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherPresenter(val view:WeatherContract.View):WeatherContract.Presenter {

    override fun getWeatherDate(txt: String) {
        if(isViewAttached()){
            view.showProgress()
            StartApplication.servicew.getDateWeather(txt).enqueue(

                    object : Callback<ContactWeather> {
                        override fun onFailure(call: Call<ContactWeather>?, t: Throwable?) {

                            if(isViewAttached()){
                                view.hideProgress()
                            }
                            t?.printStackTrace()
                        }

                        override fun onResponse(call: Call<ContactWeather>?, response: Response<ContactWeather>?) {
                            if(isViewAttached()){
                                if (response!!.isSuccessful&&response.body()!=null){
                                view.onSuccessGetWeatherDate(response.body()!!)
                                }
                                else
                                    view.onFailure()
                                view!!.hideProgress()
                            }

                        }
                    }
            )
    }
}
    fun isViewAttached():Boolean = view!= null
}
