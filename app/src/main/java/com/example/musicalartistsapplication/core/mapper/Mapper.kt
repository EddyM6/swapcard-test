package com.example.musicalartistsapplication.core.mapper

interface Mapper<InputType, OutputType> {
    fun map(inputModel: InputType): OutputType
}