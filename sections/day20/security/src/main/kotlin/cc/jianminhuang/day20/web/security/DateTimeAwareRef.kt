package cc.jianminhuang.day20.web.security

import org.springframework.data.auditing.DateTimeProvider
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.temporal.TemporalAccessor
import java.util.Optional

@Component
class DateTimeAwareRef : DateTimeProvider {

    override fun getNow(): Optional<TemporalAccessor> = Optional.of(Instant.now())
}