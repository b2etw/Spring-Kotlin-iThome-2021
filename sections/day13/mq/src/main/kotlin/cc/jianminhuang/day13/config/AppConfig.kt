package cc.jianminhuang.day13.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Declarables
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun simpleQueue() = Queue("simple", false)

    @Bean
    fun broadcastQueue() = Queue("broadcast", false)

    @Bean
    fun exchange() = TopicExchange("test")

    @Bean
    fun bindings() = Declarables(
        BindingBuilder.bind(simpleQueue()).to(exchange()).with("broadcast"),
        BindingBuilder.bind(broadcastQueue()).to(exchange()).with("broadcast"),
        BindingBuilder.bind(simpleQueue()).to(exchange()).with("simple"),
    )
}