package services

import com.spotify.docker.client.DefaultDockerClient

import scala.util.{Failure, Success, Try}
class DockerService {


  def pull(image: String): Either[String, BobError] = {
    val dockerClient = DefaultDockerClient
      .fromEnv()
      .build()
    Try(dockerClient.pull(image)) match {
      case Failure(_) => Right(DockerError(s"could not fetch image: $image"))
      case Success(_) => Left(image)
    }
  }
}

trait BobError

case class DockerError(message: String) extends BobError
