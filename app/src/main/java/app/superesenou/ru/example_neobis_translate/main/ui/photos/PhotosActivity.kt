package app.superesenou.ru.example_neobis_translate.main.ui.photos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.ContactPhotos
import kotlinx.android.synthetic.main.activity_photos.*

class PhotosActivity : AppCompatActivity(),PhotosContract.View {

    lateinit var presenter: PhotosPresenter
    lateinit var adapter: PhotosAdapter
    override fun onFailure() {
        Toast.makeText(this,"esen error", Toast.LENGTH_LONG).show()
    }

    override fun onSuccessGetPhotos(list: List<ContactPhotos>) {
        recyclerViewPhotos.layoutManager= GridLayoutManager(this,3)
        adapter= PhotosAdapter(list)
        recyclerViewPhotos.adapter=adapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        init()
    }

    fun init(){
        presenter= PhotosPresenter(this)
        presenter.getSectionPhotos()
    }
}
