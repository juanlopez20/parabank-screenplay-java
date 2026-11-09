# Matriz ampliada CP-01 a CP-17 y alcance de automatización

**Importante:** este listado es diseño y planificación, no resultados. Las capturas de formularios previas no equivalen a un PASS automatizado. La clasificación de estados debe hacerse después de ejecutar el escenario en Windows.

| Caso | Función | Estado del script incluido | Etiqueta |
|---|---|---|---|
| CP-01 | Register con datos ficticios | Programado, requiere permiso de escritura y validación | `@CP01` |
| CP-02 | Login válido | Programado, requiere credenciales ficticias | `@CP02` |
| CP-03 | Login inválido | Programado, ejecución segura de lectura | `@CP03` |
| CP-04 | Open New Account | Aún no automatizado | — |
| CP-05 | Accounts Overview | Programado, requiere credenciales ficticias | `@CP05` |
| CP-06 | Transfer Funds | Programado solo hasta confirmación; conciliación final manual | `@CP06` |
| CP-07 | Bill Pay | Aún no automatizado | — |
| CP-08 | Administration sin login | Programado, solo lectura; fallo esperado si reproduce hallazgo | `@CP08` |
| CP-09 | Find Transactions | Aún no automatizado | — |
| CP-10 | Request Loan | Aún no automatizado | — |
| CP-11 | Update Contact Info | Aún no automatizado | — |
| CP-12 | Log Out | Programado | `@CP12` |
| CP-13 | Forgot Login Info | Aún no automatizado | — |
| CP-14 | Register campos vacíos | Aún no automatizado | — |
| CP-15 | Register usuario duplicado | Aún no automatizado | — |
| CP-16 | Repetición Login/Logout | Aún no automatizado | — |
| CP-17 | Adaptación de interfaz | Aún no automatizado | — |

Escenario adicional `@CP00`: humo de interfaz pública, no constituye parte de CP-01…CP-17.

**Estado ejecutado:** todos PENDIENTE hasta correr Gradle en el equipo del estudiante. Para cerrar CP-06 se debe cotejar saldo inicial, saldo final y transacción registrada; una confirmación visual automatizada no es suficiente.
