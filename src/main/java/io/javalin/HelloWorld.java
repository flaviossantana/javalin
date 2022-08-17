package io.javalin;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7080);
        app.get("/", ctx -> ctx.result("Bem Vindo ao JAVALIN"));

        beforeHandlers(app);
        endpointHandlers(app);
    }

    private static void beforeHandlers(Javalin app) {
        app.before((ctx) -> System.out.println("runs before all requests"));
        app.before("/path/*", ctx -> System.out.println("runs before all requests in /path"));
    }

    private static void endpointHandlers
        (Javalin app) {
        app.get("/path/output", ctx -> ctx.json("{\"message\":\"Hello World\"}"));
        app.post("/input", ctx -> ctx.status(201));
    }
}
