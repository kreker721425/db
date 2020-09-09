<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Registration
    <div>
        ${messageErr!}
    </div>
    <@l.login "registration">
        <div>
            <#list roles as role>
                <label><input type="checkbox" name="${role}">${role}</label>
            </#list>
        </div>
        <div><input type="submit" value="Добавить пользователя"/></div>
    </@l.login>
</@c.page>