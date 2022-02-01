package com.mertkalecik.earthquake.base

interface UseCase<in Input, out Output> {
    suspend operator fun invoke(input: Input): Output
}