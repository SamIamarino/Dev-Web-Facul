function criarFruta(event){
    
    let frutaNome = prompt("Qual o nome da sua fruta ?");
    let frutaCor = prompt("Qual a cor da sua fruta ?");
    
    
    $.ajax('frutaServlet',{
        
        data: {
            nome: frutaNome,
            cor: frutaCor  
        },
        dataType: 'json'
        
        }).done( (data, textStattus ) => {
            
            let $div = $( "#div-resposta" );
            $div.html( "" );
            data.forEach( fruta => {
                $div.append( 
                `<div class="dados"><p>Nome: ${fruta.nome}</p>`+
                `<p>Cor: ${fruta.cor}</p>` +
                `</div>` 
                );
            });
            
            
            console.log(data);
        }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
               "Status: " + textStatus );
    });
    
}
