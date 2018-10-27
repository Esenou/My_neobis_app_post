package app.superesenou.ru.example_neobis_translate.main.ui.photos

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.ContactPhotos
import kotlinx.android.synthetic.main.item_sectioncomments.view.*
import kotlinx.android.synthetic.main.item_sectionphotos.view.*


class PhotosAdapter(private var list: List<ContactPhotos>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sectionphotos,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
           return   list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder)?.bind(position)
    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            itemView.txtTitlePhotos.text = list.get(position).title


        }

    }


}