

$(document).ready(function () {
    //attach a jQuery live event to the button

    var HATEOAS = readCookie('HATEOAS');
    var firstname = readCookie('firstname');
    var lastname = readCookie('lastname');
    var card = readCookie('card');
    var address = readCookie('address');
    var order_id_link = readCookie('order_id_link');

    //alert(order_id_link);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        'type': 'GET',
        'dataType': 'json',
        url: order_id_link,
        'success': function (data) {
            var output = "<ul>";
            output += "<li>" + "ID: " + data.id
                + "<br>Status: " + data.orderState
                + "<br>Firstname: " + data.firstName
            + "<br>Lastname: " + data.lastName
            + "<br>Credit Card: " + data.card
            + "<br>Address: " + data.address
            + "<br> Book:" + data.book.title

               + "</li>";
            output += "</ul>";
            document.getElementById("showdata").innerHTML = output;

        }
    });


    $("#make_payment").click(function () {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'GET',
            'dataType': 'json',
            url: order_id_link+"+"+"pay",
            'success': function (data) {
                alert("Paid successfully!");
                $('#cancel_order').hide();
                $('#make_payment').hide();

                var output = "<ul>";
                output += "<li>" + "ID: " + data.id
                    + "<br>Status: " + data.orderState
                    + "<br>Firstname: " + data.firstName
                + "<br>Lastname: " + data.lastName
                + "<br>Credit Card: " + data.card
                + "<br>Address: " + data.address
                + "<br> Book:" + data.book.title

                   + "</li>";
                output += "</ul>";
                document.getElementById("showdata").innerHTML = output;

            }
        });

    });
    $('#cancel_order').click(function () {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'DELETE',
            'dataType': 'json',
            url: order_id_link ,
            'success': function (data) {
                alert("Canceld successfully!");
                $('#cancel_order').hide();
                $('#make_payment').hide();
    
                var output = "<ul>";
                output += "<li>" + "ID: " + data.id
                    + "<br>Status: " + data.orderState
                    + "<br>Firstname: " + data.firstName
                + "<br>Lastname: " + data.lastName
                + "<br>Credit Card: " + data.card
                + "<br>Address: " + data.address
                + "<br> Book:" + data.book.title

                   + "</li>";
                output += "</ul>";
                document.getElementById("showdata").innerHTML = output;

            }
        });


    });
    $('#place_order').click(function () {
        
    });




    function readCookie(c_name) {
        var c_value = document.cookie;
        var c_start = c_value.indexOf(" " + c_name + "=");
        if (c_start == -1) {
            c_start = c_value.indexOf(c_name + "=");
        }
        if (c_start == -1) {
            c_value = null;
        }
        else {
            c_start = c_value.indexOf("=", c_start) + 1;
            var c_end = c_value.indexOf(";", c_start);
            if (c_end == -1) {
                c_end = c_value.length;
            }
            c_value = unescape(c_value.substring(c_start, c_end));
        }
        return c_value;
    }

});