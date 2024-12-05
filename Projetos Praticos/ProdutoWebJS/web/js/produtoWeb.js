function criarProduto(event){
    
    
    let produtoDescricao = prompt("Descreva seu produto ?");
    let produtoQuantidade = prompt("Qual a quantidade do seu produto ?");
    
    
    $.ajax('listarProdutos',{
        
        data: {
    
            descricao: produtoDescricao,
            quantidade: produtoQuantidade
        },
        dataType: 'json'
        
        }).done( (data, textStatus ) => {
            
            let $div = $( "#div-resposta" );
            $div.html( "" );
            data.forEach( produto => {
                
                //O nome do atributo que vc colocar eh o que esta sendo setado na hora de mandar o json para o front.
                
                $div.append( 
                `<div class="dados"><p>Descricao: ${produto.descricao}</p>`+
                `<p>Quantidade: ${produto.quantidade}</p>` +
                `</div>` 
                );
                console.log(produto);
            });
            
            
            console.log(data);
        }).fail( ( jqXHR, textStatus, errorThrown ) => {
        alert( "Erro: " + errorThrown + "\n" +
               "Status: " + textStatus );
    });
    
}
