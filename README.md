# ParaBank - Automatización Java + Selenium + Serenity Screenplay

**Proyecto académico de pruebas de caja negra sobre ParaBank.** No es código fuente de ParaBank. El ZIP no ha sido compilado ni ejecutado en un navegador en este entorno: debes ejecutarlo y verificar localizadores en tu equipo.

## Archivos

- `build.gradle`: dependencias Gradle y tareas de test.
- `serenity.properties`: URL, Chrome y capturas (AFTER_EACH_STEP).
- `src/test/resources/junit-platform.properties`: plugin SerenityReporterParallel para informe.
- `src/test/resources/features`: Gherkin y etiquetas.
- `src/test/java/.../runners`: ejecutor JUnit Platform.
- `src/test/java/.../stepdefinitions`: pasos Cucumber.
- `src/test/java/.../tasks`: tareas Screenplay.
- `src/test/java/.../ui`: localizadores del HTML.
- `src/test/java/.../questions`: verificaciones.
- `docs/matriz_casos.md`: alcance y estado previsto.

## Requisitos Windows

JDK 17, Chrome, IntelliJ IDEA, Git y Gradle 9.2.1 (o versión compatible). **Este ZIP no incluye `gradlew.bat`, por eso se utiliza `gradle` instalado.** La primera ejecución necesita Internet para resolver dependencias y ChromeDriver.

Verificar desde Terminal:

```powershell
java -version
javac -version
gradle -v
git --version
```

## Ejecutar paso a paso

Primero, desde la carpeta que contiene `build.gradle`:

```powershell
gradle clean test aggregate "-Dcucumber.filter.tags=@smoke"
```

Este grupo ejecuta CP00 (humo de página) y CP03 (login incorrecto). Son las primeras pruebas recomendadas.

Para usar una cuenta **ficticia** creada manualmente:

```powershell
$env:PARABANK_USER="TU_USUARIO_FICTICIO"
$env:PARABANK_PASSWORD="TU_CLAVE_DE_PRUEBAS"
gradle clean test aggregate "-Dcucumber.filter.tags=@autenticado"
Remove-Item Env:PARABANK_USER
Remove-Item Env:PARABANK_PASSWORD
```

Casos cubiertos en `@autenticado`: CP02, CP05, CP12.

Revisión de Administration sin ejecutar operaciones administrativas:

```powershell
gradle clean test aggregate "-Dcucumber.filter.tags=@hallazgo"
```

Este caso **puede fallar** si la interfaz está visible sin credenciales. Una prueba roja puede expresar el hallazgo H-01, pero debes distinguirlo de errores de selector/automatización.

Registro ficticio (escritura, solo cuando se decida crear datos nuevos):

```powershell
gradle clean test aggregate "-Dcucumber.filter.tags=@CP01" "-Dparabank.permitir.escritura=true"
```

Transferencia entre cuentas ficticias (ESCRITURA). Antes modifica `03_transferencia.feature` reemplazando `CUENTA_ORIGEN` y `CUENTA_DESTINO` por dos cuentas distintas del usuario de prueba; verifica saldo suficiente y guarda evidencia previa. Luego:

```powershell
$env:PARABANK_USER="TU_USUARIO_FICTICIO"
$env:PARABANK_PASSWORD="TU_CLAVE_DE_PRUEBAS"
gradle clean test aggregate "-Dcucumber.filter.tags=@CP06" "-Dparabank.permitir.escritura=true"
Remove-Item Env:PARABANK_USER
Remove-Item Env:PARABANK_PASSWORD
```

CP06 solo confirma pantalla de transferencia en el script actual: revisar saldos anteriores y posteriores, y Find Transactions manualmente antes de cerrar el caso como PASS.

## Informes

Serenity normalmente genera `target/site/serenity/index.html`. Si no está, buscar:

```powershell
Get-ChildItem -Recurse -Filter index.html | Where-Object { $_.FullName -match "serenity" }
```

Guardar captura del resumen (PASS/FAIL), detalle de cada escenario y errores. Los resultados no son PASS hasta ejecutar realmente.

## Publicar en GitHub (solo después de probar)

Crear repositorio vacío en GitHub y ejecutar en PowerShell desde la raíz del proyecto:

```powershell
git init
git add .
git commit -m "Iniciar automatizacion ParaBank con Screenplay"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/parabank-screenplay-java.git
git push -u origin main
```

No publicar credenciales, cookies, `.env`, `build/`, `target/`, capturas con datos personales ni cuentas reales. El archivo `.gitignore` excluye resultados generados.

Más pasos y plantillas están en el Word `Guia_Solo_Automatizacion_ParaBank_Screenplay.docx`, entregado junto con este ZIP.
