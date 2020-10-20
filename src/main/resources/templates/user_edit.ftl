<#import "macros/common.ftl" as c>
<#import "macros/input_form.ftl" as input>

<@c.title>
    Редактирование пользователя
</@c.title>

<@c.style>
</@c.style>

<@c.body>

    <form action="/user/" method="post" class="needs-validation col-md-3 mx-auto mt-5">
        <div class="form-group text-center">
            <h2>Редактирование пользователя</h2>
        </div>
        <div class="form-group">
            <@input.input id="username" type="text" label="Логин" value="${user.username}"/>
        </div>
        <div class="form-group">
            <@input.input id="password" type="text" label="Пароль" value="${user.password}"/>
        </div>
        <div class="form-group">
            <@input.input id="name" type="text" label="Имя" value="${user.name}"/>
        </div>
        <div class="form-group">
            <#list roles as role>
                <div class="custom-control custom-switch ml-1 mb-1">
                    <input type="checkbox" class="custom-control-input" id="${role}"
                           name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>
                    <label class="custom-control-label" for="${role}">${role}</label>
                </div>
            </#list>
        </div>
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary col-md-12 mt-2">Сохранить</button>
    </form>

</@c.body>