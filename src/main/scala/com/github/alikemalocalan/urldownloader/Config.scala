package com.github.alikemalocalan.urldownloader

import com.typesafe.config.ConfigFactory

trait Config {
  private val config = ConfigFactory.load
  private val hostConfig = config.getConfig("http")

  val address: String = hostConfig.getString("interface")
  val port: Int = hostConfig.getInt("port")

  //val bucketName: String = "instagram-private-stories"
  //val region: String = hostConfig.getString("bucketName")

}
