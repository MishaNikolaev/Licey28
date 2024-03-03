package com.example.yourlicey28

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application()

// Делаем запрос по api (retrofit) , записывает данные в бд (room)
// Чтобы показать юзеру данные всегда берем из базы данных
// Предусмотреть кейс когда юзер отключает интернет