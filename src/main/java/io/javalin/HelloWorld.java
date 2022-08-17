package io.javalin;

import java.util.Arrays;
import java.util.stream.Stream;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7080);
        app.get("/", ctx -> ctx.result("Bem Vindo ao JAVALIN"));

        beforeHandlers(app);
        endpointHandlers(app);
        afterHandlers(app);
        context(app);
        appAttributes(app);
    }

    private static void beforeHandlers(Javalin app) {
        app.before((ctx) -> System.out.println("runs before all requests"));
        app.before("/path/*", ctx -> System.out.println("runs before all requests in /path"));
        app.before("/attribute/*", ctx -> app.attribute("myValue", "foo"));
    }

    private static void endpointHandlers(Javalin app) {
        app.get("/path/output", ctx -> ctx.json("{\"message\":\"Hello World\"}"));
        app.post("/input", ctx -> ctx.status(201));

        // the {} syntax does not allow slashes ('/') as part of the parameter
        app.get("/hello/{name}", ctx -> ctx.result("Hello: " + ctx.pathParam("name")));

        // the <> syntax allows slashes ('/') as part of the parameter
        app.get("/hello/<name>", ctx -> ctx.result("Hello: " + ctx.pathParam("name")));

        // will match anything starting with /path/
        app.get("/path/*", ctx -> ctx.result("You are here because " + ctx.path() + " matches " + ctx.matchedPath()));
    }

    private static void context(Javalin app) {
        app.post("/context", (ctx) -> {
            System.out.println(ctx.body());
            System.out.println(ctx.ip());
            System.out.println(ctx.port());
            System.out.println(ctx.fullUrl());
        });
    }

    private static void afterHandlers(Javalin app) {
        app.after((ctx) -> System.out.println("runs after all requests"));
        app.after("/path/*", ctx -> System.out.println("runs after all requests in /path"));
    }

    private static void appAttributes(Javalin app) {
        app.attribute("name", "Javalin");
        app.attribute("version", "1.0.0");
        app.attribute("description", "A lightweight web framework for Java");

        app.get("/attribute/ctx", ctx -> {
            String myValue = ctx.appAttribute("myValue");
            ctx.result(myValue);
        });
    }

}
