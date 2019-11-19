package com.example.irokutest.model

import com.google.gson.annotations.Expose
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Movie(
    @PrimaryKey
    var id: Int = -1,

    var title: String = "",

    var overview: String = "",

    var poster_path: String = "",

    var vote_average: Double = 0.0,

    var release_date: String = "",

    @Expose(deserialize = false)
    var listTypes: RealmList<Int> = RealmList()
) : RealmObject()

enum class MovieListType {
    POPULAR,
    TOP_RATED;

    var id: Int = 0
        get() = this.ordinal
}