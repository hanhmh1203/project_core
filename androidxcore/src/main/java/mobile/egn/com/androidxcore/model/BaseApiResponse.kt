package mobile.egn.com.androidxcore.model

import mobile.egn.com.androidxcore.network.DataResponse


open class BaseApiResponse : DataResponse<BaseApiResponse> {
    override fun retrieveData(): BaseApiResponse {
        return this
    }
}