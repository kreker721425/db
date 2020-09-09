<#import "parts/common.ftl" as c>

<@c.page>
    Список пользователей
    <div><a href="/registration">Добавить нового пользователя</a></div>
    <div>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Role</th>
                <th>Commands</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.username}</td>
                    <td><#list user.roles as role>${role}<#sep>,</#list></td>
                    <td><a href="/user/userEdit/${user.id}">Редактировать</a> </td>
                    <td><a href="/user/delete/${user.id}">Удалить</a> </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>