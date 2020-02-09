package com.github.alikemalocalan.urldownloader.model

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

case class UrlOperation(url: String, fileNameAndPath: String)

object UrlOperationProtocol extends DefaultJsonProtocol {
  implicit val urlOperationJsonFormat: RootJsonFormat[UrlOperation] = jsonFormat2(UrlOperation)
}