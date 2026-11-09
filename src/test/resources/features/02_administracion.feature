# language: es
@seguridad
Característica: Control de acceso a Administration
  El equipo evalúa exclusivamente la visualización pública, sin ejecutar acciones administrativas.

  @hallazgo @CP08
  Escenario: El acceso a Administration debería estar restringido
    Dado que el visitante abre Administration sin credenciales
    Entonces la interfaz administrativa debería permanecer restringida
