<#import "macros/common.ftl" as c>
<#import "macros/input_form.ftl" as input>

<@c.title>
    Выполнить задачу
</@c.title>

<@c.style>

</@c.style>

<@c.body>


    <form class="needs-validation" novalidate method="post" action="/execute_objective/" enctype="multipart/form-data">
        <table style="width: 50%" class="mt-2 mx-auto text-center">
            <tr>
                <td class="table-primary w-50">
                    <h5>Рабочие места</h5>
                </td>
                <td class="table-primary w-50">
                    <h5>Измерения</h5>
                </td>
            </tr>
            <tr>
                <td class="text-center">
                    <div class="form-row">
                        <div class="col-md-5 mb-1 ml-4">
                            <@input.input id="workPlaces" type="number" label="Количество" value=""/>
                        </div>
                        <div class="col-md-5 mb-1">
                            <@input.input id="workPlacesNo" type="number" label="Не соответствуют" value=""/>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="form-row">
                        <div class="col-md-5 mb-1 ml-4">
                            <@input.input id="measurement" type="number" label="Количество" value=""/>
                        </div>
                        <div class="col-md-5 mb-1 ">
                            <@input.input id="measurementNo" type="number" label="Не соответствуют" value=""/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="table-primary w-50">
                    <h5>ОИ</h5>
                </td>
                <td class="table-primary w-50">
                    <h5>ИЛЦ</h5>
                </td>
            </tr>
            <tr>
                <td>
                    <#if objective.oi>
                        <div class="form-row">
                            <#if objective.projectRTO>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="expertiseProjectRTO" type="number" label="Экспертиза проекта по РТО" value=""/>
                                </div>
                            </#if>
                            <#if objective.commissioningRTO>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="expertiseCommissioningRTO" type="number" label="Экспертиза ввод в эксплуатацию по РТО" value=""/>
                                </div>
                            </#if>
                            <#if objective.iff>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="expertiseIFF" type="number" label="Экспертиза на условия работ с ИФФ" value=""/>
                                </div>
                            </#if>
                            <#if objective.researchResults>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="expertiseResearchResults" type="number" label="Экспертиза по результатам проведенных исследований" value=""/>
                                </div>
                            </#if>
                        </div>
                    </#if>
                </td>
                <td>
                    <#if objective.ilc>
                        <div class="form-row">
                            <#if objective.noise>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsNoise" type="number" label="Шум" value=""/>
                                </div>
                            </#if>
                            <#if objective.vibration>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsVibration" type="number" label="Вибрация" value=""/>
                                </div>
                            </#if>
                            <#if objective.microclimate>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsMicroclimate" type="number" label="Микроклимат" value=""/>
                                </div>
                            </#if>
                            <#if objective.illumination>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsIllumination" type="number" label="Освещенность" value=""/>
                                </div>
                            </#if>
                            <#if objective.laserRadiation>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsLaserRadiation" type="number" label="Лазерное излучение" value=""/>
                                </div>
                            </#if>
                            <#if objective.aeroions>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsAeroions" type="number" label="Аэроионы" value=""/>
                                </div>
                            </#if>
                            <#if objective.ultrasound>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsUltrasound" type="number" label="Ультразвук" value=""/>
                                </div>
                            </#if>
                            <#if objective.infrasound>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsInfrasound" type="number" label="Инфразвук" value=""/>
                                </div>
                            </#if>
                            <#if objective.vch>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsVCH" type="number" label="ЭМП ВЧ" value=""/>
                                </div>
                            </#if>
                            <#if objective.vdt>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsVCH" type="number" label="ЭМП ВЧ" value=""/>
                                </div>
                            </#if>
                            <#if objective.svch>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsSVCH" type="number" label="ЭМП СВЧ" value=""/>
                                </div>
                            </#if>
                            <#if objective.m50Hg>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurements50Hg" type="number" label="ЭМП 50гц" value=""/>
                                </div>
                            </#if>
                            <#if objective.pmp>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurementsPMP" type="number" label="ПМП" value=""/>
                                </div>
                            </#if>
                            <#if objective.m50Hg>
                                <div class="col-md-10 mb-1 mx-auto">
                                    <@input.input id="measurements50Hg" type="number" label="ЭМП 50гц" value=""/>
                                </div>
                            </#if>
                        </div>
                    </#if>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="table-primary">
                    <h5>Файл измерений</h5>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="form-group">
                        <div class="col-md-auto mb-1 mx-auto">
                            <@input.file id="file" label=""/>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="form-group">
                        <input type="hidden" name="objectiveId" value="${objective.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary btn-lg btn-block btn-rounded">Выполнить</button>
                    </div>
                </td>
            </tr>
        </table><#--
        <div class="form-group">
            <@input.file id="file" label="Файл измерений"/>
        </div>
        <div class="form-group">
            <input type="hidden" name="objectiveId" value="${objective.id}">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary btn-lg btn-block btn-rounded">Выполнить</button>
        </div>-->
    </form>

    <script>
        <#include "js/validation.js">
    </script>

</@c.body>