@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Хекслет пользователи</title>
</head>
<body>
<h1>Список пользователей</h1>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(var user : page.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getId() + " " + user.getFirstName() + " " + user.getLastName()}</a></h2>

        </div>
    @endfor
@endif
</body>
</html>
