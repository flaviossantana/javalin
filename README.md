# Javalin
Um framework web simples para Java e Kotlin

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

## Contexo
O objeto Context fornece tudo o que você precisa para lidar com uma solicitação http. Ele contém o servlet-request e servlet-response subjacentes, e um monte de getters e setters.
```java
// Request methods
body()                                  // request body as string
bodyAsBytes()                           // request body as array of bytes
bodyAsInputStream()                     // request body as input stream
bodyAsClass(clazz)                      // request body as specified class (deserialized from JSON)
bodyStreamAsClass(clazz)                // request body as specified class (memory optimized version of above)
bodyValidator(clazz)                    // request body as validator typed as specified class
uploadedFile("name")                    // uploaded file by name
uploadedFiles("name")                   // all uploaded files by name
uploadedFiles()                         // all uploaded files as list
formParam("name")                       // form parameter by name, as string
formParamAsClass("name", clazz)         // form parameter by name, as validator typed as specified class
formParams("name")                      // list of form parameters by name
formParamMap()                          // map of all form parameters
pathParam("name")                       // path parameter by name as string
pathParamAsClass("name", clazz)         // path parameter as validator typed as specified class
pathParamMap()                          // map of all path parameters
basicAuthCredentialsExist()             // true if request has basic auth credentials
basicAuthCredentials()                  // basic auth credentials (if set)
attribute("name", value)                // set an attribute on the request
attribute("name")                       // get an attribute on the request
attributeMap()                          // map of all attributes on the request
contentLength()                         // content length of the request body
contentType()                           // request content type
cookie("name")                          // request cookie by name
cookieMap()                             // map of all request cookies
header("name")                          // request header by name (can be used with Header.HEADERNAME)
headerAsClass("name", clazz)            // request header by name, as validator typed as specified class
headerMap()                             // map of all request headers
host()                                  // host as string
ip()                                    // ip as string
isMultipart()                           // true if the request is multipart
isMultipartFormData()                   // true if the request is multipart/formdata
method()                                // request methods (GET, POST, etc)
path()                                  // request path
port()                                  // request port
protocol()                              // request protocol
queryParam("name")                      // query param by name as string
queryParamAsClass("name", clazz)        // query param parameter by name, as validator typed as specified class
queryParams("name")                      // list of query parameters by name
queryParamMap()                         // map of all query parameters
queryString()                           // full query string
scheme()                                // request scheme
sessionAttribute("name", value)         // set a session attribute
sessionAttribute("name")                // get a session attribute
consumeSessionAttribute("name")         // get a session attribute, and set value to null
cachedSessionAttribute("name", value)   // set a session attribute, and cache the value as a request attribute
cachedSessionAttribute("name")          // get a session attribute, and cache the value as a request attribute
cachedSessionAttributeOrCompute(...)    // same as above, but compute and set if value is absent
sessionAttributeMap()                   // map of all session attributes
url()                                   // request url
fullUrl()                               // request url + query string
contextPath()                           // request context path
userAgent()                             // request user agent

// Response methods
result("result")                        // set result stream to specified string (overwrites any previously set result)
result(byteArray)                       // set result stream to specified byte array (overwrites any previously set result)
result(inputStream)                     // set result stream to specified input stream (overwrites any previously set result)
seekableStream(inputStream, "type")     // write content immediately as seekable stream (useful for audio and video)
resultStream()                          // get current result stream
resultString()                          // get current result stream as string (if possible), and reset result stream
future(future, callback)                // set the result to be a future, see async section (overwrites any previously set result)
resultFuture()                          // get current result future
contentType("type")                     // set the response content type
header("name", "value")                 // set response header by name (can be used with Header.HEADERNAME)
redirect("/path", code)                 // redirect to the given path with the given status code
status(code)                            // set the response status code
status()                                // get the response status code
cookie("name", "value", maxAge)         // set response cookie by name, with value and max-age (optional).
cookie(cookie)                          // set cookie using javalin Cookie class
removeCookie("name", "/path")           // removes cookie by name and path (optional)
json(obj)                               // calls result(jsonString), and also sets content type to json
jsonStream(obj)                         // calls result(jsonStream), and also sets content type to json
html("html")                            // calls result(string), and also sets content type to html
render("/template.tmpl", model)         // calls html(renderedTemplate)

// Other methods
handlerType()                           // handler type of the current handler (BEFORE, AFTER, GET, etc)
appAttribute("name")                    // get an attribute on the Javalin instance. see app attributes section below
matchedPath()                           // get the path that was used to match this request (ex, "/hello/{name}")
endpointHandlerPath()                   // get the path of the endpoint handler that was used to match this request
cookieStore                             // see cookie store section below
```
