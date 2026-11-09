# language: es
@funcional @escritura
Característica: Alta de usuario de demostración en ParaBank
  Solo crear cuentas ficticias bajo autorización del equipo.

  @CP01
  Escenario: Registrar un cliente ficticio con datos completos
    Dado que el visitante abre la página principal de ParaBank
    Cuando registra un nuevo cliente ficticio
    Entonces debe ver la confirmación de registro
