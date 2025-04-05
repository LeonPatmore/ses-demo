package leon.patmore.ses

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SesApplicationTests {
    @Autowired
    private lateinit var sesEmailService: SesEmailService

    @Test
    fun `test email send`() {
        sesEmailService.sendEmail(
            "leon.patmore@gmail.com",
            "leon.patmore@gmail.com",
            "TestEmail",
            "Some Text",
            "<h1>HTML Body</h1><p>With SES</p>",
        )
    }
}
