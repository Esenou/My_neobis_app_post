package app.superesenou.ru.example_neobis_translate.main.ui.post



import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.Contact
import app.superesenou.ru.example_neobis_translate.main.ui.comment.CommentActivity
import kotlinx.android.synthetic.main.fragment_post.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

class PostFragment : Fragment(), MainContract.View, MainAdapter.Listener {


    lateinit var  presenter : MainPresenter
    lateinit var  adapter: MainAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        init()
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    private fun init(){
        presenter= MainPresenter(this)
        presenter.getSectionPost()
    }


    override fun onFailure() {
        Toast.makeText(activity,"esen error", Toast.LENGTH_LONG).show()
    }


    override fun onSuccessGetContact(list: List<Contact>) {
        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        adapter= MainAdapter(list, this)
        recyclerView.adapter=adapter
    }


    override fun setOnItemClick(position: Int) {
        Toast.makeText(activity,"Item :"+position, Toast.LENGTH_LONG).show()
        val intent = Intent(activity,CommentActivity::class.java)
        startActivity(intent)
    }

}
