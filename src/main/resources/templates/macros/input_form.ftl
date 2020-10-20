<#macro input id type label value>
    <label for="${id}">${label}</label>
    <input class="form-control" id="${id}" type="${type}" name="${id}" placeholder="${label}" value="${value}"
           required/>
    <div class="invalid-feedback">
        Обязательное поле
    </div>
</#macro>

<#macro file id label>
    <label for="${id}">${label}</label>
    <div class="custom-file">
        <input type="file" class="custom-file-input" value="" id="${id}" name="${id}" required>
        <label class="custom-file-label" for="${id}">${label}</label>
        <div class="invalid-feedback">
            Обязательное поле
        </div>
    </div>
</#macro>

<#macro select_edit id label value>
    <label for="${id}">${label}</label>
    <div class="form-group">
        <select id="${id}" class="form-control" name="${id}" required>
            <option selected value="${value}">${value}</option>
            <#nested>
        </select>
        <div class="invalid-feedback">
            Выберите вариант ответа
        </div>
    </div>
</#macro>

<#macro select id label>
    <label for="${id}">${label}</label>
    <div class="form-group">
        <select id="${id}" class="form-control" name="${id}" required>
            <option selected disabled value="">Выберите</option>
            <#nested>
        </select>
        <div class="invalid-feedback">
            Выберите вариант ответа
        </div>
    </div>
</#macro>

<#macro checkbox_form id label>
    <div class="custom-control custom-switch ml-1 mb-1">
        <input type="checkbox" class="custom-control-input" id="${id}" name="${id}">
        <label class="custom-control-label" for="${id}">${label}</label>
    </div>
</#macro>

<#macro checkbox_form_on id label>
    <div class="custom-control custom-switch ml-1 mb-1">
        <input type="checkbox" class="custom-control-input" id="${id}" name="${id}" checked>
        <label class="custom-control-label" for="${id}">${label}</label>
    </div>
</#macro>