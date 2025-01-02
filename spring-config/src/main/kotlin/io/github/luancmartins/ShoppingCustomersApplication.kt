package io.github.luancmartins

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["io.github.luancmartins.repository"])
@ComponentScan(basePackages = ["io.github.luancmartins"])
class ShoppingCustomersApplication

fun main(args: Array<String>) {
    runApplication<ShoppingCustomersApplication>(*args)
}