import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.util.{Await, Future}

object Client {


  def main(args: Array[String]): Unit = {
    //define a client
    val client: Service[http.Request, http.Response] = Http.newService("localhost:9010")
    //define a request
    val request = http.Request(http.Method.Get, "/?num=7")
    //apply request on the client
    val response = client(request)
    //print response
    response.foreach(rep => println(rep.getContentString()))
    Await.result(response)
  }

}
