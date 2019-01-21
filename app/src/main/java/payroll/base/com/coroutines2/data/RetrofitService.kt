package payroll.base.com.coroutines2.data

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/api/v2/type/")
    fun getInfoDeferred(): Deferred<SimpleService.InfoService>


    @GET("/get")
    fun getInfo(): Call<SimpleService.InfoService>
}
