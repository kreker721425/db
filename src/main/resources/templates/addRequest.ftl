<#import "parts/common.ftl" as c>
<#import "parts/utils.ftl" as u>


<@c.page>
    <div><a href="/table">Вернуться</a></div>
    <h2>Добавить</h2>
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

                <tr></tr>
                <tr><td>ОИ : </td>
                    <td><input type="checkbox" name="oiService"></td></tr>
                <tr><td>Экспертиза проекта по РТО : </td>
                    <td><input type="checkbox" name="expertiseProjectRTO"></td></tr>
                <tr><td>Экспертиза ввод в эксплуатацию по РТО : </td>
                    <td><input type="checkbox" name="expertiseCommissioningRTO"></td></tr>
                <tr><td>Экспертиза на условия работ с ИФФ : </td>
                    <td><input type="checkbox" name="expertiseIFF"></td></tr>
                <tr><td>Экспертиза по результатам проведенных исследований : </td>
                    <td><input type="checkbox" name="expertiseResearchResults"></td></tr>

                <tr></tr>
                <tr><td>ИЛЦ : </td>
                    <td><input type="checkbox" name="ilcService"></td></tr>
                <tr><td>Шум : </td>
                    <td><input type="checkbox" name="measurementsNoise"></td></tr>
                <tr><td>Вибрация : </td>
                    <td><input type="checkbox" name="measurementsVibration"></td></tr>
                <tr><td>Микроклимат : </td>
                    <td><input type="checkbox" name="measurementsMicroclimate"></td></tr>
                <tr><td>Освещенность : </td>
                    <td><input type="checkbox" name="measurementsIllumination"></td></tr>
                <tr><td>Лазерное излучение : </td>
                    <td><input type="checkbox" name="measurementsLaserRadiation"></td></tr>
                <tr><td>Аэроионы : </td>
                    <td><input type="checkbox" name="measurementsAeroions"></td></tr>
                <tr><td>Ультразвук : </td>
                    <td><input type="checkbox" name="measurementsUltrasound"></td></tr>
                <tr><td>Инфразвук : </td>
                    <td><input type="checkbox" name="measurementsInfrasound"></td></tr>
                <tr><td>ЭМП ВЧ : </td>
                    <td><input type="checkbox" name="measurementsVCH"></td></tr>
                <tr><td>ЭМП ВДТ : </td>
                    <td><input type="checkbox" name="measurementsVDT"></td></tr>
                <tr><td>ЭМП СВЧ : </td>
                    <td><input type="checkbox" name="measurementsSVCH"></td></tr>
                <tr><td>ЭМП 50гц : </td>
                    <td><input type="checkbox" name="measurements50Hg"></td></tr>
                <tr><td>ПМП : </td>
                    <td><input type="checkbox" name="measurementsPMP"></td></tr>

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