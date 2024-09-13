package hr.algebra.heroapp.adapter

import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hr.algebra.heroapp.NASA_PROVIDER_CONTENT_URI
import hr.algebra.heroapp.R
import hr.algebra.heroapp.model.Item
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import java.io.File

class ItemPagerAdapter(
    private val context: Context,
    private val items: MutableList<Item>
) : RecyclerView.Adapter<ItemPagerAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivItem = itemView.findViewById<ImageView>(R.id.ivItem)
        val ivRead = itemView.findViewById<ImageView>(R.id.ivRead)

        private val tvName = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvGender = itemView.findViewById<TextView>(R.id.tvGender)
        private val tvIntelligence = itemView.findViewById<TextView>(R.id.tvIntelligence)
        private val tvStrength = itemView.findViewById<TextView>(R.id.tvStrength)
        private val tvSpeed = itemView.findViewById<TextView>(R.id.tvSpeed)
        private val tvDurability = itemView.findViewById<TextView>(R.id.tvDurability)
        private val tvPower = itemView.findViewById<TextView>(R.id.tvPower)
        private val tvCombat = itemView.findViewById<TextView>(R.id.tvCombat)
        fun bind(item: Item) {
            tvName.text = item.name
            Picasso.get()
                .load(File(item.picturePath))
                .error(R.drawable.hero)
                .transform(RoundedCornersTransformation(50, 5))
                .into(ivItem)

            tvGender.text = item.gender
            tvIntelligence.text = item.intelligence.toString()
            tvStrength.text = item.strength.toString()
            tvSpeed.text = item.speed.toString()
            tvDurability.text = item.durability.toString()
            tvPower.text = item.power.toString()
            tvCombat.text = item.combat.toString()

            ivRead.setImageResource(if(item.read) R.drawable.green_flag else R.drawable.red_flag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_pager, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.ivRead.setOnClickListener {
            updateItem(position)
        }


        holder.bind(items[position])
    }

    private fun updateItem(position: Int) {
        val item = items[position]
        item.read = !item.read
        context.contentResolver.update(
            ContentUris.withAppendedId(NASA_PROVIDER_CONTENT_URI, item._id!!),
            ContentValues().apply {
                put(Item::read.name, item.read)
            },
            null,
            null
        )
        notifyItemChanged(position)
    }
}