package app.superesenou.ru.example_neobis_translate.main.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment

import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.ui.album.AlbumFragment

import app.superesenou.ru.example_neobis_translate.main.ui.post.PostFragment
import app.superesenou.ru.example_neobis_translate.main.ui.weather.WeatherFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    private val mOnNavigationItemSelectedListener=BottomNavigationView.OnNavigationItemSelectedListener {item ->
       return@OnNavigationItemSelectedListener when(item.itemId) {
             R.id.postId-> {
                 println("right pressed")
                 replaceFragment(PostFragment())
                 return@OnNavigationItemSelectedListener true
             }
            R.id.albumId->{
                println("middle pressed")
                replaceFragment(AlbumFragment())
                return@OnNavigationItemSelectedListener  true
            }
            R.id.weatherId->{
                println("left pressed")
                replaceFragment(WeatherFragment())
                return@OnNavigationItemSelectedListener true
            }
           else->false

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)
        replaceFragment(PostFragment())
        //init()
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }





}
