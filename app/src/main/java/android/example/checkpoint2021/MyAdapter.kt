package android.example.checkpoint2021

import android.example.checkpoint2021.databinding.ActivityMainBinding.inflate
import android.example.checkpoint2021.databinding.ItemBinding
import android.example.checkpoint2021.model.ItemItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder> () {

    var listItems = mutableListOf<ItemItem>()

    fun setItem(item: List<ItemItem>){
        listItems = item.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemBinding.inflate(inflater, parent, false)
        return MyViewHolder (binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listItems[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvPrice.text = item.price.toString()
        Glide.with(holder.itemView.context).load(item.image).into(holder.binding.ivIcon)

    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    inner class MyViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

}