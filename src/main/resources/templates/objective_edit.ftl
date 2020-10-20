<#import "macros/common.ftl" as c>
<#import "macros/input_form.ftl" as input>

<@c.title>
    Добавить заявку
</@c.title>

<@c.style>
</@c.style>

<@c.body>
    <form class="needs-validation" novalidate method="post" action="/table/objective_edit/"
          enctype="multipart/form-data">
        <table style="width: 98%;margin: auto" class="mt-2">
            <tr class="table-primary">
                <th colspan="2" style="text-align: center">
                    <h4>Меню изменения заявки</h4>
                </th>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="form-row">
                        <div class="col-md-2 mb-3">
                            <@input.input id="number" type="number" label="Номер заявки" value="${objective.request.number}"/>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.select_edit id="responsible" label="Ответственный" value="${objective.responsible}">
                                <#list users as user>
                                    <#if user.name != objective.responsible>
                                        <#list user.roles as role>
                                            <#if role="ADMIN">
                                                <option value="${user.name}">${user.name}</option>
                                            </#if>
                                        </#list>
                                    </#if>
                                </#list>
                            </@input.select_edit>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.select_edit id="executor" label="Исполнитель" value="${objective.executor}">
                                <#list users as user>
                                    <#if user.name != objective.executor>
                                        <option value="${user.name}">${user.name}</option>
                                    </#if>
                                </#list>
                            </@input.select_edit>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.input id="deadline" type="date" label="Срок выполнения" value="${yy}-${mm}-${dd}"/>
                        </div>
                        <div class="col-md-2 mb-3">
                            <@input.select_edit id="typeOfPayment" label="План/Договор" value="${objective.typeOfPayment}">
                                <option value="План">План</option>
                                <option value="Договор">Договор</option>
                            </@input.select_edit>
                        </div>


                        <#--***************ВАЛИДАЦИЯ ФАЙЛА*********************-->


                        <div class="col-md-2 mb-3">
                            <@input.file id="file" label="Файл заявки"/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr class="table-primary">
                <th style="width: 60%;text-align: center">
                    Заказчик
                </th>
                <th style="width: 40%;text-align: center">
                    ОИ
                </th>
            </tr>
            <tr>
                <td>
                    <div class="form-row">
                        <div class="col-md-2 mb-3">
                            <@input.select_edit id="typeCustomer" label="Тип" value="${objective.request.typeCustomer}">
                                <option value="Физ.лицо">Физ.лицо</option>
                                <option value="Юр.лицо">Юр.лицо</option>
                                <option value="Роспотребнадзор">Роспотребнадзор</option>
                                <option value="Прокуратора">Прокуратора</option>
                            </@input.select_edit>
                        </div>
                        <div class="col-md-5 mb-3">
                            <@input.input id="nameCustomer" type="text" label="Наименование" value="${objective.request.nameCustomer}"/>
                        </div>
                        <div class="col-md-5 mb-3">
                            <@input.input id="addressCustomer" type="text" label="Адрес" value="${objective.request.addressCustomer}"/>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="ml-5">
                        <#if objective.projectRTO>
                            <@input.checkbox_form_on id="ProjectRTO" label="Экспертиза проекта по РТО"/>
                        <#else>
                            <@input.checkbox_form id="ProjectRTO" label="Экспертиза проекта по РТО"/>
                        </#if>
                        <#if objective.commissioningRTO>
                            <@input.checkbox_form_on id="CommissioningRTO" label="Экспертиза ввод в эксплуатацию по РТО"/>
                        <#else>
                            <@input.checkbox_form id="CommissioningRTO" label="Экспертиза ввод в эксплуатацию по РТО"/>
                        </#if>
                        <#if objective.iff>
                            <@input.checkbox_form_on id="IFF" label="Экспертиза на условия работ с ИФФ"/>
                        <#else>
                            <@input.checkbox_form id="IFF" label="Экспертиза на условия работ с ИФФ"/>
                        </#if>
                        <#if objective.researchResults>
                            <@input.checkbox_form_on id="ResearchResults" label="Экспертиза по результатам проведенных исследований"/>
                        <#else>
                            <@input.checkbox_form id="ResearchResults" label="Экспертиза по результатам проведенных исследований"/>
                        </#if>
                    </div>
                </td>
            </tr>
            <tr class="table-primary">
                <th style="text-align: center">
                    Место проведения работ
                </th>
                <th style="text-align: center">
                    ИЛЦ
                </th>
            </tr>
            <tr>
                <td>
                    <div class="form-row">
                        <div class="col-md-3 mb-3">
                            <@input.input id="districtWork" type="text" label="Район" value="${objective.districtWork}"/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <@input.input id="cityWork" type="text" label="Город" value="${objective.cityWork}"/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <@input.input id="streetWork" type="text" label="Улица" value="${objective.streetWork}"/>
                        </div>
                        <div class="col-md-3 mb-3">
                            <@input.input id="houseWork" type="text" label="Дом/Квартира" value="${objective.houseWork}"/>
                        </div>
                    </div>
                </td>
                <td>
                    <table>
                        <tr>
                            <td>
                                <div class="ml-5 mr-2">
                                    <#if objective.noise>
                                        <@input.checkbox_form_on id="Noise" label="Шум"/>
                                    <#else>
                                        <@input.checkbox_form id="Noise" label="Шум"/>
                                    </#if>
                                    <#if objective.vibration>
                                        <@input.checkbox_form_on id="Vibration" label="Вибрация"/>
                                    <#else>
                                        <@input.checkbox_form id="Vibration" label="Вибрация"/>
                                    </#if>
                                    <#if objective.microclimate>
                                        <@input.checkbox_form_on id="Microclimate" label="Микроклимат"/>
                                    <#else>
                                        <@input.checkbox_form id="Microclimate" label="Микроклимат"/>
                                    </#if>
                                    <#if objective.illumination>
                                        <@input.checkbox_form_on id="Illumination" label="Освещенность"/>
                                    <#else>
                                        <@input.checkbox_form id="Illumination" label="Освещенность"/>
                                    </#if>
                                    <#if objective.laserRadiation>
                                        <@input.checkbox_form_on id="LaserRadiation" label="Лазерное излучение"/>
                                    <#else>
                                        <@input.checkbox_form id="LaserRadiation" label="Лазерное излучение"/>
                                    </#if>
                                </div>
                            </td>
                            <td>
                                <#if objective.aeroions>
                                    <@input.checkbox_form_on id="Aeroions" label="Аэроионы"/>
                                <#else>
                                    <@input.checkbox_form id="Aeroions" label="Аэроионы"/>
                                </#if>
                                <#if objective.ultrasound>
                                    <@input.checkbox_form_on id="Ultrasound" label="Ультразвук"/>
                                <#else>
                                    <@input.checkbox_form id="Ultrasound" label="Ультразвук"/>
                                </#if>
                                <#if objective.infrasound>
                                    <@input.checkbox_form_on id="Infrasound" label="Инфразвук"/>
                                <#else>
                                    <@input.checkbox_form id="Infrasound" label="Инфразвук"/>
                                </#if>
                                <#if objective.vch>
                                    <@input.checkbox_form_on id="VCH" label="ЭМП ВЧ"/>
                                <#else>
                                    <@input.checkbox_form id="VCH" label="ЭМП ВЧ"/>
                                </#if>
                            </td>
                            <td>
                                <div class="ml-4">
                                    <#if objective.vdt>
                                        <@input.checkbox_form_on id="VDT" label="ЭМП ВДТ"/>
                                    <#else>
                                        <@input.checkbox_form id="VDT" label="ЭМП ВДТ"/>
                                    </#if>
                                    <#if objective.svch>
                                        <@input.checkbox_form_on id="SVCH" label="ЭМП СВЧ"/>
                                    <#else>
                                        <@input.checkbox_form id="SVCH" label="ЭМП СВЧ"/>
                                    </#if>
                                    <#if objective.m50Hg>
                                        <@input.checkbox_form_on id="m50Hg" label="ЭМП 50гц"/>
                                    <#else>
                                        <@input.checkbox_form id="m50Hg" label="ЭМП 50гц"/>
                                    </#if>
                                    <#if objective.pmp>
                                        <@input.checkbox_form_on id="PMP" label="ПМП"/>
                                    <#else>
                                        <@input.checkbox_form id="PMP" label="ПМП"/>
                                    </#if>
                                </div>
                            </td>
                        </tr>


                        <#--**************ДОБАВИТЬ ВЫПОЛНЕНИЕ****************-->


                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="objectiveId" value="${objective.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary btn-lg btn-block btn-rounded">Изменить заявку</button>
                </td>
            </tr>
        </table>
    </form>

    <a href="delete/${objective.id}">
        <button type="submit" class="btn btn-danger btn-lg btn-block btn-rounded" style="width: 98%; margin: auto">
            Удалить
        </button>
    </a>


    <script>
        <#include "js/validation.js">
    </script>
</@c.body>