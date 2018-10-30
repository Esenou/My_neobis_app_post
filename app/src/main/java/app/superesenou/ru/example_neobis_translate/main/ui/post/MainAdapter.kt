package app.superesenou.ru.example_neobis_translate.main.ui.post

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.Contact
import kotlinx.android.synthetic.main.item_section.view.*


class MainAdapter(var list: List<Contact>, val listener: Listener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val post:List<Contact>?=null
    var weather:List<Weather>?=null



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_section,parent,false)

        return ViewHolde(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolde)?.bind(position)

    }

    inner class ViewHolde(itemView:View):RecyclerView.ViewHolder(itemView){


        fun bind(position: Int){


            itemView.txtTitle.text = list.get(position)?.title
            itemView.textViewPost.text=list.get(position)?.title[0].toString()
            itemView.txtBody.text=list.get(position)?.body
            itemView.tag = position
            itemView.setOnClickListener {
                val index= it.tag as Int
                listener.setOnItemClick(index,list.get(position)?.title,list.get(position)?.body)

            }

        }
    }
    interface Listener{
        fun setOnItemClick(position: Int, title: String, body: String)

    }


}