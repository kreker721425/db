<#import "macros/login.ftl" as l>
<#import "macros/input_form.ftl" as input>
<#import "macros/common.ftl" as c>

<@c.title>
    Регистрация
</@c.title>

<@c.style>
</@c.style>

<@c.body>

    <@l.login path="registration" btn="Зарегистрировать" welc="Регистрация">
        <div class="form-group">
            <@input.input id="name" type="text" label="Имя" value=""/>
        </div>
        <div class="form-group">
            <#list roles as role>
                <@input.checkbox_form id="${role}" label="${role}"/>
            </#list>
        </div>
    </@l.login>

</@c.body>