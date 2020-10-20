<#import "macros/login.ftl" as l>
<#import "macros/common.ftl" as c>
<#include "utils/security.ftl">


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<@c.title>
    Заявки
</@c.title>

<@c.style>
    <#include "css/table.css">
</@c.style>

<@c.body>
    <div class="mt-2 ml-1">
        <input type="text" id="input" onkeyup="tableFilter()" placeholder="Поиск">
    </div>
    <table id="table" class="table table-hover">
        <thead>
        <tr class="table-primary">
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 7%">№ заявки</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 6%">Скачать файл заявки</th>
            <th scope="col" colspan="3" rowspan="1" class="header1" style="width: 24%">Заказчик</th>
            <th scope="col" colspan="2" rowspan="1" class="header1" style="width: 16%">Услуги</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 8%">Место проведения работ</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 7%">Ответственный</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 7%">Исполнитель</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 6%">Срок выполнения</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 7%">Статус</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 6%">Дата сдачи</th>
            <th scope="col" colspan="1" rowspan="2" class="header1" style="width: 4%">План/Договор</th>
        </tr>
        <tr class="table-primary">
            <th scope="col" class="header2" style="width: 8%">Тип</th>
            <th scope="col" class="header2" style="width: 8%">Имя</th>
            <th scope="col" class="header2" style="width: 8%">Адрес</th>

            <th scope="col" class="header2" style="width: 8%">ОИ</th>
            <th scope="col" class="header2" style="width: 8%">ИЛЦ</th>
        </tr>
        </thead>
        <tbody>
        <#--    onclick="alert('Err!')"     ошибка-->

        <#list list as objective>
            <tr>
                <td>
                    <div class="font-weight-bold">
                        ${objective.request.number!}
                    </div>

                    <#if isAdmin>
                        <div>
                            <a href="objective_edit/${objective.id}">
                                <button type="button" class="btn btn-outline-primary btn-sm">Изменить</button>
                            </a>
                        </div>
                    </#if>
                </td>
                <td>
                    <#if objective.request.filename??>
                        <a href="/download_request_file/${objective.request.filename}">
                            <button type="button" class="btn btn-outline-primary btn-sm"> Скачать</button>
                        </a>
                    </#if>
                </td>
                <td>${objective.request.typeCustomer!}</td>
                <td>${objective.request.nameCustomer!} </td>
                <td>${objective.request.addressCustomer!}</td>

                <td>
                    <#list objective.measuresOI as oi>
                        <div>${oi.text}</div>
                    <#else>
                        НЕТ
                    </#list>
                </td>
                <td>
                    <#list objective.measuresILC as ilc>
                        <div>${ilc.text}</div>
                    <#else>
                        НЕТ
                    </#list>
                </td>

                <td>${objective.addressWork!}</td>
                <td>${objective.responsible!}</td>
                <td>${objective.executor!}</td>
                <td>${objective.deadline!}</td>
                <td><#if objective.status>
                        <a href="measure/${objective.id}">
                            <button type="button" class="btn btn-outline-primary btn-sm">Измерения</button>
                        </a>
                    <#else>
                        <a href="execute_objective/${objective.id}">
                            <button type="button" class="btn btn-outline-danger btn-sm">Выполнить</button>
                        </a>
                    </#if></td>
                <td>${objective.dateCompleted!}</td>
                <td>${objective.typeOfPayment!}</td>
            </tr>

        <#else>
            <b> Нет заявок </b>
        </#list>
        </tbody>
    </table>

    <script>
        <#include "js/filter.js">
    </script>

</@c.body>
