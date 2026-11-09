# Indicadores de producto, proceso y proyecto

Estos valores del informe previo son **observaciones preliminares**, no un resultado de ejecución automatizada:

- 15 evaluaciones cualitativas: 6 cumplen, 5 fallan, 4 parciales.
- Cumple: 6/15 = 40%; falla: 5/15 = 33,33%; parcial: 4/15 = 26,67%.
- 7/11 = 63,64% es cobertura documental de pantallas/funciones, **no** cobertura de casos ejecutados.

## KPI a construir después de ejecutar y documentar

| KPI | Fórmula | Numerador / denominador | Estado |
|---|---|---|---|
| Ejecución de casos | Ejecutados / planificados * 100 | Desde matriz real | Pendiente |
| Aprobación funcional | Casos PASS / casos ejecutados * 100 | No mezclar BLOCKED con PASS | Pendiente |
| Cobertura funcional | Funciones con al menos un caso ejecutado / funciones en alcance * 100 | 11 funciones en alcance | Pendiente |
| Tasa de defectos | Defectos distintos / casos ejecutados | No equivale a densidad por LOC | Pendiente |
| Trazabilidad | Casos ejecutados con evidencia / casos ejecutados * 100 | Capturas Serenity y manuales | Pendiente |
| Tiempo medio | suma de n medidas / n | DevTools Network (mismo equipo/red) | Pendiente |
| Puntualidad | Entregas a tiempo / entregas programadas * 100 | Fechas reales | Pendiente |

**LOC/Complejidad:** no se pueden medir sobre el código de ParaBank sin acceso a sus fuentes; se pueden medir sobre el repositorio de automatización, pero deben etiquetarse como métricas del código de pruebas, no del producto. **Puntos de función:** requiere definir y validar entradas/salidas/archivos/interfases y sus pesos; 11 funciones visibles no son 11 PF.
