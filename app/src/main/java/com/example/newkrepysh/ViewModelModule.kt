package com.example.newkrepysh

import androidx.lifecycle.ViewModel
import com.example.newkrepysh.activities.AuthActivityViewModel

import com.example.newkrepysh.ui.dashboard.DashboardViewModel
import com.example.newkrepysh.ui.home.HomeViewModel
import com.example.newkrepysh.ui.notifications.NotificationsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    internal abstract fun dashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationsViewModel::class)
    internal abstract fun notificationsViewModel(notificationsViewModel: NotificationsViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AuthActivityViewModel::class)
    internal abstract fun authActivityViewModel(authActivityViewModel: AuthActivityViewModel): ViewModel


}