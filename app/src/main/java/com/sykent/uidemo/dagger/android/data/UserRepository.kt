package com.sykent.uidemo.dagger.android.data

import javax.inject.Inject

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/23 15:55
 */
class UserRepository @Inject constructor(
        private val localDataSource: UserLocalDataSource,
        private val remoteDataSource: UserRemoteDataSource
) {
}