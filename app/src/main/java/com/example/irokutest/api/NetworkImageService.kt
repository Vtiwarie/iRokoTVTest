package com.example.irokutest.api

import javax.inject.Inject

class NetworkImageService @Inject constructor(
    var api: NetworkApi
) {
//
//    fun searchImages(phrase: String): Single<ImageResponse> {
//        return api.searchImages(phrase, FIELDS, SORT_ORDER)
//    }
//
//    fun getImageMetadata(id: String): Flowable<MetadataResponse> {
//        return api.getImageMetadata(id)
//    }
//
//    fun getSimilarImages(id: String): Flowable<ImageResponse> {
//        return api.getSimilarImages(id)
//    }
//
//    companion object {
//        val FIELDS = "id,title,thumb"
//        val SORT_ORDER = "best"
//
//        data class RxSchedulers(
//                val network: Scheduler = Schedulers.io(),
//                val disk: Scheduler = Schedulers.single(),
//                val main: Scheduler = AndroidSchedulers.mainThread()
//        )
//    }
}
