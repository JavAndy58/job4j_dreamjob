# Работа мечты

<h2><a name="about">О проекте</a>&nbsp;&nbsp;<a href="#menu"></a></h2>
<h4><a name="description">Описание</a>&nbsp;&nbsp;<a href="#menu"></a></h4>
<p>
    Проект для изучения Java EE.
</p>
<p>
    Это приложение - биржа работы.<br>
    В системе будут два типа пользователей: кандидаты и менеджеры. Кандидаты будут публиковать резюме. Менеджеры будут публиковать вакансии о работе.<br>
    Кандидаты могут откликнуться на вакансию. Менеджер может пригласить на вакансию кандидата.
</p>
<h4><a name="technologies">Технологии</a>&nbsp;&nbsp;<a href="#menu"></a></h4>
<ul>
    <li>Java 14</li>
    <li>Java EE Servlets, JSP, JSTL</li>
    <li>PostgreSQL, JDBC, Liquibase</li>
    <li>JUnit, Mockito, PowerMock</li>
    <li>Maven, Tomcat</li>
    <li>HTML, JavaScript, jQuery, JSON</li>
    <li><a href="https://materializecss.com">Material Design library</a></li>
</ul>

<h2><a name="build">Сборка</a>&nbsp;&nbsp;<a href="#menu"></a></h2>
<ol>
    <li>
        Для успешной сборки и работы проекта на вашем компьютере должны быть установлены:
        <ol>
            <li>JDK 14(+)</li>
            <li>Maven</li>
            <li>PostgreSQL</li>
            <li>Tomcat</li>
        </ol>
    </li>
    <li>
        В PostgreSQL создайте базу с именем "dream_job"
    </li>
    <li>
        Скачайте проект к себе на компьютер с помощью команды<br>
        <code>git clone https://github.com/ReyBos/job4j_dreamjob.git</code><br>
        перейдите в корень проекта
    </li>
    <li>
        Добавьте настройки для доступа к базе данных, для этого внесите соответствующие изменения в файле 
        <code>src/main/resources/db.properties</code><br>
        и в файле конфигурации проекта <code>pom.xml</code>
    
``` 
<profile>   
    <id>production</id>
    <properties>
        <db.url>jdbc:postgresql://127.0.0.1:5432/dream_job</db.url>
        <db.username>postgres</db.username>
        <db.password>password</db.password>
        <db.driver>org.postgresql.Driver</db.driver>
    </properties>
</profile>
```
</li>
    <li>
        Выполните команду <code>mvn install -Pproduction</code> в корне проекта для его сборки<br>
        Будет выполнена миграция БД с помощью Liquibase.<br>
        В случае успешной сборки появится файл <code>target/job4j_dreamjob-1.0.war</code><br>
        переименуйте его в <code>dreamjob.war</code>
    </li>
    <li>
        Для запуска веб-приложения вам нужно скопировать <code>dreamjob.war</code> в папку <code>webapps</code> вашего Tomcat
    </li>
    <li>
        После запуска сервера приложение будет доступно по адресу<br>
        <a href="http://localhost:8080/dreamjob/">http://localhost:8080/dreamjob/</a>
    </li>
</ol>

