package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import services.DockerService

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class MainController @Inject()(controllerComponents: ControllerComponents)
  extends AbstractController(controllerComponents) {

  def pull(image: String) = Action.async {
    Future(new DockerService().pull(image) match {
      case Left(value) => Ok(s"Success $value")
      case Right(value) => Ok(s"Could not fetch image $value")
    })
  }
}
