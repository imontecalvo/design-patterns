package org.example.patterns.`2-structural`

class HttpRequest(var from: String, val body: String)

interface IWebServer {
    fun sendHttpRequest(request: HttpRequest)
}

class WebServer : IWebServer {
    override fun sendHttpRequest(request: HttpRequest) = println("Received: ${request.body} \nfrom: ${request.from}\n")
}

class WebServerProxy(private val server: WebServer) : IWebServer {
    private val ip = "192.168.1.254"
    override fun sendHttpRequest(request: HttpRequest) {
        request.from = ip
        server.sendHttpRequest(request)
    }
}

fun main(){
    val clientIp = "192.168.1.60"
    val request = HttpRequest(clientIp, "Request http GET /users")

    val webServer = WebServer()
    val proxy = WebServerProxy(webServer)

    webServer.sendHttpRequest(request)
    proxy.sendHttpRequest(request)
}