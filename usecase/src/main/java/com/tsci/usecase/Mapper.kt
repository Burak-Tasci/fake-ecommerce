package com.tsci.usecase

interface Mapper <in Input, out Output> {
    fun map(input: Input): Output
}
