@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if (page.getName() != null)
        <h1 class="mb-3"> Добро пожаловать, ${page.getName().toString()}</h1>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <h1 class="mb-3"> Добро пожаловать, гость</h1>
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти">
        </form>
    @endif
`
)