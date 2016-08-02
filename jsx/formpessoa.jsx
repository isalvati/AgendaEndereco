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
     		<div className="formBox">
            <br />
	     	    <form className="formPessoa">
                     <label htmlFor="nome">Nome: </label>
			        <input type="text" 
			            placeholder="Ex: Fulano de Tal" 
                        name="nome"
	                    onChange={this.handleNomeChange} /><br /><br />
                        <label htmlFor="cpf">CPF: </label>
			        <input type="text" 
			            placeholder="Ex: 000.000.000-00"
                        name="cpf"
			            onChange={this.handleCPFChange} /><br /><br />
                        <label htmlFor="nascimento">Data de Nascimento: </label>
                    <input type="text" 
                        placeholder="Ex: 01/01/1990"
                        name="nascimento"
                        onChange={this.handleNascimentoChange} /><br /><br />
			        <input type="button" value="Cadastrar" onClick={this.handleButtonClick}/><br /><br />
	            </form>
	            {this.state.pessoas.map(pessoa =>{
	            	return (
	            		<div className="pessoaBox">
			            	Nome:{pessoa.nome}<br />
			                CPF:{pessoa.cpf}<br />
                            Nascimento:{pessoa.nascimento}<br /><br />
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