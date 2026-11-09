# Ejecución manual paso a paso - evidencia para el avance

## CP-01 Registro
1. Abrir ventana privada y `Register`.
2. Anotar fecha, navegador y URL.
3. Llenar únicamente datos ficticios (no datos personales reales), username irrepetible.
4. Capturar datos de entrada sin contraseña visible.
5. Registrar mensaje y acceso posteriores. Si se muestra error, guardar texto exacto y captura.
6. Clasificar PASS/FAIL y asociar H-XX si corresponde.

## CP-02 y CP-03 Inicio de sesión
1. Registrar usuario ficticio manual (solo una vez).
2. Abrir `index.htm`; ingresar credenciales válidas; capturar Accounts Overview.
3. Cerrar sesión; ingresar usuario inexistente y clave incorrecta; capturar error.
4. Guardar CP-02 y CP-03 con resultados reales diferenciados.

## CP-06 Transfer Funds (prioritario)
1. Ingresar a cuenta ficticia; abrir dos cuentas de prueba (si es necesario) y anotar IDs.
2. Accounts Overview: captura de origen/destino y saldos **antes** (EV-TF-01).
3. Transfer Funds: introducir `1`, origen y destino distintos, captura **antes de confirmar** (EV-TF-02).
4. Pulsar Transfer una sola vez; capturar confirmación/errores (EV-TF-03).
5. Accounts Overview: verificar saldos **después**, captura (EV-TF-04).
6. Find Transactions: buscar movimiento por importe o fecha, captura (EV-TF-05).
7. Registrar resultado esperado, obtenido, status; no marcar PASS si faltó conciliación.

## CP-08 Hallazgo Administration, solo observación
1. Abrir incógnito sin credenciales y capturar el login (E-01).
2. Navegar a Admin Page / admin.htm sin usar botones; capturar título (E-02).
3. Capturar controles visibles sin interactuar (E-03).
4. F12 → Network → recargar → seleccionar admin.htm → Request Method/Status → captura (E-04).
5. Registrar que GET 200 es entrega de recurso, **no demuestra que se puedan ejecutar operaciones**.
6. No pulsar Initialize, Clean, Shutdown, Submit ni modificar configuraciones.

## CP-16 Rendimiento
1. Chrome F12 → Network → Disable cache opcional, mantener misma configuración.
2. Medir en 3 repeticiones aisladas la misma navegación (inicio/login/Accounts Overview).
3. Copiar Duration/Timing y anotar fecha, navegador, red, conexión y cache.
4. Calcular promedio; no etiquetar falla sin definir un criterio de aceptación previamente.

## CP-17 Compatibilidad
1. Misma navegación y cuenta ficticia en Chrome, Edge y Firefox.
2. Registrar navegador/versión, elementos visibles, errores y captura por navegador.
3. No confundir que la página cargue con cobertura completa de compatibilidad.
