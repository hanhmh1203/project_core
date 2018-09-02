package mobile.egn.com.mobile

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun firebaseActivity(): FireBaseActivity
}