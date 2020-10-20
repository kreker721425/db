<#import "macros/common.ftl" as c>
<#import "macros/input_form.ftl" as input>

<@c.title>
    Добавить задачу
</@c.title>

<@c.style>
</@c.style>

<@c.body>
    <form class="needs-validation" novalidate method="post" action="/add_objective" enctype="multipart/form-data">
        <table style="width: 98%;margin: auto" class="mt-2">
            <tr class="table-primary">
                <th colspan="2" style="text-align: center">
                    <h4>Добавление новой задачи</h4>
                </th>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="form-row">
                        <div class="col-md-2 mb-3">
                            <@input.input id="number" type="number" label="Номер заявки" value=""/>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.select id="responsible" label="Ответственный">
                                <#list users as user>
                                    <#list user.roles as role>
                                        <#if role="ADMIN">
                                            <option value="${user.name}">${user.name}</option>
                                        </#if>
                                    </#list>
                                </#list>
                            </@input.select>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.select id="executor" label="Исполнитель">
                                <#list users as user>
                                    <option value="${user.name}">${user.name}</option>
                                </#list>
                            </@input.select>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.input id="dead_line" type="date" label="Срок выполнения" value=""/>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.select id="typeOfPayment" label="План/Договор">
                                <option value="План">План</option>
                                <option value="Договор">Договор</option>
                            </@input.select>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.file id="file" label="Файл заявки"/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr class="table-primary">
                <th style="width: 60%;text-align: center">
                    Место проведения работ
                </th>
                <th style="width: 40%;text-align: center">
                    ОИ
                </th>
            </tr>
            <tr>
                <td>
                    <div class="form-row">
                        <div class="col-md-3 mb-3">
                            <@input.input id="districtWork" type="text" label="Район" value=""/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <@input.input id="cityWork" type="text" label="Город" value=""/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <@input.input id="streetWork" type="text" label="Улица" value=""/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <@input.input id="houseWork" type="text" label="Дом/Квартира" value=""/>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="ml-5">
                        <@input.checkbox_form id="ProjectRTO" label="Экспертиза проекта по РТО"/>
                        <@input.checkbox_form id="CommissioningRTO" label="Экспертиза ввод в эксплуатацию по РТО"/>
                        <@input.checkbox_form id="IFF" label="Экспертиза на условия работ с ИФФ"/>
                        <@input.checkbox_form id="ResearchResults" label="Экспертиза по результатам проведенных исследований"/>
                    </div>
                </td>
            </tr>
            <tr class="table-primary">
                <th style="text-align: center">
                </th>
                <th style="text-align: center">
                    ИЛЦ
                </th>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>
                                <div class="ml-5 mr-2">
                                    <@input.checkbox_form id="Noise" label="Шум"/>
                                    <@input.checkbox_form id="Vibration" label="Вибрация"/>
                                    <@input.checkbox_form id="Microclimate" label="Микроклимат"/>
                                    <@input.checkbox_form id="Illumination" label="Освещенность"/>
                                    <@input.checkbox_form id="LaserRadiation" label="Лазерное излучение"/>
                                </div>
                            </td>
                            <td>
                                <@input.checkbox_form id="Aeroions" label="Аэроионы"/>
                                <@input.checkbox_form id="Ultrasound" label="Ультразвук"/>
                                <@input.checkbox_form id="Infrasound" label="Инфразвук"/>
                                <@input.checkbox_form id="VCH" label="ЭМП ВЧ"/>
                            </td>
                            <td>
                                <div class="ml-4">
                                    <@input.checkbox_form id="VDT" label="ЭМП ВДТ"/>
                                    <@input.checkbox_form id="SVCH" label="ЭМП СВЧ"/>
                                    <@input.checkbox_form id="m50Hg" label="ЭМП 50гц"/>
                                    <@input.checkbox_form id="PMP" label="ПМП"/>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary btn-lg btn-block btn-rounded">Добавить заявку</button>
                </td>
            </tr>
        </table>
    </form>


    <script>
        <#include "js/validation.js">
    </script>

</@c.body>