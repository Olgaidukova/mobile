package config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:${env}.properties",
                "classpath:credentials.properties"})

public interface Config extends org.aeonbits.owner.Config {

    String login();

    String password();

    String baseUrl();

    String appUrl();

    String device();

    String osVersion();

    String projectName();

    String buildName();

    String testName();
}
