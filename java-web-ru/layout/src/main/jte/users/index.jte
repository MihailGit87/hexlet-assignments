@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
title = "Users",
content = @`
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : page.getUsers())
                <tr>
                    <th scope="row">${user.getId()}</th>
                    <td><a href="/users/${user.getId()}" class="text-reset">${user.getFirstName()} ${user.getLastName()}</a></td>
                    <td><a href="/users/${user.getId()}" class="text-reset">${user.getEmail()}</a></td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>
`
)
