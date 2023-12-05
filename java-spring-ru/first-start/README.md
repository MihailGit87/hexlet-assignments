# Знакомство со Spring Boot

## Ссылки

* [Начало работы со Spring Boot](https://spring.io/quickstart)

## build.gradle.kts

* Добавьте в файл *build.gradle.kts* необходимые для работы приложения плагины и зависимости

## src/main/java/exercise/Application.java

## Задачи

* В файле создайте класс `Application` и реализуйте в нем Spring Boot приложение, в котором по адресу */about* отдается строчка текста *Welcome to Hexlet!*

* Запустите приложение при помощи команды *./gradlew bootRun*, откройте браузер и убедитесь, что по адресу *http://localhost:8080/about* отдается нужный текст

* Проверьте, как происходит автоматический рестарт приложения при изменении кода. Добавьте к выводу еще какой-нибудь текст и обновите страницу браузера

### Подсказки

* В зависимости от вашей IDE, для работы автоматического рестарта могут потребоваться [дополнительные действия](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools.restart)
