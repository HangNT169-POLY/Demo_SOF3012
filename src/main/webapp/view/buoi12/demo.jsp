<!DOCTYPE html>
<html>
<head>
    <title>AJAX Example with Object (User)</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function makeRequest() {
            $.ajax({
                url: '/api/greet',  // URL c?a Servlet
                type: 'GET',
                dataType: 'json',  // Ki?u d? li?u tr? v? là JSON
                success: function(response) {
                    // L?y ??i t??ng user t? response JSON
                    var user = response;

                    // Hi?n th? thông tin c?a ??i t??ng user lên trang
                    document.getElementById('result').innerHTML =
                        'Name: ' + user.name + '<br>' + 'Age: ' + user.age;
                    console.log(response)
                },
                error: function(xhr, status, error) {
                    // X? lý l?i
                    document.getElementById('result').innerHTML = "An error occurred: " + error;
                }
            });
        }
    </script>
</head>
<body>
<h1>AJAX with JSP and Servlet (User Object)</h1>
<button onclick="makeRequest()">Get User Data from Servlet</button>
<div id="result"></div>
</body>
</html>
