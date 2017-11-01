package net.bewusstlos.feedburner.di;

import net.bewusstlos.feedburner.actvities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by bewusstlos on 11/1/2017.
 */
@Singleton
@Component(modules = {RetrofitModule.class})
public interface FeedBurnerComponent {
    void inject(MainActivity mainActivity);
    Retrofit retrofit();
}
