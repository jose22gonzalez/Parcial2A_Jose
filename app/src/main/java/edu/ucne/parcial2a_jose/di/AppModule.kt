package edu.ucne.parcial2a_jose.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial2a_jose.data.remote.apiverbo
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi{
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesVerboApi(moshi: Moshi): apiverbo {
        return Retrofit.Builder()
            .baseUrl("https://private-a127e-verbos.apiary-mock.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(apiverbo::class.java)
    }
}