package payroll.base.com.coroutines2.presentation.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import payroll.base.com.coroutines2.data.SimpleService
import payroll.base.com.coroutines2.presentation.base.Resource

class MainViewModel : ViewModel() {
    fun getIfo(): MutableLiveData<Resource<String>> {
        val result = MutableLiveData<Resource<String>>()

        val service = SimpleService
        GlobalScope.launch {
            try {

                val postInfoResource = service.executeDeferred().await()
                withContext(Dispatchers.Main) {
                    result.value =
                            Resource.success(postInfoResource.results.get(0).name)
                }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    result.value = Resource.error("", null)
                }

            }


        }
        return result


    }
}
