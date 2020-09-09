<#import "parts/common.ftl" as c>

<@c.page>
   Редактирование пользователя
    <form action="/user/" method="post">
        <div><input type="text" name="username" value="${user.username}"></div>
        <div><input type="text" name="password" value="${user.password}"></div>
        <div>
            <#list roles as role>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>
            </#list>
        </div>
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><button type="submit">Сохранить</button> </div>
    </form>
</@c.page>