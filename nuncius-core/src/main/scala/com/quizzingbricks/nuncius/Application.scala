package com.quizzingbricks.nuncius

import akka.actor._
import scala.concurrent.duration._
import akka.zeromq._
import akka.util.ByteString

object Application extends App {
  val system = ActorSystem("Nuncius")
  val nuncius = system.actorOf(Props[NunciusService], "nunciusActor")
}

class NunciusService extends Actor with ActorLogging {
  val repSocket = ZeroMQExtension(context.system)
    .newRepSocket(Array(Bind("tcp://*:5556"), Listener(self)))

  override def preStart = {
    println("Starting NunciusService")
  }

  def receive = {
    case Connecting => println("Connecting")
    case msg: ZMQMessage => {
      log.info("Received message")
      repSocket ! ZMQMessage(ByteString("1"), ByteString("{\"id\": \"657\", \"username\": \"akka\"}"))
    }
    case _ => log.info("Unknown message")
  }
}