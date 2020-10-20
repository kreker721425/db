<#import "macros/common.ftl" as c>

<@c.title>
    Измерения
</@c.title>

<@c.style>

</@c.style>

<@c.body>

<#--<dl class="row">
    <dt class="col-sm-3">Description lists</dt>
    <dd class="col-sm-9">A description list is perfect for defining terms.</dd>

    <dt class="col-sm-3">Euismod</dt>
    <dd class="col-sm-9">
        <p>Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.</p>
        <p>Donec id elit non mi porta gravida at eget metus.</p>
    </dd>

    <dt class="col-sm-3">Malesuada porta</dt>
    <dd class="col-sm-9">Etiam porta sem malesuada magna mollis euismod.</dd>

    <dt class="col-sm-3 text-truncate">Truncated term is truncated</dt>
    <dd class="col-sm-9">Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</dd>

    <dt class="col-sm-3">Nesting</dt>
    <dd class="col-sm-9">
        <dl class="row">
            <dt class="col-sm-4">Nested definition list</dt>
            <dd class="col-sm-8">Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc.</dd>
        </dl>
    </dd>
</dl>-->

    <div class="container">
        <div class="row">
            <div class="col">Рабочие места - количество :</div>
            <div class="col">${objective.workPlaces}</div>
            <div class="w-100"></div>
            <div class="col">Рабочие места - не соответствуют :</div>
            <div class="col">${objective.workPlacesNo}</div>
            <div class="w-100"></div>
            <div class="col">Измерения - количество :</div>
            <div class="col">${objective.measurement}</div>
            <div class="w-100"></div>
            <div class="col">Измерения - не соответствуют :</div>
            <div class="col">${objective.measurementNo}</div>

            <#if objective.oi>
                <#if objective.projectRTO>
                    <div class="w-100"></div>
                    <div class="col">Экспертиза проекта по РТО :</div>
                    <div class="col">${objective.expertiseProjectRTO}</div>
                </#if>

                <#if objective.commissioningRTO>
                    <div class="w-100"></div>
                    <div class="col">Экспертиза ввод в эксплуатацию по РТО :</div>
                    <div class="col">${objective.expertiseCommissioningRTO}</div>
                </#if>

                <#if objective.iff>
                    <div class="w-100"></div>
                    <div class="col">Экспертиза на условия работ с ИФФ :</div>
                    <div class="col">${objective.expertiseIFF}</div>
                </#if>

                <#if objective.researchResults>
                    <div class="w-100"></div>
                    <div class="col">Экспертиза по результатам проведенных исследований :</div>
                    <div class="col">${objective.expertiseResearchResults}</div>
                </#if>
            </#if>

            <#if objective.ilc>
                <#if objective.noise>
                    <div class="w-100"></div>
                    <div class="col">Шум :</div>
                    <div class="col">${objective.measurementsNoise}</div>
                </#if>

                <#if objective.vibration>
                    <div class="w-100"></div>
                    <div class="col">Вибрация :</div>
                    <div class="col">${objective.measurementsVibration}</div>
                </#if>

                <#if objective.microclimate>
                    <div class="w-100"></div>
                    <div class="col">Микроклимат :</div>
                    <div class="col">${objective.measurementsMicroclimate}</div>
                </#if>

                <#if objective.illumination>
                    <div class="w-100"></div>
                    <div class="col">Освещенность :</div>
                    <div class="col">${objective.measurementsIllumination}</div>
                </#if>

                <#if objective.laserRadiation>
                    <div class="w-100"></div>
                    <div class="col">Лазерное излучение :</div>
                    <div class="col">${objective.measurementsLaserRadiation}</div>
                </#if>

                <#if objective.aeroions>
                    <div class="w-100"></div>
                    <div class="col">Аэроионы :</div>
                    <div class="col">${objective.measurementsAeroions}</div>
                </#if>

                <#if objective.ultrasound>
                    <div class="w-100"></div>
                    <div class="col">Ультразвук :</div>
                    <div class="col">${objective.measurementsUltrasound}</div>
                </#if>

                <#if objective.infrasound>
                    <div class="w-100"></div>
                    <div class="col">Инфразвук :</div>
                    <div class="col">${objective.measurementsInfrasound}</div>
                </#if>

                <#if objective.vch>
                    <div class="w-100"></div>
                    <div class="col">ЭМП ВЧ :</div>
                    <div class="col">${objective.measurementsVCH}</div>
                </#if>

                <#if objective.vdt>
                    <div class="w-100"></div>
                    <div class="col">ЭМП ВДТ :</div>
                    <div class="col">${objective.measurementsVDT}</div>
                </#if>

                <#if objective.svch>
                    <div class="w-100"></div>
                    <div class="col">ЭМП СВЧ :</div>
                    <div class="col">${objective.measurementsSVCH}</div>
                </#if>

                <#if objective.m50Hg>
                    <div class="w-100"></div>
                    <div class="col">ЭМП 50гц :</div>
                    <div class="col">${objective.measurements50Hg}</div>
                </#if>

                <#if objective.pmp>
                    <div class="w-100"></div>
                    <div class="col">ПМП :</div>
                    <div class="col">${objective.measurementsPMP}</div>
                </#if>
            </#if>

            <#if objective.fileMeasure??>
                <div class="w-100"></div>
                <div class="col">Файл выполнения :</div>
                <div class="col">
                    <a href="/download_measure_file/${objective.fileMeasure}">
                        <button type="button" class="btn btn-outline-primary">Скачать</button>
                    </a>
                </div>
            </#if>


        </div>
    </div>

</@c.body>