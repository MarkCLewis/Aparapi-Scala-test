package example

import com.aparapi._
import com.aparapi.device.Device
import com.aparapi.device.OpenCLDevice

object Hello extends Greeting {
  val inA = Array.fill(10000)(math.random)
  val inB = inA.map(1.0 - _)
  val result = inA.map(_ => 0.0)

  val kernel = new Kernel() {
    override def run(): Unit = {
        val i = getGlobalId()
        result(i) = inA(i) + inB(i)
    }
  }

  def main(args: Array[String]): Unit = {
    val devices = OpenCLDevice.listDevices(null)
    println(devices)
    println(greeting)
    val range = Range.create(result.length);
    kernel.execute(range);
    Thread.sleep(100)
    println(result.take(10).mkString(", "))
  }
}

trait Greeting {
  lazy val greeting: String = "hello"
}
