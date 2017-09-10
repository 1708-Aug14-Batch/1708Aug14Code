
$(document).ready(function() {
    "use strict";
    $('#accountsTable').DataTable({
        bSort : true
    });
    loadDashboardView();
});


// Views

function getUserInformation() {
    "use strict";
    console.log("In getUserInformation");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responseText);

            var dto = JSON.parse(xhr.responseText);
            var user = dto.user;
            console.log(user);
            var accounts = dto.accounts;

            $('span#name').text(user.firstName + " " + user.lastName);
            
            $.each(dto.accounts, function() {
                $('tbody#accounts').append(
                    '<tr>' +
                    '<td>' + this.id + '</td>' +
                    '<td class="text-right">' + this.balance + '</td>' +
                    '<td>' + this.type + '</td>' +
                    '</tr>');
            });
        }
    };

    xhr.open("GET", "getUserInfo", true);
    xhr.send();
}

function loadDashboardView() {
    "use strict";
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log("in set view");
            $('#view').html(xhr.responseText);
            getUserInformation();
        }
    };

    xhr.open("GET", "getDashboard", true);
    xhr.send();
}
