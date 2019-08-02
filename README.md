Utilizado:Java,Maven,Jersey,Tomcat8,PostgresSql

CRUD hospede:
http://localhost:8080/Rest/restJR/hospede/createHospede
EX: Entrada esperada:
{
	"nome": "Gustavo",
        "documento": "487775448",
        "telefone": "1197884552"
}

http://localhost:8080/Rest/restJR/hospede/readHospede
//Busca por documento*
EX: Entrada esperada:
{
	"nome": "Gustavo",
        "documento": "487775448",
        "telefone": "1197884552"
}

http://localhost:8080/Rest/restJR/hospede/updateHospede
//Update por documento*
EX: Entrada esperada:
{
	"nome": "Gustavo",
        "documento": "487775448",
        "telefone": "1197884552"
}


http://localhost:8080/Rest/restJR/hospede/deleteHospede
//Delete por documento*
EX: Entrada esperada:
{
	"nome": "Gustavo",
        "documento": "487775448",
        "telefone": "1197884552"
}

http://localhost:8080/Rest/restJR/hospede/listHospede
//Busca todos os hospedes


http://localhost:8080/Rest/restJR/hospede/searchHospede
//Busca hospede por campo
EX: Entrada esperada:
{
	"campo": "nome",
        "dado": "Gustavo",        
}
===========================================================
http://localhost:8080/Rest/restJR/Checkin/createCheckin
//Cria um checkin
EX: Entrada esperada:
{
        "dataEntrada": "2019-08-02T08:00:00",
        "dataSaida": "2019-08-03T08:00:00",
        "adicionalVeiculo": true,
        "nome": "milena",
        "documento": "66998877",
        "telefone": "19985447788"
}

http://localhost:8080/Rest/restJR/Checkin/calculo
//Retorna o valor da estadia
EX: Entrada esperada:
{
        "dataEntrada": "2019-08-02T08:00:00",
        "dataSaida": "2019-08-03T08:00:00",
        "adicionalVeiculo": true,
        "nome": "milena",
        "documento": "66998877",
        "telefone": "19985447788"
}

http://localhost:8080/Rest/restJR/Checkin/historicoHotel
//Retorna todas as estadias ja finalizadas e seus preços


http://localhost:8080/Rest/restJR/Checkin/atuaisHotel
//Retorna todas as estadias em aberto e seus preços

