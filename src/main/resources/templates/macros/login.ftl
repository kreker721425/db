<#import "input_form.ftl" as input>

<#macro login path btn welc>
    <form action="${path}" method="post" class="needs-validation col-md-3 mx-auto mt-5">
        <div class="form-group text-center">
            <h2>${welc}</h2>
        </div>
        <div class="form-group">
            <@input.input id="username" type="text" label="Логин" value=""/>
        </div>
        <div class="form-group">
            <@input.input id="password" type="password" label="Пароль" value=""/>
        </div>
        <#nested>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary col-md-12 mt-2">${btn}</button>
    </form>
</#macro>

<#macro loguot>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary my-2 mx-2" type="submit">Выйти</button>
    </form>
</#macro>