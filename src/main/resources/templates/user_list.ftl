<#import "macros/common.ftl" as c>

<@c.title>
    Список пользователей
</@c.title>

<@c.style>
</@c.style>

<@c.body>

    <table class="table mx-auto mt-5" style="width: 60%;text-align: center;">
        <thead>
        <tr>
            <th colspan="5" style="text-align: center;">
                <h2>Список пользователей</h2>
            </th>
        </tr>
        <tr>
            <th colspan="5">
                <a href="/registration">
                    <button type="submit" class="btn btn-primary" style="width: 100%">Добавить нового пользователя
                    </button>
                </a>
            </th>
        </tr>
        <tr class="table-primary">
            <th scope="col">Имя</th>
            <th scope="col">Логин</th>
            <th scope="col">Пароль</th>
            <th scope="col" colspan="2">Команды</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>,</#list></td>
                <td>
                    <a href="/user/user_edit/${user.id}">
                        <button type="submit" class="btn btn-primary col-md-12 mt-2">Редактировать</button>
                    </a>
                </td>
                <td>
                    <a href="/user/delete/${user.id}">
                        <button type="submit" class="btn btn-primary col-md-12 mt-2">Удалить</button>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.body>