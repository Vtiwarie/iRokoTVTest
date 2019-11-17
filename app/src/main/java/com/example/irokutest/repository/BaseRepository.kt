package com.example.irokutest.repository

import io.realm.Realm

abstract class BaseRepository {
    protected fun getRealm() = Realm.getDefaultInstance()
}