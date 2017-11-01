package net.bewusstlos.feedburner.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by bewusstlos on 10/31/2017.
 */
@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public SimpleXmlConverterFactory provideConverter() {
        return SimpleXmlConverterFactory.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(SimpleXmlConverterFactory simpleXmlConverterFactory, OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl("http://feeds.feedburner.com/blogspot/")
                .client(httpClient)
                .addConverterFactory(simpleXmlConverterFactory)
                .build();
    }
}
