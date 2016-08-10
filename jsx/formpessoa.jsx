import React from "react";



var FormularioPessoa = React.createClass({
    getInitialState(){
    	return {
    		pessoas: [],
    		nome:"",
    		cpf:"",
            nascimento:""
    	}
    },
    handleNomeChange(e){
    	this.setState({
    		nome:e.target.value
    	});
    },
    handleCPFChange(e){
    	this.setState({
    		cpf:e.target.value
    	});
    },
     handleNascimentoChange(e){
        this.setState({
            nascimento:e.target.value
        });
    },

    getContacts () {

     jQuery.ajax({
         type: "GET",
         url: "http://localhost:8080/vraptor-blank-project/pessoas",
         contentType: "application/json; charset=utf-8",
         dataType: "json",
         success: function (data, status, jqXHR) {
             alert(data);
         },

         error: function (jqXHR, status) {
            alert("ERRO");
         }
    });
    },

    onButtonClick(){
        $.ajax({ 
           type: "POST",
           dataType: "json",
           data : JSON.stringify({
                       "login": "isalvati",
                        "status": "1", 
                        "nome": "Igor Salvati",
                        "cpf": "08903775619",
                        "dataNascimento": "01/12/1993" 
                }),
           url: "http://localhost:8080/vraptor-blank-project/pessoas",
            success: function(data){        
                alert(data);
           }
        });
    },
    handleButtonClick(){
    	var pessoa = {
    		nome:this.state.nome,
    		cpf: this.state.cpf,
            nascimento: this.state.nascimento
    	}
        
		this.setState({ 
		    pessoas: this.state.pessoas.concat([pessoa])
		});
    },
    render: function(){
     	return(
     		<div className="panel-body">
            <br />
                <form className="formPessoa">
                        <div className="input-group">
                            <span className="input-group-addon" id="basic-addon1">Nome</span>
                            <input type="text"  className="form-control" name="nome" placeholder="Ex.: Fulano de Tal" aria-describedby="basic-addon1"  onChange={this.handleNomeChange}/>
                        </div>
                        <br />
<div className="input-group">
                            <span className="input-group-addon" id="basic-addon1">CPF:</span>
                            <input type="text"  className="form-control" name="cpf" placeholder="Ex.: 000.000.000-00" aria-describedby="basic-addon1"  onChange={this.handleCPFChange}/>
                        </div>                       
                        <br />
<div className="input-group">
                            <span className="input-group-addon" id="basic-addon1">Data de Nascimento:</span>
                            <input type="text"  className="form-control" name="telefone" placeholder="Ex.: 01/01/1990" aria-describedby="basic-addon1"  onChange={this.handleNascimentoChange}/>
                        </div>
                        <br />

                    <div className="btn-group" role="group">
                         <input type="button"  className="btn btn-success" value="Cadastrar" onClick={this.onButtonClick}/>
                        <a href="./#/" type="button" className="btn btn-default">Cancelar</a> 
                    </div>

                </form>
                
                <br/>
	            {this.state.pessoas.map(pessoa =>{
	            	return (
	            		<div className="alert alert-info">
			            	<b>Nome: </b>{pessoa.nome}<br />
			                <b>CPF: </b>{pessoa.cpf}<br />
                            <b>Nascimento: </b>{pessoa.nascimento}
		                </div>
	                )
	            })
	            }
            </div>
     		);
     }
});

export default {
	FormularioPessoa: FormularioPessoa
};