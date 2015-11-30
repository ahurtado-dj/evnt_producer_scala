package dj.eventhubpub1

import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.actor.ActorSystem
import scala.io.StdIn
import akka.stream.scaladsl.Flow
import akka.http.scaladsl.model.ws.Message
import akka.http.scaladsl.model.ws.TextMessage
 
object Main extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  
  // probar con un cliente websockets (dark-websocket-terminal de chrome)
  // entrar ws://localhost:8080/ws-echo
  // enviar: /send algo aca
  val echoService: Flow[Message, Message, _] = Flow[Message].map {
    case TextMessage.Strict(txt) => TextMessage("ECHO: " + txt)
    case _ => TextMessage("Message type unsupported")
  }
  
 
  val route =
    path("hello") {
      get {
        complete {
          <h1>Say hello to akka-http</h1>
        }
      }
    } ~
    path("ws-echo") {
      get {
        handleWebsocketMessages(echoService)
      }
    }
 
  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
 
  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // for the future transformations
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.shutdown()) // and shutdown when done
  println("Server is down...")
}

