# SOAP-API-Sample

Para rodar o projeto, abrir uma pasta acima do projeto (exemplo Documentos/calc) e digitar no terminal:

javac calc/*.java


javac calc/APIService.java


java calc.APIService.java

(a partir daqui o servidor está na rede no endereço http://127.0.0.1:9876/calc?wsdl)


Em um novo terminal, digite: 


java calc.CalculadoraClient

