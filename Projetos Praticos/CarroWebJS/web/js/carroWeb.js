function criarCarro(event){
    
    let carroNome = prompt("Qual a Marca do seu carro ?");
    let carroModelo = prompt("Qual o modelo do seu carro ?");
    let carroAnoFabricacao = prompt("Qual o ano de fabricação do seu carro ?");
    
    
    $.ajax('listarCarros',{
        
        data: {
            nome: carroNome,
            modelo: carroModelo,
            anoFabricacao: carroAnoFabricacao
        },
        dataType: 'json'
        
        }).done( (data, textStatus ) => {
            
            let $div = $( "#div-resposta" );
            $div.html( "" );
            data.forEach( carro => {
                
                //O nome do atributo que vc colocar eh o que esta sendo setado na hora de mandar o json para o front.
                
                $div.append( 
                `<div class="dados"><p>Nome: ${carro.nome}</p>`+
                `<p>Modelo: ${carro.modelo}</p>` +
                `<p>Ano Fabricação: ${carro.anoModelo}</p>` +
                `</div>` 
                );
                console.log(carro);
            });
            
            
            console.log(data);
        }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
               "Status: " + textStatus );
    });
    
}
