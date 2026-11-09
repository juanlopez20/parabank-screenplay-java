# Registro de defectos - ParaBank

## H-01 - Visibilidad de Administration sin autenticación de cliente

- **Precondición**: navegador de incógnito, Customer Login sin usar.
- **Pasos**: abrir `https://parabank.parasoft.com/parabank/admin.htm`; observar.
- **Esperado**: el acceso a funciones administrativas sensibles debería estar protegido por autorización adecuada.
- **Observado previamente**: el recurso visual `admin.htm` respondió 200 OK y presentó Administration y controles administrativos en una sesión de cliente no autenticada.
- **Evidencias previas**: E-01 a E-04 del informe académico; E-05 a E-06 complementan contexto.
- **Alcance del hallazgo**: **NO** se ha verificado que los botones ejecuten acciones de administrador sin autorización. **NO** pulsar Initialize, Clean, Shutdown ni Submit.
- **Severidad propuesta**: Alta (requiere evaluación de impacto); **Estado**: Documentado/por verificar.
- **Relación**: CP-08, ISO 25010 Seguridad.

## Plantilla para hallazgos nuevos

H-XX / fecha / módulo / descripción / pasos / esperado / real / severidad / impacto / capturas / estado / responsable.
