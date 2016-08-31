/**
  * Created by sulav on 8/29/16.
  */

import org.apache.spark.{SparkConf, SparkContext}
import org.json4s.DefaultFormats

object sentence_count {

  def main(args: Array[String]) {
    implicit val formats = DefaultFormats
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
    val sc = new SparkContext(conf)

    val txtfile = sc.textFile("labsentence.txt").flatMap(line => line.split("\\.")).sortBy[String]({a => a})//.flatMap(a => a)
    //txtfile.collect().foreach(a => println(a))
    println(txtfile.count())
    txtfile.collect().foreach(a => println(a))
    /*println(txtfile.count())
    val sorted_txt = txtfile.sortBy[String]({a => a})
    sorted_txt.collect().foreach(a => println(a))
*/
  }
}