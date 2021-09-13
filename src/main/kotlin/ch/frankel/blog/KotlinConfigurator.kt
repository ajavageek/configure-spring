package ch.frankel.blog

import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

class KotlinConfigurator : ContextConfigurator {

    override fun getContext(): ApplicationContext = GenericApplicationContext()
        .apply {
            beans {
                bean("john") {
                    Person("John Doe")
                }
                bean("jane") {
                    Person("Jane Doe", ref("john"))
                }
            }.initialize(this)
            refresh()
        }
}
