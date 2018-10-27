package app.superesenou.ru.example_neobis_translate.main.ui.post

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.Contact
import kotlinx.android.synthetic.main.item_section.view.*
import android.support.v4.content.ContextCompat.startActivity
import app.superesenou.ru.example_neobis_translate.main.ui.comment.CommentActivity


class MainAdapter(private var list:List<Contact>,val listener: Listener) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_section,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder)?.bind(position)
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            itemView.txtTitle.text = list.get(position).title
            itemView.txtBody.text=list.get(position).body
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