package com.sykent.uidemo.dagger.manual

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/20 17:02
 */
class UserRepository(private val localDataSource: UserLocalDataSource,
                     private val userRemoteDataSource: UserRemoteDataSource) {
}

class UserLocalDataSource

class UserRemoteDataSource(private val retrofit: LoginService)