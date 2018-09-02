package mobile.egn.com.mobile

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import mobile.egn.com.mobile.firebase.FireBaseModule
import javax.inject.Singleton

@Module(includes = [FireBaseModule::class,ActivityModule::class])
class AppModule {
//    @Provides
//    @Singleton
//    fun fireBaseActivity() = FireBaseActivity()
//    @Module
//    abstract class ApplicationBinder {
//        @Binds
//        abstract fun application(app: MobileApp): Application
//    }
}