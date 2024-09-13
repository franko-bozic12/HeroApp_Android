package hr.algebra.heroapp.adapter

import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hr.algebra.heroapp.ItemPagerActivity
import hr.algebra.heroapp.NASA_PROVIDER_CONTENT_URI
import hr.algebra.heroapp.POSITION
import hr.algebra.heroapp.R
import hr.algebra.heroapp.model.Item
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import java.io.File

class ItemAdapter(
    private val context: Context,
    private val items: MutableList<Item>
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivItem = itemView.findViewById<ImageView>(R.id.ivItem)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        fun bind(item: Item) {
            tvTitle.text = item.name
            Picasso.get()
                .load(File(item.picturePath))
                .error(R.drawable.hero)
                .transform(RoundedCornersTransformation(50, 5))
                .into(ivItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnLongClickListener {
            //delete
            val item = items[position]
            context.contentResolver.delete(
                ContentUris.withAppendedId(NASA_PROVIDER_CONTENT_URI, item._id!!),
                null, null
            )
            File(item.picturePath).delete()
            items.removeAt(position)
            notifyDataSetChanged()

            true
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ItemPagerActivity::class.java).apply {
                putExtra(POSITION, position)
            }
            context.startActivity(intent)
        }


        holder.bind(items[position])
    }
}