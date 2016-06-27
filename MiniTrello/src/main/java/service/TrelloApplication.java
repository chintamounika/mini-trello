package service;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by chinta on 24/6/16.
 */
public class TrelloApplication extends Application<TrelloConfig> {
    public void run(TrelloConfig trelloConfig, Environment environment) throws Exception {
        environment.jersey().register(TrelloAPI.class);

    }

    public void initialize(Bootstrap<TrelloConfig> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/site","/trello","index.html"));
    }

    public static void main(String[] args) throws Exception {
        new TrelloApplication().run(args);
    }
}
