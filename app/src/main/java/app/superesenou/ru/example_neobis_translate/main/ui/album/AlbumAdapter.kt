package app.superesenou.ru.example_neobis_translate.main.ui.album

import android.support.design.internal.BottomNavigationItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.ContactAlbums
import app.superesenou.ru.example_neobis_translate.main.ui.post.MainAdapter
import kotlinx.android.synthetic.main.item_sectionalbums.view.*
import java.text.FieldPosition

class AlbumAdapter(private var list: List<ContactAlbums>,val listener: AlbumAdapter.Listener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sectionalbums,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
       return list.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder)?.setDate(position)
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun setDate(position: Int){
            itemView.txtTitleAlbums.text= list[position].title
            itemView.textViewAlbums.text= list[position].title[0].toString()
            itemView.tag = position
            itemView.setOnClickListener {
                val index= it.tag as Int
                listener.setOnItemClick(index)

            }
        }
  }

    interface Listener{
        fun setOnItemClick(position: Int)
    }
}