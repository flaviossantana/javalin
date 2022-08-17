package io.javalin;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7080);
        app.get("/", ctx -> ctx.result("Bem Vindo ao JAVALIN"));

        app.before((ctx) -> System.out.println("runs before all requests"));
        app.before("/path/*", ctx -> System.out.println("runs before all requests in /path"));
    }
}
