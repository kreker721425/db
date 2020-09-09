<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Login
    <div>
        ${messageErr!}
    </div>
    <@l.login "login">
    <div><input type="submit" value="Sign In"/></div>
    </@l.login>
</@c.page>