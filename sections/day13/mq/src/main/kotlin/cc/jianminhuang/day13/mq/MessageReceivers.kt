package cc.jianminhuang.day13.mq

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageReceivers {

    private val logger = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = ["simple"])
    fun handleSimple(msg: String) = logger.info("simple -> $msg")

    @RabbitListener(queues = ["broadcast"])
    fun handleBroadcast(msg: String) = logger.info("broadcast -> $msg")

}