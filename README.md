# Teste Java Full-Stack

## Dependências

- [MySQL Server 8+](https://dev.mysql.com/downloads/mysql/)
- [WildFly 35+](https://www.wildfly.org/downloads/)
- [Java 17+](https://adoptium.net/temurin/releases/)
- [MySQL Connector/J 8.0.33](https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.0.33/) (Plataforma Independente)

## Configuração do Ambiente

#### Legenda
- `$WILDFLY_HOME` = Local de instalação do Wildfly

### 1. Instalação do MySQL Connector/J
Baixe o [mysql-connector-j-8.0.33.jar](https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.0.33/) e copie-o para:

```
$WILDFLY_HOME/modules/system/layers/base/com/mysql/main
```
Caso a pasta `/mysql/main` não exista, então crie ela.

Dentro da pasta `main`, crie o arquivo `module.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.9" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-j-8.0.33.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
```

### 2. Configuração do WildFly
Edite o arquivo:

```
$WILDFLY_HOME/standalone/configuration/standalone.xml
```

#### Adicione o datasource dentro da tag `<datasources>...</datasources>`:

```xml
<datasource jndi-name="java:/teste-fullstack" pool-name="teste-fullstack" enabled="true" use-java-context="true">
    <connection-url>jdbc:mysql://localhost:3306/teste-fullstack?createDatabaseIfNotExist=true&amp;serverTimezone=UTC</connection-url>
    <driver>mysql</driver>
    <pool>
        <min-pool-size>5</min-pool-size>
        <max-pool-size>15</max-pool-size>
    </pool>
    <security user-name="root" password="admin"/>
    <validation>
        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
        <validate-on-match>true</validate-on-match>
        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
    </validation>
</datasource>
```
> **Atenção:** troque o valor de `user-name` e `password` para as credenciais do seu servidor MySQL.

#### Adicione o driver dentro da tag `<drivers>...</drivers>`:

```xml
<driver name="mysql" module="com.mysql">
    <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
</driver>
```

### 3. Inicialização do Servidor
No diretório do WildFly, execute:

```bash
$WILDFLY_HOME/bin/standalone.sh   # Linux/Mac
$WILDFLY_HOME/bin/standalone.bat  # Windows
```

### 4. Deploy da Aplicação
No diretório do projeto, execute:

```bash
./mvnw clean
./mvnw wildfly:deploy
```

### Observações
- Certifique-se de que o banco MySQL está em execução antes de iniciar o WildFly.
- As credenciais do banco podem ser ajustadas diretamente no `standalone.xml`.  


### Vídeo do Projeto

https://github.com/user-attachments/assets/3e3bcaaa-4ec3-4282-a36f-0c98979060ce




