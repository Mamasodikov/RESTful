package uz.scorpus.restful.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.scorpus.restful.databinding.CategoryItemBinding
import uz.scorpus.restful.models.Category

class CategoryAdapter(var categories: List<Category>): RecyclerView.Adapter <CategoryAdapter.ItemHolder>() {
    inner class ItemHolder(var bnd: CategoryItemBinding) : RecyclerView.ViewHolder(bnd.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bnd.title.setText(categories[position].title)
    }

    override fun getItemCount(): Int {
       return categories.size
    }
}