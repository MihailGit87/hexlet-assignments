@import exercise.dto.posts.PostPage
@param PostPage page
@template.layout.page(
content = @`
    <main>
        <div><h1>${page.getPost().getName()}</h1></div>
        <div><h1>${page.getPost().getBody()}</h1></div>
    </main>
`
)