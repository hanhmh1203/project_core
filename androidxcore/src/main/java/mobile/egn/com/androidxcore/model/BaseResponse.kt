package mobile.egn.com.androidxcore.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by locle on 1/30/18.
 */
class BaseResponse<T> : BaseApiResponse() {
    @SerializedName("data")
    @Expose
    var data: T? = null

    @SerializedName("codeHttp")
    @Expose
    var codeHttp: String? = null

    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("endIdx")
    @Expose
    var endIdx: Int? = null

    @SerializedName("max")
    @Expose
    var max: Int? = null

    @SerializedName("msg")
    @Expose
    var msg: String? = null

    @SerializedName("offset")
    @Expose
    var offset: Int? = null

    @SerializedName("startIdx")
    @Expose
    var startIdx: Int? = null

    @SerializedName("totalCount")
    @Expose
    var totalCount: Int? = null
}