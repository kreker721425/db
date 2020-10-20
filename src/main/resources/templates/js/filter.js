function tableFilter() {
    let table = document.getElementById('table');
    const regPhrase = new RegExp(document.getElementById('input').value, 'i');
    let flag = false;
    for (let i = 2; i < table.rows.length; i++) {
        flag = false;
        for (let j = table.rows[i].cells.length - 1; j >= 0; j--) {
            flag = regPhrase.test(table.rows[i].cells[j].innerHTML);
            if (flag) break;
        }
        if (flag) {
            table.rows[i].style.display = "";
        } else {
            table.rows[i].style.display = "none";
        }
    }
}