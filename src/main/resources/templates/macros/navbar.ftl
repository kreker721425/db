<#include "../utils/security.ftl">
<#import "login.ftl" as l>

<#macro navbar>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
        <a class="navbar-brand" href="/">Таблица</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/add_request">Добавить заявку</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/add_objective">Добавить задачу</a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/user">Список пользователей</a>
                    </li>
                </#if>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <div class="navbar-text">${username}</div>
            </form>
            <#if username!="">
                <@l.loguot/>
            </#if>
        </div>
    </nav>
</#macro>