@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
title = "User",
content = @`
    <div class="container-fluid border-bottom text-center">
        <h3>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h3>
    </div>
    <div class="container-fluid text-center">
        <ul class="list-group list-group-flush">
            <li class="list-group-item">${page.getUser().getEmail()}</li>
        </ul>
    </div>
`
)
