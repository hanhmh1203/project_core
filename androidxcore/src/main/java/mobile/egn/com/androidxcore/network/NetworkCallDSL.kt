package mobile.egn.com.androidxcore.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import mobile.egn.com.androidxcore.model.BaseResponse
import mobile.egn.com.androidxcore.model.Resource
import org.json.JSONObject
import retrofit2.Response


class CallHandler<RESPONSE : Any, DATA : Any> {
    lateinit var client: Deferred<Response<RESPONSE>>

    fun makeCall(): MutableLiveData<Resource<DATA>> {
        val result = MutableLiveData<Resource<DATA>>()
        result.setValue(Resource.loading(null))
        launch {
            try {
//                val response = client.await() as Response<DataResponse<DATA>>
                val response = client.await() as Response<DATA>
                if (response != null) {
                    if (response.isSuccessful) {
                        withContext(UI)
                        {
                            //                            result.value = Resource.success(response.body())
                            // handle error code in body
                            if (response.body() is BaseResponse<*>) {
                                val baseResponse = response.body() as BaseResponse<*>
                                if (isErrorCode(baseResponse?.codeHttp?.toInt()!!)) {
                                    result.value = Resource.error(msg = baseResponse?.msg!!, data = null, serverErrorDescription = baseResponse.msg)
                                } else {
                                    result.value = Resource.success(response.body())
                                }
                            } else {
                                result.value = Resource.success(response.body())
                            }

                        }
                    } else {
                        // handle error code in http
                        Log.e("networkCall", "respone is not success")
                        val httpCode = response.code()
                        val errorBody = response.errorBody()?.string()
                        val jsonObject = JSONObject(errorBody)
                        var serverError: String? = ""
                        var serverErrorDescription: String? = ""
                        if (jsonObject.has("error")) {
                            serverError = jsonObject.getString("error")
                        }
                        if (jsonObject.has("error_description")) {
                            serverErrorDescription = jsonObject.getString("error_description")
                        }
                        if (jsonObject.has("Message")) {
                            if (serverErrorDescription.isNullOrEmpty()) {
                                serverErrorDescription = jsonObject.getString("Message")
                            }
                        }
                        if (jsonObject.has("message")) {
                            if (serverErrorDescription.isNullOrEmpty()) {
                                serverErrorDescription = jsonObject.getString("message")
                            }
                        }
                        if (jsonObject.has("MESSAGE")) {
                            if (serverErrorDescription.isNullOrEmpty()) {
                                serverErrorDescription = jsonObject.getString("MESSAGE")
                            }
                        }
                        withContext(UI) {
                            result.value = Resource.error(msg = response.message(), data = null, httpCode = httpCode, serverError = serverError, serverErrorDescription = serverErrorDescription,
                                    messageCode = ""
                            )
                            if (httpCode == 401 || httpCode == 403) {
//                                HSKPApplication.getInstance().logout()
                            }
                        }


                    }
                } else {
                    Log.e("networkCall", "respone is null")
                    withContext(UI) {
                        result.value = Resource.error("respone is null", serverErrorDescription = "respone is null", data = null)
                    }

                }
            } catch (e: Exception) {
                Log.e("networkCall", "exception ${e.message}")
                withContext(UI)
                {
                    var msg = e.message.toString()
                    if (msg.isNullOrEmpty()) {
                        msg = "unknown error"
                    }
                    result.value = Resource.error(msg = msg, data = null, serverErrorDescription = msg)
                    // e.handleException(result)
                }
            }
        }
        return result
    }
}

fun isErrorCode(errorCode: Int): Boolean {
    if (errorCode < 400) {
        return false
    }
    return true
}

fun <RESPONSE : DataResponse<*>, DATA : Any> networkCall(block: CallHandler<RESPONSE, DATA>.() -> Unit): MutableLiveData<Resource<DATA>> = CallHandler<RESPONSE, DATA>().apply(block).makeCall()

interface DataResponse<T> {
    fun retrieveData(): T
}
