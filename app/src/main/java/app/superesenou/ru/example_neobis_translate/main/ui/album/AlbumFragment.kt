package app.superesenou.ru.example_neobis_translate.main.ui.album

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.ContactAlbums
import app.superesenou.ru.example_neobis_translate.main.ui.comment.CommentActivity
import app.superesenou.ru.example_neobis_translate.main.ui.main.BaseActivity
import app.superesenou.ru.example_neobis_translate.main.ui.main.BaseFragment
import app.superesenou.ru.example_neobis_translate.main.ui.photos.PhotosActivity
import kotlinx.android.synthetic.main.fragment_album.*
import kotlinx.android.synthetic.main.fragment_post.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AlbumFragment : BaseFragment(),AlbumContract.View,AlbumAdapter.Listener {

    lateinit var  presenter: AlbumPresenter
    lateinit var  adapter:AlbumAdapter


    override fun setOnItemClick(position: Int) {

       // Toast.makeText(activity,"Item :"+position, Toast.LENGTH_LONG).show()
        val intent = Intent(activity, PhotosActivity::class.java)
        startActivity(intent)
    }

    override fun onFailure() {
        Toast.makeText(activity,"error esen",Toast.LENGTH_LONG).show()
    }


    override fun onSuccessGetAlbum(list: List<ContactAlbums>) {
        recyclerViewAlbums.layoutManager = GridLayoutManager(activity, 3)
        adapter= AlbumAdapter(list,this)
        recyclerViewAlbums.adapter=adapter
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        init()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    fun init(){
        presenter= AlbumPresenter(this)
        presenter.getSectionAlbum()
    }
}
