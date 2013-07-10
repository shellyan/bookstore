$(document).ready(function () {

    //attach a jQuery live event to the button
    $('#getdata-button').on('click', function () {

        //alert('hello');

        $.getJSON('http://localhost:8080/BookstoreServices.RS/bookstore/books/', function (data) {
            //$('#showdata').html(JSON.stringify(data));

            var output = "<ul>";
            for (var i in data) {
                $('#select').val(data[i].title);
                output += "<li>" + "Title: " + data[i].title
                    + "<br>Author: " + data[i].author
                    + "<br>ISBN: " + data[i].isbn
                + "<br>Price: " + data[i].price
                + "<br>Description: " + data[i].description

                                     + "<br> <a href= # onclick=doSubmit()> Pay:" + data[i].title + "</a>"

                   + "</li>";
            }
            output += "</ul>";
            document.getElementById("showdata").innerHTML = output;
        });
    });



    $('#on_submit').submit(function () {
        var book_name = $('#book_name').val();
        //doRequest($('#book_name').val());
        //alert(book_name);

        $.getJSON('http://localhost:8080/BookstoreServices.RS/bookstore/books/' + book_name, function (data) {
            //$('#showdata').html(JSON.stringify(data));
            $('#select').val(data.title);

            var output = "<ul>";

            output += "<li>" + "Title: " + data.title
                + "<br>Author: " + data.author
                + "<br>ISBN: " + data.isbn
            + "<br>Price: " + data.price
            + "<br>Description: " + data.description
             + "<br> <a href= # onclick=doSubmit()> Pay:" + data.title + "</a>"
               + "</li>";

            output += "</ul>";
            document.getElementById("showdata").innerHTML = output;
        });
        return false;
    });
    function createCookie(c_name, value, exdays) {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + exdays);
        var c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
        document.cookie = c_name + "=" + c_value;
    }






});