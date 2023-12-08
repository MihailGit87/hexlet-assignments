@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<div class="container-sm">
    <form action="/users" method="get">
        <div class="mb-3">
            <label for="term" class="form-label">First Name</label>
            <input type="search" class="form-control" name="term" value="${page.getTerm()}">
            <div id="inputHelp" class="form-text">Please, enter username for filtering.</div>
        </div>
    </form>
</div>
<div>
    <table class="table table-striped container-sm">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
        </tr>
        </thead>
        <tbody>
        @for (User user : page.getUsers())
            <tr>
                <th scope="row">${user.getId()}</th>
                <td>${user.getFirstName()} ${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
            </tr>
        @endfor
        </tbody>
    </table>
</div>
</body>
</html>
