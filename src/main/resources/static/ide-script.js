let page = 1;
$(document).ready(function () {
    $('#create-form').submit(function (event) {
        let id = $('#create-id').val();
        let code = $('#create-code').val();
        let date = $('#create-date').val();
        let version = {
            "id": $('#create-version').val()
        }
        let newIde = {
            "id": id, "code": code, "date": date, "version": version
        }
        console.log(newIde);
        $.ajax({
            headers: {
                'Accept': 'application/json', 'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newIde),
            url: "/ide/create",
            success: function (ides) {
                $('#ide-table').html("<tr>\n" +
                    "        <th>ID</th>\n" +
                    "        <th>Code</th>\n" +
                    "        <th>Date</th>\n" +
                    "        <th>Version</th>\n" +
                    "    </tr>");
                appendRow(ides);
            }
        })
        event.preventDefault();
    })
    $('#more-ide').click(function (event) {
        $.ajax({
            headers: {
                'Accept': 'application/json', "Content-Type": 'application/json'
            },
            type: "GET",
            url: "/ide/more?page=" + page,
            success: function (ides) {
                page += 1;
                console.log(ides);
                appendRow(ides);
            }
        })
        event.preventDefault();
    })
})

function appendRow(ides) {
    jQuery.each(ides, function (index, ide) {
        let row = "<tr>";
        row += "<td>" + ide.id + "</td>";
        row += "<td>" + ide.code + "</td>";
        row += "<td>" + ide.date + "</td>";
        row += "<td>" + ide.version.name + "</td>";
        row += "</tr>";
        $('#ide-table').append(row);
    })
}