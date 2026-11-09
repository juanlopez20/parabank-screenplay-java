# language: es
@funcional
Característica: Acceso público y autenticación en ParaBank
  Como equipo de QA
  Quiero comprobar el acceso y la respuesta ante credenciales inválidas
  Para distinguir un comportamiento esperado de un defecto

  @smoke @CP00
  Escenario: La página pública muestra sus controles
    Dado que el visitante abre la página principal de ParaBank
    Entonces debe visualizar el formulario de acceso

  @smoke @CP03
  Esquema del escenario: El acceso con credenciales inválidas se rechaza
    Dado que el visitante abre la página principal de ParaBank
    Cuando intenta ingresar con el usuario "<usuario>" y la clave "<clave>"
    Entonces el sitio debe mostrar un mensaje de error de acceso

    Ejemplos:
      | usuario                   | clave             |
      | usuario_qa_no_existe_999  | clave_incorrecta  |

  @autenticado @CP02
  Escenario: Un usuario de prueba válido consulta su resumen
    Dado que el visitante abre la página principal de ParaBank
    Cuando ingresa con las credenciales de prueba configuradas
    Entonces debe visualizar el resumen de cuentas

  @autenticado @CP05
  Escenario: El usuario consulta Accounts Overview desde el menú
    Dado que el visitante abre la página principal de ParaBank
    Cuando ingresa con las credenciales de prueba configuradas
    Cuando abre Accounts Overview desde el menú
    Entonces debe visualizar el resumen de cuentas

  @autenticado @CP12
  Escenario: El usuario cierra sesión
    Dado que el visitante abre la página principal de ParaBank
    Cuando ingresa con las credenciales de prueba configuradas
    Cuando cierra la sesión
    Entonces debe visualizar el formulario de acceso
