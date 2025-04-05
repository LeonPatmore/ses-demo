package leon.patmore.ses

import org.springframework.stereotype.Service
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.ses.model.Body
import software.amazon.awssdk.services.ses.model.Content
import software.amazon.awssdk.services.ses.model.Destination
import software.amazon.awssdk.services.ses.model.Message
import software.amazon.awssdk.services.ses.model.SendEmailRequest
import software.amazon.awssdk.services.ses.model.SesException

@Service
class SesEmailService(
    private val sesClient: SesClient,
) {
    fun sendEmail(
        sender: String?,
        recipient: String?,
        subject: String?,
        textBody: String?,
        htmlBody: String?,
    ) {
        try {
            val subjectContent: Content = Content.builder().data(subject).build()
            val body: Body =
                Body
                    .builder()
                    .text(Content.builder().data(textBody).build())
                    .html(Content.builder().data(htmlBody).build())
                    .build()

            val message: Message =
                Message
                    .builder()
                    .subject(subjectContent)
                    .body(body)
                    .build()

            val request: SendEmailRequest =
                SendEmailRequest
                    .builder()
                    .source("sender@leonpatmore.com")
                    .destination(Destination.builder().toAddresses(recipient).build())
                    .message(message)
                    .build()

            val response = sesClient.sendEmail(request)
            println("Email sent with message ID: " + response.messageId())
        } catch (e: SesException) {
            throw RuntimeException("Failed to send email via SES", e)
        }
    }
}
