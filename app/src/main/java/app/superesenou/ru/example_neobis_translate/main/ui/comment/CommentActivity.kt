package app.superesenou.ru.example_neobis_translate.main.ui.comment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.ContactComment
import app.superesenou.ru.example_neobis_translate.main.ui.main.BaseActivity
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.item_sectioncomments.*

class CommentActivity : BaseActivity(),CommentContract.View {


    lateinit var presenter: CommentPresenter
    lateinit var adapter: CommentAdapter

    override fun onFailure() {
        Toast.makeText(this,"esen error", Toast.LENGTH_LONG).show()
    }

    override fun onSuccessGetComments(list: List<ContactComment>) {

        recyclerViewComment.layoutManager=GridLayoutManager(this,1)
        adapter=CommentAdapter(list)
       recyclerViewComment.adapter=adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        var title:String = intent.getStringExtra("ese")
        var body:String=intent.getStringExtra("esen")
        titlePost.text=title
        bodyPost.text=body
        init()
    }

    fun init(){
        presenter= CommentPresenter(this)
        presenter.getSectionComments()
    }
}
