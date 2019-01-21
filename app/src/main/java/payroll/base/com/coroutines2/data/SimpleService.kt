package payroll.base.com.coroutines2.data

import kotlinx.coroutines.Deferred
import payroll.base.com.coroutines2.presentation.main.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object SimpleService {

    private const val API_URL = "https://pokeapi.co"//https://httpbin.org


    class Type(var name:String,var url:String)
    class InfoService(val results: ArrayList<Type>)


    fun executeDeferred():Deferred<InfoService>{
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)

        return retrofitService.getInfoDeferred()
    }



}