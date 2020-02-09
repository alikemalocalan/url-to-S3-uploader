package com.github.alikemalocalan.urldownloader

import com.github.alikemalocalan.urldownloader.model.UrlOperation
import org.apache.commons.logging.LogFactory
import org.scalatest.flatspec.AnyFlatSpec

class S3ClientServiceTest extends AnyFlatSpec {
  val logger = LogFactory.getLog(this.getClass)

  val s3Service = S3ClientService

  it should "uploadS3 test" in {
    val ops = UrlOperation(
      "https://farm9.staticflickr.com/8521/8530227999_804a068e21_b.jpg",
      "data/test.jpeg"
    )
    s3Service.uploadUrl(ops)
  }

}
