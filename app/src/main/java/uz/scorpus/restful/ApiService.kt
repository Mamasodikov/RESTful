package uz.scorpus.restful

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

  fun APIClient (): API {
      var retrofit: Retrofit? = null
      if(retrofit==null)
      {
          retrofit=Retrofit.Builder()
              .baseUrl("http://osonsavdo.sd-group.uz/api/")
              .addConverterFactory(GsonConverterFactory.create())
              .build()
      }

      return retrofit!!.create(API::class.java)
  }
}