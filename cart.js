

$(document).ready(function () {
    //attach a jQuery live event to the button
    if (readCookie('usercookie') == 'true') {
        
        var HATEOAS = readCookie('HATEOAS');
        $('#lastname').val(readCookie('lastname'));
        $('#firstname').val( readCookie('firstname'));
        $('#card').val(readCookie('card'));
        $('#address').val( readCookie('address'));
        document.getElementById("showdata").innerHTML =readCookie('HATEOAS');


        $("#get_order").click(function () {
            alert("HATEOAS of the book you selected: " + HATEOAS);
        

        });

        $('#place_order').click(function () {

            var lastname = $('#lastname').val();
            var firstname = $('#firstname').val();
            var card = $('#card').val();
            var address = $('#address').val();

            var URL = 'http://localhost:8080/BookstoreServices.RS/bookstore/orders/' + HATEOAS + "/" + firstname + "+" + lastname + "+" + card + "+" + address;
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'type': 'POST',
                'dataType': 'json',
                url: URL,
                'success': function (data) {
                    $('#link').val(data.links);
                    $('#place_order').hide();
                    alert("Order placed. Your order ID is: " + data.id);

                    createCookie('order_id_link', data.links, 1);
                    document.location.href = 'pay.html';
                }
            });
        });





    } else {         $('#cart').hide();
        alert("You must log in to place an order!");}


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


        function createCookie(c_name, value, exdays) {
            var exdate = new Date();
            exdate.setDate(exdate.getDate() + exdays);
            var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
            document.cookie = c_name + "=" + c_value;
        }

    
});