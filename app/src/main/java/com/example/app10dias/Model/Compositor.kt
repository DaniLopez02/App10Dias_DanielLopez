package com.example.app10dias.Model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Compositor(
    @DrawableRes val fotografia: Int,
    @StringRes val nombre: Int,
    @StringRes val año: Int,
    @StringRes val estilo: Int,
    @StringRes val frase: Int,
    @StringRes val enlace: Int
    )