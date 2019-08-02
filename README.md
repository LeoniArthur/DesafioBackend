Utilizado:Java,Maven,Jersey,Tomcat8,PostgresSql

CRUD hospede:
http://localhost:8080/Rest/restJR/hospede/createHospede<br>
EX: Entrada esperada: <br>
{<br>
	"nome": "Gustavo", <br>
        "documento": "487775448",<br>
        "telefone": "1197884552"<br>
}<br>

http://localhost:8080/Rest/restJR/hospede/readHospede<br>
//Busca por documento*<br>
EX: Entrada esperada:<br>
{<br>
	"nome": "Gustavo",<br>
        "documento": "487775448",<br>
        "telefone": "1197884552"<br>
}<br>

http://localhost:8080/Rest/restJR/hospede/updateHospede<br>
//Update por documento*<br>
EX: Entrada esperada:<br>
{<br>
	"nome": "Gustavo",<br>
        "documento": "487775448",<br>
        "telefone": "1197884552"<br>
}<br>


http://localhost:8080/Rest/restJR/hospede/deleteHospede<br>
//Delete por documento*<br>
EX: Entrada esperada:<br>
{<br>
	"nome": "Gustavo",<br>
        "documento": "487775448",<br>
        "telefone": "1197884552"<br>
}<br>

http://localhost:8080/Rest/restJR/hospede/listHospede<br>
//Busca todos os hospedes<br>


http://localhost:8080/Rest/restJR/hospede/searchHospede<br>
//Busca hospede por campo<br>
EX: Entrada esperada:<br>
{<br>
	"campo": "nome",<br>
        "dado": "Gustavo",    <br>    
}<br>

Checkin<br>
http://localhost:8080/Rest/restJR/Checkin/createCheckin<br>
//Cria um checkin<br>
EX: Entrada esperada:<br>
{<br>
        "dataEntrada": "2019-08-02T08:00:00",<br>
        "dataSaida": "2019-08-03T08:00:00",<br>
        "adicionalVeiculo": true,<br>
        "nome": "milena",<br>
        "documento": "66998877",<br>
        "telefone": "19985447788"<br>
}<br>

http://localhost:8080/Rest/restJR/Checkin/calculo<br>
//Retorna o valor da estadia<br>
EX: Entrada esperada:<br>
{<br>
        "dataEntrada": "2019-08-02T08:00:00",<br>
        "dataSaida": "2019-08-03T08:00:00",<br>
        "adicionalVeiculo": true,<br>
        "nome": "milena",<br>
        "documento": "66998877",<br>
        "telefone": "19985447788"<br>
}<br>

http://localhost:8080/Rest/restJR/Checkin/historicoHotel<br>
//Retorna todas as estadias ja finalizadas e seus preços<br>


http://localhost:8080/Rest/restJR/Checkin/atuaisHotel<br>
//Retorna todas as estadias em aberto e seus preços<br>

