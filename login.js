

$(document).ready(function () {

    //attach a jQuery live event to the button
    if (readCookie('usercookie') == 'true') {
        $('#login_panel').hide();
        $('#loged_in').text('Welcome, Mr. Test!');
    }

    $("#logout").click(function () {
        alert("You are logged out! ["+createCookie('usercookie', 'true', -1)+"]");
        $('#login_panel').show();
        $('#loged_in').text('');
    });

    $("#cookie").click(function () {
        alert(readCookie('usercookie'));
    });
    $('#on_login').submit(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        //$('#showdata').html("hello" + password);
        
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'dataType': 'json',
            'url': 'http://localhost:8080/BookstoreServices.RS/bookstore/' + username + '+' + password,
      
            'complete': function (jqXHR) {
                if (jqXHR.status == '202') {
                    alert('Succeed.');
                    $('#login_panel').hide();
                    $('#loged_in').text('Welcome, Mr. Test!');
                    createCookie('usercookie', 'true', 1);
                    createCookie('firstname', 'test', 1);
                    createCookie('lastname', 'yan', 1);
                    createCookie('address', '123 w rosemont', 1);
                    createCookie('card', '7777777', 1);


                } else alert('Error.');
            },
        }
        );
        
        $("#login-link").click(function () {
            $("#login-panel").slideToggle(200);
        });
        
        return false;
    });

   

    function createCookie(c_name, value, exdays) {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + exdays);
        var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
        document.cookie = c_name + "=" + c_value;
    }

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