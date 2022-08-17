package io.javalin;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7080);
        app.get("/", ctx -> ctx.result("Bem Vindo ao JAVALIN"));
    }
}
