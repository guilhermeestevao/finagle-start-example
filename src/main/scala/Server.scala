import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.util.{Await, Future}

object Server {

  def main(args: Array[String]): Unit = {
    val service: Service[http.Request, http.Response] = new PlusTenService
    val server = Http.serve(":9010", service)
    Await.ready(server)
  }

}
