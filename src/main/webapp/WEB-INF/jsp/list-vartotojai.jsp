<%@ include file="common/header.jspf"%>

<div class="container">
    <H1>List of Vartotojai:</H1>

    <!--
<p>${vartotojai}</p>
-->

    <table border="1">
        <thead>
        <tr>
            <th>Id</th><th>Vardas</th><th>Pavarde</th><th>TelefonoNumeris</th><th>Email</th><th>Adresas</th><th>Slaptazodis</th><th>Update</th><th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vartotojai}" var="vr">
            <tr>
                <td>${vr.id}</td>
                <td>${vr.vardas}</td>
                <td>${vr.pavarde}</td>
                <td>${vr.telefonoNumeris}</td>
                <td>${vr.email}</td>
                <td>${vr.adresas}</td>
                <td>${vr.slaptazodis}</td>
                <td><a type="button" href="/update-vartotojas/${vr.id}">UPDATE</a></td>
                <td><a type="button" href="/delete-vartotojas/${vr.id}">DELETE</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>
        <a href="add-vartotojas">ADD Vartotojas</a>
    </div>
</div>