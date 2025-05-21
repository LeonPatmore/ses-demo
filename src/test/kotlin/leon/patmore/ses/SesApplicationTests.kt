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
            "sender@leonpatmore.com",
            listOf("lpatmore@moneylion.com", "leon.patmore@bath.edu"),
            "TestEmail",
            "Some Text",
            "<h1>HTML Body</h1><p>With SES</p>",
        )
    }
}
