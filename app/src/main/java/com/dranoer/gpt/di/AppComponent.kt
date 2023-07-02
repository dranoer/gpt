package com.dranoer.gpt.di

import com.dranoer.gpt.MainActivity
import com.dranoer.gpt.networking.di.NetworkingComponent
import dagger.Component

@Component(dependencies = [NetworkingComponent::class], modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun getNetworkingComponent(): NetworkingComponent
}