<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
<h2 class="container-sm">Создание нового пользователя</h2>
<form action="/users" method="post" class="container-sm">
    <div>
        <div class="mb-3">
            <label for="firstName" class="form-label">First name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Ваше имя">
        </div>
    </div>
    <div>
        <div class="mb-3">
            <label for="lastName" class="form-label">Last name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Ваша фамилия">
        </div>
    </div>
    <div>
        <div class="mb-3">
            <label for="firstName" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
        </div>
    </div>
    <div>
        <div class="mb-3">
            <label for="firstName" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Создать</button>
</form>
</body>
</html>
