<#import "parts/common.ftl" as c>
<#import "parts/utils.ftl" as u>


<@c.page>
    <div><a href="/table">Вернуться</a></div>
    <h2>Сохранить измерения</h2>
    <div>
        <form method="post" action="/addRequest" enctype="multipart/form-data">
            <table>
                <tr><td style="width: 30%;"> </td></tr>

                <tr><td>Номер заявки : </td>
                    <td class="form-group"> <input type="text" <#--class="form-control ${(numberError??)?string('is-invalid','')}"-->
                                                   name="number"<#-- value="<#if request??>${request.number}</#if>"-->/></td></tr>
                <#--<#if numberError??>
                    <div class="invalid-feedback">
                        ${numberError}
                    </div>
                </#if>-->
                <tr><td>Какого типа заказчик : </td>
                    <td><input type="text" class="form-control ${(typeCustomerError??)?string('is-invalid','')}"
                               name="typeCustomer" value="<#if request??>${request.typeCustomer}</#if>"/>
                        <#if typeCustomerError??>
                            <div class="invalid-feedback">
                                ${typeCustomerError}
                            </div>
                        </#if>
                    </td></tr>
                <tr><td>Наименование заказчика : </td>
                    <td><input type="text" name="nameCustomer"/></td></tr>
                <tr><td>Адрес заказчика : </td>
                    <td><input type="text" name="addressCustomer"/></td></tr>
                <tr><td>Какого типа хозяин : </td>
                    <td><input type="text" name="typeOwner"/></td></tr>
                <tr><td>Наименование хозяина : </td>
                    <td><input type="text" name="nameOwner"/></td></tr>
                <tr><td>Адрес хозяина : </td>
                    <td><input type="text" name="addressOwner"/></td></tr>
                <tr><td>ОИ : </td>
                    <td><input type="checkbox" name="oiService"></td></tr>
                <tr><td>ИЛЦ : </td>
                    <td><input type="checkbox" name="ilcService"></td></tr>
                <tr><td>Район : </td>
                    <td><input type="text" name="districtWork"/></td></tr>
                <tr><td>Город : </td>
                    <td><input type="text" name="cityWork"/></td></tr>
                <tr><td>Улица : </td>
                    <td><input type="text" name="streetWork"/></td></tr>
                <tr><td>Дом : </td>
                    <td><input type="text" name="houseWork"/></td></tr>
                <tr><td>Ответственный : </td>
                    <td><input type="text" name="responsible"/></td></tr>
                <tr><td>Файл заявки : </td>
                    <td><input type="file" name="file"> </td></tr>

                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <tr><td><button type="submit">Добавить</button> </td></tr>
            </table>
        </form>
    </div>
</@c.page>