package com.vw.juno.data.network.toolbox

import com.vw.juno.util.ICommonUtils
import okhttp3.Interceptor
import okhttp3.Response

class ResponseCacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return response.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, max-age=" + 0)
                .build()
    }
}

/**
 * stale at most four weeks old
 */
class OfflineResponseCacheInterceptor(val commonUtils: ICommonUtils) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!commonUtils.isNetworkAvailable()) {
            request = request.newBuilder()
                    .header("Cache-Control",
                            "public, only-if-cached, max-stale=" + 2419200)
                    .build()
        }
        return chain.proceed(request)
    }
}