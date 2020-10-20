<#assign
know = Session.SPRING_SECURITY_CONTEXT??
>

<#if know>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    username = user.getUsername()
    isAdmin = user.getAuthorities()?seq_contains('ADMIN')
    >
<#else>
    <#assign
    username = ""
    isAdmin = false
    >
</#if>