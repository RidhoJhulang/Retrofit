package id.jhulang.restapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row_photo.view.*

class PhotoAdapter(val items: ArrayList<Model.photo>, val context: Context) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row_photo, p0, false)
        return PhotoAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindingvalues(get: Model.photo) {
            Picasso.get().load(get.thumbnailUrl).into(itemView.ivImage)
            itemView.tvTitle.text = get.title
        }
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0!!.bindingvalues(items.get(p1))
    }
}