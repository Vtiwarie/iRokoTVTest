package com.example.irokutest.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Movie(
    @PrimaryKey
    var id: Int = -1,

    var title: String = "",

    var overview: String = "",

    var poster_path: String = "",

    var vote_average: Double = 0.0,

    var release_date: String = ""
) : RealmObject()