package app.superesenou.ru.example_neobis_translate.main.ui.weather

import app.superesenou.ru.example_neobis_translate.main.StartApplication
import app.superesenou.ru.example_neobis_translate.main.models.ContactWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherPresenter(val view:WeatherContract.View):WeatherContract.Presenter {

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
}