package leon.patmore.ses

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.ses.SesClient

@Configuration
class Configuration {
    @Bean
    fun sesClient(): SesClient =
        SesClient
            .builder()
            .region(Region.of("eu-west-1"))
            .build()
}
