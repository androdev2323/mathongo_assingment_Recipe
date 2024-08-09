package com.example.mathongo_assingment.DI

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.data.ContextCache
import androidx.core.view.KeyEventDispatcher
import com.example.mathongo_assingment.data.reciperepoImpl
import com.example.mathongo_assingment.domain.Usecase.SearchRecipeUsecase
import com.example.mathongo_assingment.domain.Usecase.UseCase
import com.example.mathongo_assingment.domain.Usecase.randomrecipeUsecase
import com.example.mathongo_assingment.domain.repository.recipeAPi
import com.example.mathongo_assingment.domain.repository.reciperepo
import com.example.mathongo_assingment.util.Constant
import dagger.Component

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext


@Module
@InstallIn(SingletonComponent::class)
class networkmodule {
    @Provides
    @Singleton
    fun provideretrofit(httpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
@Provides
@Singleton
fun providesokhttpclient(@ApplicationContext context: Context):OkHttpClient{
    val cachesize = (1024 * 1024 * 5).toLong()
    val cache = Cache(context.cacheDir, cachesize)

    val onlineinterceptor = Interceptor() { chain ->
        val response = chain.proceed(chain.request())
        val maxtime = 60
        response.newBuilder()
            .header("Cache-Control", "public, max-age=$maxtime")
            .removeHeader("Pragma")
            .build()
    }
    val offlineinterceptor = Interceptor { chain ->
        val request=chain.request()
        if(!isconnectedtointernet(context)){
            val maxStale = 60 * 60 * 24 * 30
            request.newBuilder()
                .header("Cache-Control","public maxStale=${maxStale}")
                .removeHeader("Pragma")
                .build()
        }
        chain.proceed(request)

    }
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(offlineinterceptor)
        .addNetworkInterceptor(onlineinterceptor)
        .cache(cache)
        .build()

}
    @Provides
    @Singleton
    fun ProvidesrecipeAPI(retrofit: Retrofit): recipeAPi {
        return retrofit.create(recipeAPi::class.java)
    }

    @Provides
    @Singleton
    fun providesRecipeRepo(recipeAPi: recipeAPi): reciperepo {
        return reciperepoImpl(recipeAPi)
    }

    @Provides
    @Singleton
    fun provideUSecase(reciperepo: reciperepo): UseCase {
        return UseCase(
            randomrecipeUsecase(reciperepo),
            searchRecipeUsecase = SearchRecipeUsecase(reciperepo)
        )
    }

    fun isconnectedtointernet(context: Context): Boolean {
        var isconnected = false

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val activenetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
            isconnected = when {
                activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                activenetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }


        } else {
            val network = connectivityManager.activeNetworkInfo ?: return false
            if (network.isConnected) {
                isconnected = true
            }
        }
        return isconnected
    }
}

