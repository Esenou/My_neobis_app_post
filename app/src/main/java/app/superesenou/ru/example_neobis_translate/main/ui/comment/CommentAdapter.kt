package app.superesenou.ru.example_neobis_translate.main.ui.comment

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.superesenou.ru.example_neobis_translate.R
import app.superesenou.ru.example_neobis_translate.main.models.ContactComment
import kotlinx.android.synthetic.main.item_sectioncomments.view.*


class CommentAdapter(private var list: List<ContactComment>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, position:  Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sectioncomments,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder)?.bind(position)
    }


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){
            itemView.nameComment.text = list.get(position).name
            itemView.emailComment.text=list.get(position).email
            itemView.bodyComment.text=list.get(position).body

        }

    }
}