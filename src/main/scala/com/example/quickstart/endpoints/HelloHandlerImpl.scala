package com.example.quickstart.endpoints.hello

import cats.Applicative
import cats.implicits._
import com.example.quickstart.endpoints.definitions.HelloResponse

class HelloHandlerImpl[F[_] : Applicative]() extends HelloHandler[F] {
  override def getHello(respond: GetHelloResponse.type)(name: Option[String] = None): F[GetHelloResponse] = {
    for {
      message <- s"Hello, ${name.getOrElse("world")}".pure[F]
    } yield respond.Ok(HelloResponse(message))
  }
}