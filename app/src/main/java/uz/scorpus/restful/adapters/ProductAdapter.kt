package uz.scorpus.restful.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.recyclerview.widget.RecyclerView
import uz.scorpus.restful.databinding.ProductItemBinding
import uz.scorpus.restful.models.Product
import android.widget.Toast

import uz.scorpus.restful.MainActivity




class ProductAdapter(var products: List<Product>): RecyclerView.Adapter <ProductAdapter.ItemHolder>() {
    inner class ItemHolder(var bnd: ProductItemBinding) : RecyclerView.ViewHolder(bnd.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bnd.name.setText(products[position].name)
        holder.bnd.price.setText(products[position].price)
        holder.bnd.shortDesc.setText(products[position].created_at)
//        holder.bnd.ratingBar.setOnRatingBarChangeListener({ ratingBar, rating, fromUser ->
//            ratingBar.setRating(rating)
//        })
    }

    override fun getItemCount(): Int {
       return products.size
    }
}