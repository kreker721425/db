<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>


<@c.page>
    <div>
        <@l.loguot/>
        <span><a href="/user"> Список пользователей </a></span>
    </div>
    <a href="/addRequest">Перейти на страницу ДОБАВИТЬ</a>

        Фильтр
    <div>
        <form method="get" action="/table">
            <input type="text" name="filterNumber" value="${filterNumber}">
            <button type="submit">Найти</button>
        </form>
    </div>

    <div><h1>Таблица</h1></div>
        <table border="1">
    <tr>
        <td style="width: 5%;" colspan="1" rowspan="2">№ заявки</td>
        <td style="width: 10%;" colspan="1" rowspan="2">Скачать файл заявки</td>
        <td style="width: 20%;" colspan="3" rowspan="1">Заказчик</td>
        <td style="width: 20%;" colspan="3" rowspan="1">Владелец</td>
        <td style="width: 20%;" colspan="2" rowspan="1">Услуги</td>
        <td style="width: 20%;" colspan="4" rowspan="1">Место проведения работ</td>
        <td style="width: 10%;" colspan="1" rowspan="2">Ответственный</td>
        <td style="width: 10%;" colspan="1" rowspan="2">Исполнитель</td>
        <td style="width: 10%;" colspan="1" rowspan="2">Срок выполнения</td>
        <td style="width: 10%;" colspan="1" rowspan="2">Статус</td>
        <td style="width: 10%;" colspan="1" rowspan="2">Дата сдачи</td>
    </tr>
    <tr>
        <td style="width: 7%;">Тип</td>
        <td style="width: 7%;">Имя</td>
        <td style="width: 7%;">Адрес</td>
        <td style="width: 7%;">Тип</td>
        <td style="width: 7%;">Имя</td>
        <td style="width: 7%;">Адрес</td>

        <td style="width: 7%;">ОИ</td>
        <td style="width: 7%;">ИЛЦ</td>

        <td style="width: 7%;">Район</td>
        <td style="width: 7%;">Город</td>
        <td style="width: 7%;">Улица</td>
        <td style="width: 7%;">Дом</td>
    </tr>

<#list list as initialData>
    <tr>
            <td>${initialData.request.number!}</td>
            <td>
                <#if initialData.request.filenameDoc??>
                    <a href="/f/${initialData.request.filename}">Скачать файл</a>
                </#if>
            </td>
            <td>${initialData.request.typeCustomer!}</td>
            <td>${initialData.request.nameCustomer!} </td>
            <td>${initialData.request.addressCustomer!}</td>
            <td>${initialData.request.typeOwner!}</td>
            <td>${initialData.request.nameOwner!}</td>
            <td>${initialData.request.addressOwner!}</td>

            <#list initialData.objectives as objective>
                <td>${objective.oiService}</td>
                <td>${objective.ilcService}</td>

                <td>${objective.districtWork}</td>
                <td>${objective.cityWork}</td>
                <td>${objective.streetWork}</td>
                <td>${objective.houseWork}</td>

                <td>${objective.responsible}</td>
                <td>${objective.executor}</td>
                <td>${objective.deadline}</td>
                <td>${objective.status}</td>
                <td>${objective.dateCompleted}</td>
            </#list>
            <#--<td>${request.districtWork!}</td>
            <td>${request.cityWork!}</td>
            <td>${request.streetWork!}</td>
            <td>${request.houseWork!}</td>
            <td>${request.responsible!}</td>-->
        <#else>
        <b> Нет заявок </b>
    </#list>
    <#--</table>
    <form method="get" action="/table">
        <button type="submit">Найти</button>
    </form>-->
</@c.page>