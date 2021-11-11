package uz.scorpus.restful

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.scorpus.restful.adapters.CategoryAdapter
import uz.scorpus.restful.adapters.ProductAdapter
import uz.scorpus.restful.databinding.ActivityMainBinding
import uz.scorpus.restful.models.BaseModel
import uz.scorpus.restful.models.Category
import uz.scorpus.restful.models.Product
import com.synnapps.carouselview.ImageListener




class MainActivity : AppCompatActivity() {

    lateinit var b: ActivityMainBinding
    val images:List<Int> = listOf(R.drawable.id_1, R.drawable.id_2, R.drawable.id_3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.carouselView.setPageCount(images.size)
        b.carouselView.setImageListener(imageListener);

        loadProducts()
        loadCategories()
    }

    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(images.get(position)) }



    private fun loadCategories() {
        ApiService.APIClient().getDataCat().enqueue(object: Callback<BaseModel<List<Category>>> {
            override fun onResponse(
                call: Call<BaseModel<List<Category>>>,
                response: Response<BaseModel<List<Category>>>
            ) {
                val categoryList: BaseModel<List<Category>>
                categoryList = (response.body()) as BaseModel<List<Category>>
                b.CategoryRec.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)
                b.CategoryRec.adapter = CategoryAdapter(categoryList.data)

                Toast.makeText(this@MainActivity, "Succes ${categoryList.data.size}", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<BaseModel<List<Category>>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadProducts() {
        ApiService.APIClient().getData().enqueue(object: Callback<BaseModel<List<Product>>> {
            override fun onResponse(
                call: Call<BaseModel<List<Product>>>,
                response: Response<BaseModel<List<Product>>>
            ) {
                val productList: BaseModel<List<Product>>
                productList = (response.body()) as BaseModel<List<Product>>
                b.ProductRec.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
                b.ProductRec.adapter = ProductAdapter(productList.data)

                Toast.makeText(this@MainActivity, "Succes ${productList.data.size}", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<BaseModel<List<Product>>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}