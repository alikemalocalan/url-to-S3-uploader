package com.github.alikemalocalan.urldownloader

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{entity, _}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.post
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.stream.ActorMaterializer
import com.github.alikemalocalan.logging.RequestLoggingAdapter
import com.github.alikemalocalan.urldownloader.model._

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success}

object App extends App with Config {

  implicit val actorSystem: ActorSystem = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor = actorSystem.dispatcher
  val logger = actorSystem.log
  val s3Service = S3ClientService

  lazy val fileUploadRoutes: Route = path("upload") {
    import com.github.alikemalocalan.urldownloader.model.UrlOperationProtocol._
    post {
      entity(as[UrlOperation]) { ops =>
        logger.info(s"Request: Url: ${ops.url}, s3folder: ${ops.fileNameAndPath}")
        s3Service.uploadUrl(ops)
        complete(StatusCodes.Created)
      }

    }
  }

  Http().bindAndHandle(RequestLoggingAdapter.clientRouteLogged(fileUploadRoutes), interface = address, port = port).onComplete {
    case Success(b) => logger.info(s"application is up and running at ${b.localAddress.getHostName}:${b.localAddress.getPort}")
    case Failure(e) => logger.error(s"could not start application: {}", e.getMessage)
  }

  println(s"Server online at http://$address:$port/")
}
