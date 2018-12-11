package app.mobify.orderbreadandroid

import android.app.Application
import app.mobify.orderbreadandroid.activities.breadDetails.BreadDetailsPresenter
import app.mobify.orderbreadandroid.activities.breadList.BreadListPresenter
import app.mobify.orderbreadandroid.activities.login.LoginPresenter
import app.mobify.orderbreadandroid.utils.memoryStore.MemoryStore
import app.mobify.orderbreadandroid.utils.repository.Repository
import app.mobify.orderbreadandroid.utils.sharedPrefs.SharedPref
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class OrderBreadAppication: Application() {
    val myModule = module {
        single { SharedPref() }
        single { MemoryStore() }
        single { Repository() }
        single { BreadListPresenter() }
        single { BreadDetailsPresenter() }
        single { LoginPresenter() }
    }

    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin(this, listOf(myModule))
    }
}