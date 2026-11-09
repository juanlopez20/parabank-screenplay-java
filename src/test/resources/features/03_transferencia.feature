# language: es
@funcional @escritura
Característica: Transferencia entre dos cuentas de demostración
  Solo se ejecutará con cuenta de prueba y permiso explícito.

  @CP06
  Escenario: Transferencia de un monto pequeño
    Dado que el visitante abre la página principal de ParaBank
    Cuando ingresa con las credenciales de prueba configuradas
    Entonces debe visualizar el resumen de cuentas
    Cuando transfiere "1" de la cuenta "CUENTA_ORIGEN" a la cuenta "CUENTA_DESTINO"
    Entonces debe mostrar la confirmación de transferencia
