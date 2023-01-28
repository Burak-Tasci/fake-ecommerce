package com.tsci.core.exception

/**
 * Created by Burak Taşcı on 11.09.2022.
 */
class LocationNotFoundException(message: String?): RuntimeException(message){
    constructor(): this(message = "Location could not retrieve from remote server.")
}