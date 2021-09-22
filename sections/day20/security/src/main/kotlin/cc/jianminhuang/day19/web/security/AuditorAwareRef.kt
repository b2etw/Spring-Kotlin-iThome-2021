package cc.jianminhuang.day19.web.security

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.Optional


@Component
class AuditorAwareRef : AuditorAware<String> {

    override fun getCurrentAuditor() = run {
        val authentication = SecurityContextHolder.getContext().authentication
        if (null == authentication || !authentication.isAuthenticated) {
            Optional.of("")
        } else {
            Optional.of(authentication.name)
        }
    }
}