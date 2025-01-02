package io.github.luancmartins

import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.classreading.MetadataReader
import org.springframework.core.type.classreading.MetadataReaderFactory
import org.springframework.core.type.filter.TypeFilter

@Configuration
class BeanScannerConfiguration {
    /*companion object {
        @Bean
        fun beanFactoryPostProcessor(): BeanFactoryPostProcessor {
            return BeanFactoryPostProcessor { beanFactory ->
                val registry = beanFactory as BeanDefinitionRegistry
                configureBeanScanner(registry)
            }
        }

        private fun configureBeanScanner(beanRegistry: BeanDefinitionRegistry) {
            val scanner = ClassPathBeanDefinitionScanner(beanRegistry)
            scanner.addExcludeFilter { metadataReader, _ ->
                metadataReader.annotationMetadata.hasAnnotation(SpringBootApplication::class.java.name)
            }
            scanner.addIncludeFilter(excludeDatabaseClassesFilter())
            scanner.scan("io.github.luancmartins")
        }

        private fun excludeDatabaseClassesFilter(): TypeFilter {
            return TypeFilter { metadataReader, _ ->
                !metadataReader.classMetadata.className.endsWith("Database")
            }
        }
    }*/
}