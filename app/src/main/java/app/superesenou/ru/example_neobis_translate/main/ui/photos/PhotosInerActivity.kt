package app.superesenou.ru.example_neobis_translate.main.ui.photos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.ui.main.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photos_iner.*

class PhotosInerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_photos_iner)
         var url:String = intent.getStringExtra("esen")
         Picasso.get().load(url).into(imageViewPhotosInner)

    }
}
