function loadAuthors() {
    $.get("/api/author/list", function (data, status) {
        console.log(status, data);
        for (let author in data) {
            let $tr = $('<tr>').append(
                $('<td>').text(data[author].firstName),
                $('<td>').text(data[author].infixName),
                $('<td>').text(data[author].lastName),
                $('<td>')
            );
            $('#author-table').append($tr);
        }
    });
}

window.onload = loadAuthors;