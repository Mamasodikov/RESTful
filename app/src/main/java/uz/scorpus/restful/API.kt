package uz.scorpus.restful

import retrofit2.Call
import retrofit2.http.GET
import uz.scorpus.restful.models.BaseModel
import uz.scorpus.restful.models.Category
import uz.scorpus.restful.models.Product

interface API {
    @GET("get_top_products")
    fun getData(): Call<BaseModel<List<Product>>>

    @GET("get_categories")
    fun getDataCat(): Call<BaseModel<List<Category>>>

}