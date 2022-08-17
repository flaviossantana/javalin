# Javalin
A simple web framework for Java and Kotlin

```java
import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);
        app.get("/", ctx -> ctx.result("Hello World"));
    }
}
```
## Simples
Ao contrário de outras estruturas da Web Java e Kotlin, Javalin tem muito poucos conceitos que você precisa aprender. Você nunca estende classes e raramente implementa interfaces.

## Leve
Javalin é apenas alguns milhares de linhas de código em cima do Jetty, e seu desempenho é equivalente ao código Jetty bruto. Devido ao seu tamanho, é muito fácil raciocinar sobre o código-fonte.
