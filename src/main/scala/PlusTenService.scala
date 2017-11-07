import com.twitter.finagle.Service
import com.twitter.util.Future
import com.twitter.finagle.http
// This is a plus 10 service
class PlusTenService extends Service[http.Request, http.Response] {
  override def apply(request: http.Request): Future[http.Response] = {
    Future {
      val input1 = request.getIntParam("num1")
      val input2 =  request.getIntParam("num2")
      val opc =  request.getParam("opc");
      
      println("Numero 1 "+input1);
      println("Numero 2 "+input2);
      println("Operação  "+opc);

      val result = opc match {
        case "sum" => input1 + input2
        case "min" => input1 - input2
        case "mult" => input1 * input2
        case "div" => input1 / input2
        case _ => "Operação invalida!"
      };


      val ouutput = input1 +" "+opc +" "+input2 +" = "+result;

      val response = http.Response(request.version, http.Status.Ok)
      response.setContentString(ouutput)
      response
    }
  }
}