package net.bewusstlos.feedburner;

import android.app.Application;

import net.bewusstlos.feedburner.di.DaggerFeedBurnerComponent;
import net.bewusstlos.feedburner.di.FeedBurnerComponent;

/**
 * Created by bewusstlos on 11/1/2017.
 */

public class FeedBurner extends Application {

    private static FeedBurnerComponent component;

    public static FeedBurnerComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerFeedBurnerComponent.builder().build();
    }
}
