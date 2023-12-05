@import exercise.dto.users.UserPage
@import exercise.model.User
@param UserPage page

<main>
    <h1>${page.getUser().getFirstName() + ", " + page.getUser().getLastName()}</h1>
    <%--<p>${page.getUser().getLastName()}</p>--%>
    <%--<p>${page.getUser().toString()}</p>--%>

</main>
