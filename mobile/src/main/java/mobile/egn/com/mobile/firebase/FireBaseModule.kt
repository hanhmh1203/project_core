package mobile.egn.com.mobile.firebase

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FireBaseModule{
    @ContributesAndroidInjector
    abstract fun authFragment(): AuthFragment
}