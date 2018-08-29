package mobile.egn.com.androidxcore.model

data class Resource<out T>(val status: Status, val dataResource: T?, val message: String?, val httpCode: Int? = 200,
                           val serverError: String? = "", val serverErrorDescription: String? = "",
                           val messageCode: String? = ""
) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?, httpCode: Int? = 200,
                      serverError: String? = "", serverErrorDescription: String? = "",
                      messageCode: String? = ""): Resource<T> {
            return Resource(Status.ERROR, data, msg, httpCode, serverError, serverErrorDescription, messageCode)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

        fun <T> netWorkError(msg: String): Resource<T> {
            return Resource(Status.NETWORKERROR, message = msg, dataResource = null)
        }
    }
}

enum class Status {
    SUCCESS, ERROR, LOADING, NETWORKERROR
}