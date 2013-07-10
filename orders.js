$(document).ready(function () {
    //attach a jQuery live event to the button

    $('#on_submit').submit(function () {
        var id = $('#order_id').val();


        $.getJSON('http://localhost:8080/BookstoreServices.RS/bookstore/orders/' + id, function (data) {
            //$('#showdata').html(JSON.stringify(data));
            var output = "<ul>";
        
                output += "<li>" + "ID: " + data.id
                    + "<br>Status: " + data.orderState
                    + "<br>Firstname: " + data.firstName
                + "<br>Lastname: " + data.lastName
                + "<br>Credit Card: " + data.card
                                    + "<br>Address: " + data.address
 + "<br> Book:" + "<a href=" + data.links + ">" + data.book.title + "</a>"


                   + "</li>";
            
            output += "</ul>";
            document.getElementById("showdata").innerHTML = output;
        });
        return false;

    });

    $('#getdata-button').on('click', function () {
        if (readCookie('usercookie')=='true')
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: 'POST',

                contentType: "application/json; charset=utf-8",
                dataType: 'JSON',
                url: 'http://localhost:8080/BookstoreServices.RS/bookstore/orders/' + 'test',

                success: function (data) {
                    var output = "<ul>";
                    for (var i in data) {
                        output += "<li>" + "ID: " + data[i].id
                            + "<br>Status: " + data[i].orderState
                            + "<br>Firstname: " + data[i].firstName
                        + "<br>Lastname: " + data[i].lastName
                        + "<br>Credit Card: " + data[i].card
                                            + "<br>Address: " + data[i].address
 + "<br> Book:" + "<a href="+data[i].links+">" + data[i].book.title + "</a>"
                           + "</li>";
                    }
                    output += "</ul>";
                    document.getElementById("showdata").innerHTML = output;
                },

            }
            );
        else alert("You must login to see your orders" + readCookie('usercookie'));


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